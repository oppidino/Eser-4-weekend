package com.uiip.interfaces.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.uiip.interfaces.PhoneDAO;
import com.uiip.models.PhoneModel;

import static com.uiip.interfaces.impl.DefaultPersonDAO.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;

public class DefaultPhoneDAO implements PhoneDAO {

    public PhoneModel getPhoneInfo(String tipo) {
        PhoneModel toReturn = new PhoneModel();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT id, tipo, brand, opsys "
                    + "FROM telefono WHERE tipo = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            ResultSet res = stmt.executeQuery();
            if (res.first()) {
                toReturn.setName(res.getString("tipo"));
                toReturn.setBrand(res.getString("brand"));
                toReturn.setOpsys(res.getString("opsys"));
            } else {
                toReturn = null;
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return toReturn;
    }

    public boolean insertPhone(PhoneModel phoneModel) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO telefono (tipo, brand, opsys) VALUE "
                    + "(?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneModel.getName());
            stmt.setString(2, phoneModel.getBrand());
            stmt.setString(3, phoneModel.getOpsys());
            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
    }

}
