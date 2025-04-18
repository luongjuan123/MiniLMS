package com.Schoolar.minilms.model.course.material;

public class Material {
    private String MaterialName;
    private String MaterialDescription;
    private String MaterialID;
    private MaterialType materialType;
    private String title;

    public Material(String MaterialName, String MaterialDescription, String MaterialID, String title) {}

    public Material(String MaterialName, String MaterialDescription, String MaterialID, String title, MaterialType materialType) {
        this.MaterialName = MaterialName;
        this.MaterialDescription = MaterialDescription;
        this.MaterialID = MaterialID;
        this.title = title;
        this.materialType = materialType;
    }

}
