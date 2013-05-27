package com.ryliu.j2ee.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Helper {

    private Helper() {
        // empty
    }

    /**
     * Create an instance of the given class from the request.
     *
     * @param klass the class type
     * @param request the HTTP servlet request
     * @param <T> the return type
     * @return the generated instance
     */
    public static <T> T getFromRequest(Class<T> klass, HttpServletRequest request) {
        T result = null;
        try {
            Field[] fields = klass.getDeclaredFields();
            result = klass.newInstance();
            for (Field field: fields) {
                field.setAccessible(true);
                field.set(field.getName(), request.getParameter(field.getName()));
                field.setAccessible(false);
            }
        } catch (InstantiationException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        }
        return result;
    }

    public static <T> void setStatement(T obj, PreparedStatement statement) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; ++i) {
                Field field = fields[i];
                field.setAccessible(true);
                statement.setObject(i, field.get(obj));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            // ignore
        } catch (SQLException e) {
            // ignore
        }
    }
}
