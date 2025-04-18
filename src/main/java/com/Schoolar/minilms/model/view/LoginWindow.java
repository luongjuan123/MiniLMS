package com.Schoolar.minilms.model.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginWindow() {
        // Thiết lập cửa sổ chính
        setTitle("MiniLMS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setResizable(false);

        // Tạo panel chính với gradient background
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
        mainPanel.setLayout(null); // Sử dụng layout tuyệt đối để kiểm soát vị trí
        setContentPane(mainPanel);

        // Logo hoặc tiêu đề
        JLabel logoLabel = new JLabel("Schoolar", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 36));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setBounds(0, 30, 400, 50);
        mainPanel.add(logoLabel);

        // Nhãn và trường nhập Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(50, 100, 100, 30);
        mainPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField.setBounds(50, 130, 300, 40);
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        mainPanel.add(usernameField);

        // Nhãn và trường nhập Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(50, 180, 100, 30);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(50, 210, 300, 40);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        mainPanel.add(passwordField);

        // Nhãn thông báo lỗi
        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        errorLabel.setForeground(new Color(255, 99, 71));
        errorLabel.setBounds(50, 260, 300, 30);
        mainPanel.add(errorLabel);

        // Nút Login
        JButton loginButton = new JButton("Login") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(46, 204, 113));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setBounds(50, 300, 300, 40);
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(false);

        // Hiệu ứng hover cho nút Login
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(39, 174, 96));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(46, 204, 113));
            }
        });

        // Xử lý sự kiện khi nhấn nút Login
        loginButton.addActionListener(e -> handleLogin());
        mainPanel.add(loginButton);

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password.");
            return;
        }

        // Giả lập gọi AuthenticationService (thay thế bằng mã thực khi có)
        try {
            // Ví dụ: AuthenticationService authService = new AuthenticationService();
            // boolean isAuthenticated = authService.login(username, password);
            boolean isAuthenticated = true; // Giả lập đăng nhập thành công

            if (isAuthenticated) {
                // Đóng cửa sổ đăng nhập và mở MainWindow
                dispose();
                new MainWindow(); // Giả định MainWindow đã được định nghĩa
            } else {
                errorLabel.setText("Invalid username or password.");
            }
        } catch (Exception ex) {
            errorLabel.setText("An error occurred. Please try again.");
        }
    }

//    public static void main(String[] args) {
//        // Đảm bảo giao diện chạy trên Event Dispatch Thread
//        SwingUtilities.invokeLater(LoginWindow::new);
//    }
}