package com.Schoolar.minilms.model.course.material;

public enum MaterialType {
    DOCUMENT("Tài liệu"),   // Cho các file như PDF, DOCX, PPTX,...
    VIDEO("Video"),         // Cho các tệp video hoặc luồng video
    LINK("Liên kết ngoài"), // Cho các đường dẫn URL tới nguồn bên ngoài
    TEXT("Nội dung Text");  // Cho nội dung văn bản thuần túy hoặc HTML/Markdown nhúng trực tiếp

    private final String displayName;

    MaterialType(String displayName) {
        this.displayName = displayName;
    }


    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        // Mặc định trả về tên hằng số (DOCUMENT, VIDEO,...)
        // return this.name();
        // Hoặc trả về tên hiển thị
        return displayName;
    }
}
