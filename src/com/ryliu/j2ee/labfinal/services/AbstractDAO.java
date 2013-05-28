package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.utils.ConnectionFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO<T> {
    public abstract T generateFromRequest(HttpServletRequest request);

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    protected int executeUpdate(String sql, Object[] params) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; ++i) {
                statement.setObject(i + 1, params[i]);
            }
            return statement.executeUpdate();
        } finally {
            close();
        }
    }

    protected void executeQuery(String sql, Object[] params, RowCallbackHandler handler)  throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; ++i) {
                statement.setObject(i + 1, params[i]);
            }
            result = statement.executeQuery();
            while (result.next()) {
                handler.processRow(result);
            }
        } finally {
            close();
        }
    }

    /**
     * Close all the resources.
     */
    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException e) {
            // ignore
        }
    }

}
