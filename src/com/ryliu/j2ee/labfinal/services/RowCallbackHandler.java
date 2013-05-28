package com.ryliu.j2ee.labfinal.services;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RowCallbackHandler {
    public abstract void processRow(ResultSet resultSet) throws SQLException;
}
