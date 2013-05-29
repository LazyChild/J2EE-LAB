package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.labfinal.models.UploadFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.RandomStringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UploadFileDAO extends AbstractDAO<UploadFile> {

    /**
     * Represents the max file size allowed to upload. (Default 2MB)
     */
    private static final long MAX_FILE_SIZE = 2097152;

    /**
     * Represents the temporary folder to restore the upload file.
     */
    private File repository;

    public void setRepository(File repository) {
        this.repository = repository;
    }

    public UploadFile get(int id) throws SQLException {
        final UploadFile file = new UploadFile();
        executeQuery("SELECT (id, file_name, upload_date, key_code) from file_upload WHERE id = " + id,
                null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                file.setId(resultSet.getInt("id"));
                file.setFileName(resultSet.getString("file_name"));
                file.setUploadDate(resultSet.getDate("upload_date"));
                file.setKeyCode(resultSet.getString("key_code"));
            }
        });
        return file;
    }

    /**
     * Generate the file from request and write it into database.
     *
     * @param request the HTTP servlet request
     * @return the upload file
     * @throws ServletException if any issue occurred.
     * @throws IOException      if any IO issue occurred.
     */
    @Override
    public UploadFile generateFromRequest(HttpServletRequest request) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setRepository(repository);
        factory.setSizeThreshold(4096);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setHeaderEncoding("UTF-8");

        try {
            List<FileItem> items = upload.parseRequest(request);
            int id = 0;
            for (final FileItem item : items) {
                if (!item.isFormField()) {
                    id = executeUpdate("INSERT INTO file_upload (file_name, content, upload_date, key_code) VALUES (?, ?, ?, ?)", new StatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps) throws SQLException {
                            try {
                                int index = 0;
                                ps.setString(++index, item.getName());
                                ps.setBinaryStream(++index, item.getInputStream(), item.getSize());
                                ps.setTimestamp(++index, new Timestamp(new Date().getTime()));
                                ps.setString(++index, generateKey());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    break;
                }
            }
            return id == 0 ? null : get(id);
        } catch (FileUploadException e) {
            throw new ServletException("Error while upload file.", e);
        } catch (SQLException e) {
            throw new ServletException("SQL error occurred.", e);
        }
    }

    /**
     * Generate the hash key of file.
     *
     * @return the key
     */
    private static String generateKey() {
        return RandomStringUtils.random(7, true, true).toUpperCase();
    }
}
