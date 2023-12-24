/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartfarm;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Software
 */
public class UserDB {
    private ResultSet result;
    private Statement stmt;
    private PreparedStatement pstmt;
    private Connection con;    
    
    
    
    public UserDB(){
        this.con = null;
        this.stmt = null;
        this.pstmt = null;
    }
    
    public void db_connect(){
        String url = "jdbc:mariadb://localhost:3306/test";
        String user = "root";
        String password = "mokpo23";
        String driverName = "org.mariadb.jdbc.Driver";
        
        try {
            Class.forName(driverName);
            con = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("connection success");
            stmt =con.createStatement();
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e){
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void insert(String id,String password,String name,String phoneNum, String address)throws SQLException{
        String sql = "INSERT INTO user(id, password, name, phoneNumber, address) VALUES(?,?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setString(4, phoneNum);
        pstmt.setString(5, address);
        pstmt.executeUpdate();
    }

    
    public void update(String id,String password,String name,String phoneNum, String address)throws SQLException{
        String sql = "UPDATE user SET password = '"+ password +"', name = '"+ name +"', phoneNumber = '"+ phoneNum +"', address = '"+ address +"' WHERE id = '"+ id +"';";
        stmt.executeQuery(sql);
    }
    public boolean join(String id, String password)throws SQLException{
        boolean result;
        String sql = "SELECT * FROM user where id in(' "+id+ "') AND password in(' "+password+"');";
        this.result = stmt.executeQuery(sql);
        result = this.result.next();
        return result;
    }
    public boolean searchId(String id)throws SQLException{
        boolean result;
        String sql = "SELECT * FROM user where id in(' "+id+ "');";
        this.result = stmt.executeQuery(sql);
        result = this.result.next();
        return result;
    }
    
    public void delete(String id)throws SQLException{
        String del_sql = "DELETE FROM user where id ='"+id+"';";
        stmt.executeQuery(del_sql);
    }
    
    
    public void close()throws SQLException{
        stmt.close();
        //pstmt.close();
        con.close();
    }
}
