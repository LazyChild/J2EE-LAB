package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.labfinal.models.UploadFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * The upload file data access object.
 */
public class UploadFileDAO extends AbstractDAO<UploadFile> {

    /**
     * Represents the max file size allowed to upload. (Default 2MB)
     */
    private static final long MAX_FILE_SIZE = 2097152;

    private final ServletContext servletContext;

    public UploadFileDAO(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * Get the upload file according to its id.
     *
     * @param id the id
     * @return the upload file
     * @throws SQLException if any SQL issue occurred.
     */
    public UploadFile get(int id) throws SQLException {
        final UploadFile file = new UploadFile();
        executeQuery("SELECT (id, file_name, upload_date, key_code) FROM file_upload WHERE id = " + id,
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
     * Perform the download action.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws SQLException if any issue occurred.
     */
    public void download(HttpServletRequest request, final HttpServletResponse response) throws SQLException {
        String key = request.getParameter("key");

        executeQuery("SELECT file_name, content FROM file_upload WHERE key_code = '" + key + "'", null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                try {
                    String fileName = resultSet.getString("file_name");
                    InputStream inputStream = resultSet.getBinaryStream("content");

                    String mimeType = servletContext.getMimeType(fileName);
                    if (mimeType == null) {
                        mimeType = "application/octet-stream";
                    }

                    response.setContentType(mimeType);
                    response.setContentLength(inputStream.available());
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                    response.setHeader(headerKey, headerValue);

                    IOUtils.copy(inputStream, response.getOutputStream());
                } catch (IOException e) {
                    throw new SQLException("IO exception occurred.", e);
                }
            }
        });
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

        File repository  =(File) servletContext.getAttribute("javax.servlet.context.tempdir");
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
        return RandomStringUtils.random(10, true, true).toUpperCase();
    }
}
