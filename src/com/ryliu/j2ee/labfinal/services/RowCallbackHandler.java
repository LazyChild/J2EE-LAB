package com.ryliu.j2ee.labfinal.services;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The row callback handler
 */
public abstract class RowCallbackHandler {
    /**
     * Process each row with this method.
     *
     * @param resultSet the result set
     * @throws SQLException if any issue occurred.
     */
    public abstract void processRow(ResultSet resultSet) throws SQLException;
}
