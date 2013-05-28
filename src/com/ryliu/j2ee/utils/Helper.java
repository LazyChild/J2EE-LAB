package com.ryliu.j2ee.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The utility of this whole project.
 */
public final class Helper {

    private Helper() {
        // empty
    }

    /**
     * Create an instance of the given class from the request by using Java reflection.
     *
     * @param klass   the class type
     * @param request the HTTP servlet request
     * @param <T>     the return type
     * @return the generated instance
     */
    public static <T> T getFromRequest(Class<T> klass, HttpServletRequest request) {
        T result = null;
        try {
            Field[] fields = klass.getDeclaredFields();
            result = klass.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(result, getParameter(request, field.getName()));
                field.setAccessible(false);
            }
        } catch (InstantiationException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        }
        return result;
    }

    /**
     * Get the parameter value from the HTTP servlet request.
     *
     * @param request the HTTP servlet request
     * @param key the parameter key
     * @return the parameter value
     */
    private static String getParameter(HttpServletRequest request, String key) {
        String result = null;
        try {
            result = request.getParameter(key);
            result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // ignore
        }
        return result;
    }

    /**
     * Set the Java bean into prepared statement by using Java reflection.
     *
     * @param obj the source object
     * @param statement the prepared statement
     * @param <T> the type of the object
     */
    public static <T> void setStatement(T obj, PreparedStatement statement) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; ++i) {
                Field field = fields[i];
                field.setAccessible(true);
                statement.setObject(i + 1, field.get(obj));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            // ignore
        } catch (SQLException e) {
            // ignore
        }
    }

    /**
     * Get the result from result set by using Java reflection.
     *
     * @param klass the class of the return object
     * @param resultSet the result set
     * @param <T> the type of the object
     * @return the object
     */
    public static <T> T getResult(Class<T> klass, ResultSet resultSet) {
        T result = null;
        try {
            result = klass.newInstance();
            Field[] fields = klass.getDeclaredFields();
            for (int i = 0; i < fields.length; ++i) {
                Field field = fields[i];
                field.setAccessible(true);
                field.set(result, resultSet.getObject(i + 1));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            // ignore
        } catch (SQLException e) {
            // ignore
        } catch (InstantiationException e) {
            // ignore
        }
        return result;
    }
}
