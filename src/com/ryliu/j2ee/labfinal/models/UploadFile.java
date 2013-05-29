package com.ryliu.j2ee.labfinal.models;

import java.util.Date;

/**
 * The upload file java bean.
 */
public class UploadFile {
    private int id;
    private String fileName;
    private Date uploadDate;
    private String keyCode;

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
}
