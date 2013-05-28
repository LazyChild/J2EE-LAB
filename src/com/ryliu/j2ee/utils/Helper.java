package com.ryliu.j2ee.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * The utility of this whole project.
 */
public final class Helper {

    private Helper() {
        // empty
    }

    /**
     * Get the parameter value from the HTTP servlet request.
     *
     * @param request the HTTP servlet request
     * @param key the parameter key
     * @return the parameter value
     */
    public static String getParameter(HttpServletRequest request, String key) {
        String result = null;
        try {
            result = request.getParameter(key);
            result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // ignore
        }
        return result;
    }
}
