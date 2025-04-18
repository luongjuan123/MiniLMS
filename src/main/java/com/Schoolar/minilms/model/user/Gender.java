package com.Schoolar.minilms.model.user;

public enum Gender {
    NAM("Male"),       // Tương ứng với Male
    NU("Female"),;        // Tương ứng với Female


    private final String displayName; // Thêm thuộc tính để có tên hiển thị đẹp (tùy chọn)

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        // Có thể override toString để trả về tên hiển thị nếu muốn
        return displayName;
        // Hoặc giữ nguyên mặc định: return name(); // Trả về "NAM", "NU", "KHAC"
    }
}
