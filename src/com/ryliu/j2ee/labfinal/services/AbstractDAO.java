package com.ryliu.j2ee.labfinal.services;

import com.ryliu.j2ee.utils.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;

/**
 * The abstract DAO class.
 *
 * @param <T> the type
 */
public abstract class AbstractDAO<T> {
    public abstract T generateFromRequest(HttpServletRequest request) throws ServletException, IOException;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;


    /**
     * Execute the update SQL.
     *
     * @param sql the sql
     * @param setter the setter
     * @return the count
     * @throws SQLException if any issue occurred.
     */
    protected int executeUpdate(String sql, StatementSetter setter) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (setter != null) {
                setter.setValues(statement);
            }
            statement.executeUpdate();
            ResultSet key = statement.getGeneratedKeys();
            if (key.next()) {
                return key.getInt(1);
            } else {
                return 0;
            }
        } finally {
            close();
        }
    }

    /**
     * Execute the query sql.
     *
     * @param sql the sql
     * @param setter the statement setter
     * @param handler the callback handler
     * @throws SQLException if any issue occurred.
     */
    protected void executeQuery(String sql, StatementSetter setter, RowCallbackHandler handler)  throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            if (setter != null) {
                setter.setValues(statement);
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
