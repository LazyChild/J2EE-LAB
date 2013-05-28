package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.labfinal.models.UploadFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadFileDAO extends AbstractDAO<UploadFile> {

    private File repository;

    public File getRepository() {
        return repository;
    }

    public void setRepository(File repository) {
        this.repository = repository;
    }

    @Override
    public UploadFile generateFromRequest(HttpServletRequest request) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setRepository(repository);
        factory.setSizeThreshold(4096);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(2097152);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) continue;
                String sql = "INSERT INTO file_upload VALUES(NULL, NULL, ?, ?)";
                exe
                item.getInputStream();
            }
        } catch (FileUploadException e) {
            throw new ServletException("Error while upload file.", e);
        }
    }
}
