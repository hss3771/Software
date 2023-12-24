/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartfarm;

import java.sql.SQLException;

/**
 *
 * @author Software
 */
public class UserManagement {
    private UserDB userdb;
    
    public UserManagement(){
        userdb = new UserDB();
        
    }
    
    public boolean enroll(String id, String pw, String name, String phoneNum, String address)throws SQLException{
        boolean result;
        userdb.db_connect();
        System.out.println("usermanager connection success");
        result = userdb.searchId(id);        
        if (result == false){
            userdb.insert(id, pw, name, phoneNum, address);
            userdb.close();
            return true;
        } else{
            userdb.close();
            return false;
        }
    }
    public boolean revise(String id, String pw, String name, String phoneNum, String address)throws SQLException{
    	boolean result;
    	userdb.db_connect();
    	result = userdb.searchId(id);        
        if (result == false){
            userdb.update(id, pw, name, phoneNum, address);
            userdb.close();
            return true;
        } else{
            userdb.close();
            return false;
        }
    }
    public boolean delete(String id)throws SQLException{
    	boolean result;
    	userdb.db_connect();
    	result = userdb.searchId(id);        
        if (result == false){
            userdb.delete(id);
            userdb.close();
            return true;
        } else{
            userdb.close();
            return false;
        }
    }
    
    public boolean join(String id, String pw)throws SQLException{
    	boolean result;
    	userdb.db_connect();
    	result = userdb.join(id, pw);
    	userdb.close();
    	return result;    
    }
}
