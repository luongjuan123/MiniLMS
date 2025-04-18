package com.Schoolar.minilms.model.user;

public enum Role {
    STUDENT("Sinh viên"),
    COURSE_MANAGER("Quản lý khóa học"), // Tên vai trò tương ứng với lớp CourseManager
    ADMIN("Quản trị viên");

    private final String description; // Mô tả vai trò (tùy chọn)

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name(); // Trả về tên hằng số: "STUDENT", "COURSE_MANAGER", "ADMIN"
        // Hoặc: return this.description; // Nếu muốn toString trả về mô tả
    }
}
