
# 📘 MiniLMS - Hệ thống quản lý học tập nhỏ

**MiniLMS** là một ứng dụng Java đơn giản giúp quản lý các khóa học trực tuyến, hỗ trợ nhiều vai trò người dùng như **Sinh viên**, **Quản lý khóa học (Course Manager)** và **Quản trị viên (Admin)**. Ứng dụng sử dụng **Java Swing** để xây dựng giao diện và được thiết kế theo **mô hình phân tầng** để dễ mở rộng, bảo trì.

---

## 🎯 Mục tiêu dự án

- **Sinh viên**:
  - Xem danh sách khóa học đã đăng ký
  - Truy cập tài liệu học tập
  - Nộp bài tập
  - Xem điểm

- **Quản lý khóa học**:
  - Tạo và quản lý khóa học
  - Tải lên tài liệu
  - Chấm điểm bài tập

- **Quản trị viên**:
  - Quản lý người dùng và hệ thống

---

## ✨ Tính năng chính

- Đăng nhập/Đăng xuất
- Quản lý khóa học, module, bài học, tài liệu
- Quản lý bài tập, bài nộp, và điểm số
- Làm bài tập, giao bài tập, chấm điểm

---

## 🚧 Trạng thái hiện tại

### ✅ Hoàn thành
- `LoginWindow`: giao diện đăng nhập đẹp với gradient, username/password, nút Login
- `MainWindow`: giao diện chính với sidebar điều hướng, header người dùng, các panel placeholder
- `Main.java`: lớp khởi chạy ứng dụng

### 🚧 Đang phát triển
- **Tầng model**: `User`, `Course`, `Material`, `Assignment`,...
- **Tầng service**: `AuthenticationService`, `CourseService`,...
- **Tầng persistence**: lưu trữ dữ liệu vào file

### ⏳ Chưa bắt đầu
- Tích hợp đăng nhập thực tế qua `AuthenticationService`
- Giao diện chi tiết như `StudentDashboardPanel`, `CourseViewPanel`

---

## 📁 Cấu trúc thư mục

```
src/
└── main/
    └── java/
        └── com.schoolar.minilms/
            ├── Main.java
            ├── model/
            │   ├── user/ (User, Student, Admin, etc.)
            │   ├── course/ (Course, Module, Lesson, Material)
            │   └── assignment/ (Assignment, Submission, Grade)
            ├── view/ (LoginWindow, MainWindow, ... )
            ├── controller/ (AuthController, CourseController, ...)
            ├── service/ (AuthenticationService, CourseService, ...)
            ├── persistence/
            │   ├── dao/
            │   └── impl/
            └── util/ (PasswordUtils, FileUtils, ...)
```

---

## 💻 Yêu cầu hệ thống

- **JDK**: 11 trở lên
- **IDE**: IntelliJ IDEA (khuyến nghị) hoặc Eclipse
- **HĐH**: Windows / macOS / Linux

---

## 🚀 Hướng dẫn thiết lập & chạy

1. **Clone dự án**:
   ```bash
   git clone <repository-url>
   ```

2. **Mở trong IntelliJ IDEA**:
   - File > Open > Chọn thư mục dự án
   - Đảm bảo `src/main/java` được đánh dấu là **Sources Root**

3. **Chạy ứng dụng**:
   - Mở `Main.java` tại `com.schoolar.minilms`
   - Click chuột phải > Run `'Main.main()'`

4. **Kiểm tra giao diện**:
   - Nhập username/password bất kỳ tại LoginWindow
   - Truy cập MainWindow giả lập với sidebar và thông tin user mẫu "John Doe, STUDENT"

---

## 🤝 Hướng dẫn đóng góp
### Các bạn có thể dùng *github desktop* cho dễ sử dụng

### 1. Tạo nhánh mới
```bash
git checkout -b feature/<ten-tinh-nang>
```

### 2. Phân công công việc
- **Model**: Hoàn thiện `User`, `Course`, `Material`, `Assignment`, ...
- **Persistence**: Viết `UserDao`, `CourseDao` lưu dữ liệu vào file
- **Service**: `AuthenticationService`, `CourseService`, v.v.
- **View**: Thay thế các `placeholder panel`
- **Util**: Viết `PasswordUtils`, `FileUtils`, ...

### 3. Viết mã rõ ràng
- Đặt đúng package theo cấu trúc
- Thêm comment cho các phương thức quan trọng

### 4. Kiểm tra & Pull Request
```bash
git push origin feature/<ten-tinh-nang>
```

- Tạo pull request vào nhánh `main`, ghi rõ nội dung thay đổi

---

## 📅 Kế hoạch phát triển

### Giai đoạn 1: Model
- Enum: `Role`, `Gender`, `MaterialType`
- Entity: `User`, `Course`, `Assignment`, ...

### Giai đoạn 2: Persistence
- DAO dùng file dùng MySQL

### Giai đoạn 3: Service
- Thực hiện đăng nhập thực tế
- Thêm logic quản lý khóa học, bài tập

### Giai đoạn 4: View
- Hoàn thiện các panel chi tiết
- Cải thiện UI (icon, hiệu ứng)

### Giai đoạn 5: Tích hợp & Kiểm thử
- Kiểm tra toàn bộ luồng từ đăng nhập → nộp bài tập

---

## 📬 Liên hệ

- Nhóm phát triển: _Nhóm 13
- Góp ý/Báo lỗi: Tạo issue trên repository hoặc liên hệ trực tiếp trưởng nhóm

---

> **Lưu ý:** Đây là dự án nhóm. Giao tiếp thường xuyên để tránh xung đột mã và đảm bảo tiến độ!
