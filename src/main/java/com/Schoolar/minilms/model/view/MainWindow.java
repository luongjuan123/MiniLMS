package minilms.model.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    private JPanel contentPanel;
    private JLabel roleLabel;
    private JLabel usernameLabel;
    private CardLayout cardLayout;
    private final String userRole; // Giả lập vai trò người dùng
    private final String username; // Giả lập tên người dùng

    public MainWindow() {
        // Giả lập thông tin người dùng (thay bằng dữ liệu thực từ AuthenticationService)
        this.username = "John Doe";
        this.userRole = "STUDENT"; // Có thể là "COURSE_MANAGER" hoặc "ADMIN"

        // Thiết lập cửa sổ chính
        setTitle("MiniLMS - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setMinimumSize(new Dimension(800, 500));

        // Panel chính với gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(100, 181, 246), 0, getHeight(), new Color(44, 62, 80));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);

        // Thanh tiêu đề (Header)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Logo MiniLMS
        JLabel logoLabel = new JLabel("MiniLMS", SwingConstants.LEFT);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(Color.WHITE);
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Thông tin người dùng
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userInfoPanel.setOpaque(false);

        usernameLabel = new JLabel("Welcome, " + username);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.WHITE);
        userInfoPanel.add(usernameLabel);

        roleLabel = new JLabel("(" + userRole + ")");
        roleLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        roleLabel.setForeground(new Color(200, 200, 200));
        userInfoPanel.add(roleLabel);

        JButton logoutButton = createStyledButton("Logout", new Color(231, 76, 60));
        logoutButton.addActionListener(e -> handleLogout());
        userInfoPanel.add(logoutButton);

        headerPanel.add(userInfoPanel, BorderLayout.EAST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Thanh điều hướng (Sidebar)
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        sidebarPanel.setOpaque(false);
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Các nút điều hướng
        String[] menuItems = getMenuItemsForRole();
        for (String item : menuItems) {
            JButton button = createStyledButton(item, new Color(46, 204, 113));
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            button.addActionListener(e -> switchPanel(item));
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        // Khu vực nội dung chính
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Thêm các panel placeholder
        contentPanel.add(createDashboardPanel(), "Dashboard");
        contentPanel.add(createCoursesPanel(), "Courses");
        if (userRole.equals("COURSE_MANAGER") || userRole.equals("ADMIN")) {
            contentPanel.add(createAssignmentsPanel(), "Assignments");
        }
        if (userRole.equals("ADMIN")) {
            contentPanel.add(createUsersPanel(), "Users");
        }

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Tạo nút với phong cách bo tròn và hiệu ứng hover
    private JButton createStyledButton(String text, Color baseColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(baseColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        // Hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(baseColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });

        return button;
    }

    // Xác định các mục menu dựa trên vai trò
    private String[] getMenuItemsForRole() {
        switch (userRole) {
            case "ADMIN":
                return new String[]{"Dashboard", "Courses", "Assignments", "Users"};
            case "COURSE_MANAGER":
                return new String[]{"Dashboard", "Courses", "Assignments"};
            case "STUDENT":
            default:
                return new String[]{"Dashboard", "Courses"};
        }
    }

    // Chuyển đổi giữa các panel
    private void switchPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

    // Xử lý đăng xuất
    private void handleLogout() {
        dispose();
        new LoginWindow();
    }

    // Placeholder cho panel Dashboard
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to your " + userRole + " Dashboard", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Placeholder cho panel Courses
    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Courses List", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Placeholder cho panel Assignments
    private JPanel createAssignmentsPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Assignments Management", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Placeholder cho panel Users (chỉ dành cho Admin)
    private JPanel createUsersPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Users Management", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(MainWindow::new);
//    }
}