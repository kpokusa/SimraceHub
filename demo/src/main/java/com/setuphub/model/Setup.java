package com.setuphub.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity

@Data
public class Setup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    @Lob
    private byte[] fileName;
    @CreationTimestamp
    private Date uploadedAt;

    public Setup() {
    }

    public Setup(Long id, String description, byte[] fileName, Date uploadedAt) {
        this.id = id;
        this.description = description;
        this.fileName = fileName;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFileName() {
        return fileName;
    }

    public void setFileName(byte[] fileName) {
        this.fileName = fileName;
    }

    public Date getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    @Override
    public String toString() {
        return "Setup{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", fileName=" + Arrays.toString( fileName ) +
                ", uploadedAt=" + uploadedAt +
                '}';
    }
}
