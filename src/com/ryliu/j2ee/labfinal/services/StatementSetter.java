package com.ryliu.j2ee.labfinal.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class StatementSetter {
    public abstract void setValues(PreparedStatement ps) throws SQLException;
}
