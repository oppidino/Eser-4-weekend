package com.uiip.interfaces.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.uiip.interfaces.PersonDAO;
import com.uiip.models.PersonModel;
import com.uiip.models.PhoneModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

public class DefaultPersonDAO implements PersonDAO {

    final static Logger logger = Logger.getLogger(DefaultPersonDAO.class);

    public PersonModel getPersonInfo(String phoneNumber) {
        PersonModel personModel = new PersonModel();
        PhoneModel phone = new PhoneModel();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT p.nome, p.cognome, p.data_nascita, p.citta, t.tipo "
                    + "FROM persona p INNER JOIN telefono t ON (p.modello = t.id) "
                    + "WHERE p.numero_tel = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet res = stmt.executeQuery();
            if (res.first()) {
                personModel.setName(res.getString("nome"));
                personModel.setSurname(res.getString("cognome"));
                personModel.setDate(res.getString("data_nascita"));
                personModel.setCity(res.getString("citta"));
                personModel.setPhoneNumber(phoneNumber);
                phone.setName(res.getString("tipo"));
                personModel.setModel(phone);
            } else {
                personModel = null;
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return personModel;
    }

    public boolean updatePersonInfo(String phoneNumber, String city) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "UPDATE persona SET citta = ? WHERE numero_tel = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, city);
            stmt.setString(2, phoneNumber);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
    }

    public boolean insertPerson(PersonModel personModel, String nomePhone) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO persona (numero_tel, nome, cognome, data_nascita, citta, modello) VALUE "
                    + "(?, ?, ?, ?, ?, ?);";
            int id;
            String sql2 = "SELECT id FROM telefono WHERE tipo = ? ;";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, nomePhone);
            ResultSet res = stmt2.executeQuery();
            if (res.first()) {
                id = res.getInt("id");
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, personModel.getPhoneNumber());
                stmt.setString(2, personModel.getName());
                stmt.setString(3, personModel.getSurname());
                stmt.setString(4, personModel.getDate());
                stmt.setString(5, personModel.getCity());
                stmt.setInt(6, id);
                if (stmt.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
    }

    public boolean deletePerson(String phoneNumber) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "DELETE FROM persona WHERE numero_tel = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
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
