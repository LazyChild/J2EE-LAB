package com.ryliu.j2ee.labfinal.models;

import java.util.Date;

/**
 * The upload file java bean.
 */
public class UploadFile {
    private int id;
    private String fileName;
    private Long fileSize;
    private Integer ownerId;
    private String ownerName;
    private Date uploadDate;
    private String keyCode;
    private Integer downloadTime;

    public Integer getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Integer downloadTime) {
        this.downloadTime = downloadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
