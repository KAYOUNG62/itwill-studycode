package edu.java.contact.ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

import static edu.java.contact.ver06.OracleConnection.*;
import static edu.java.contact.ver06.ContactSql.*;
import static edu.java.contact.ver06.Contact.Entity.*;

public class ContactDaoImpl implements ContactDao {
    
    //singleton
    private static ContactDaoImpl instance = null;
    private ContactDaoImpl () {
    }
    public static ContactDaoImpl getInstance () {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    private void closeConnection(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }
    
    @Override
    public List<Contact> read() {   
        List<Contact> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Integer cid = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
    
                Contact contact = new Contact(cid, name, phone, email);
                list.add(contact);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeConnection(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }

    @Override
    public Contact select(Integer cid) {
        Contact contact = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CID);
            stmt.setInt(1, cid);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Integer cidno = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
    
                contact = new Contact(cidno, name, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contact;
    }

    @Override
    public int create(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

    @Override
    public int update(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, COL_NAME);
            stmt.setString(2, COL_PHONE);
            stmt.setString(3, COL_EMAIL);
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delete(Integer cid) {

        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cid);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
