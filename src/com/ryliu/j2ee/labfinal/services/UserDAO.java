package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.labfinal.models.Role;
import com.ryliu.j2ee.labfinal.models.User;
import com.ryliu.j2ee.utils.Helper;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The user database access object.
 */
public class UserDAO extends AbstractDAO<User> {
    /**
     * Generate user from request.
     *
     * @param request the HTTP servlet request
     * @return the user
     * @throws ServletException if any issue occurred.
     * @throws IOException      if any IO issue occurred.
     */
    @Override
    public User generateFromRequest(final HttpServletRequest request) throws SQLException, IOException {
        int id = executeUpdate("INSERT INTO user VALUES (NULL, ?, ?, ?, 0, ?)", new StatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int index = 0;
                ps.setString(++index, request.getParameter("email"));
                ps.setString(++index, DigestUtils.md5Hex(request.getParameter("password")));
                ps.setString(++index, Helper.getParameter(request, "address"));
                ps.setString(++index, Helper.getParameter(request, "name"));
            }
        });
        return id == 0 ? null : get(id);
    }

    /**
     * Get the user according to its id.
     *
     * @param id the id
     * @return the user
     * @throws SQLException if any issue occurred.
     */
    public User get(int id) throws SQLException {
        final User user = new User();
        executeQuery("SELECT * FROM user WHERE id = " + id, null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role") == 0 ? Role.USER : Role.ADMIN);
                user.setAddress(resultSet.getString("address"));
                user.setName(resultSet.getString("name"));
            }
        });
        return user;
    }

    /**
     * Get the user according to its email.
     *
     * @param email the email
     * @return the user
     * @throws SQLException if any issue occurred.
     */
    public User getByEmail(String email) throws SQLException {
        final User user = new User();
        executeQuery("SELECT * FROM user WHERE email = '" + email + "'", null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role") == 0 ? Role.USER : Role.ADMIN);
                user.setAddress(resultSet.getString("address"));
                user.setName(resultSet.getString("name"));
            }
        });
        return user;
    }

    public void update(int id, final String name, final String address) throws SQLException {
        executeUpdate("UPDATE user SET name = ?, address = ? WHERE id = " + id, new StatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int index = 0;
                ps.setString(++index, name);
                ps.setString(++index, address);
            }
        });
    }
}
