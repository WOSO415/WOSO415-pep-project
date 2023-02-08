package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO {

public Account insertUser(Account account) {

    Connection connection = ConnectionUtil.getConnection();
    try {
   
        String sql = "insert into account (username, password) values (?, ?)" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // preparedStatements
        
        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());

        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
            int generated_account_id = (int) pkeyResultSet.getLong(1);
            return new Account(generated_account_id, account.getUsername(), account.getPassword());
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}

    public Account userLogin(Account login) {
        Connection connection = ConnectionUtil.getConnection();
    try {
   
        String sql = "select * from account where username = ? and password = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // preparedStatements
        
        preparedStatement.setString(1, login.getUsername());
        preparedStatement.setString(2, login.getPassword());

        preparedStatement.executeUpdate();
        ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
        if(pkeyResultSet.next()){
            int generated_account_id = (int) pkeyResultSet.getLong(1);
            return new Account(generated_account_id, login.getUsername(), login.getPassword());
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
    }


public boolean Login(String username, String password){
    if (username.equals(username) && password.equals(password)) {
        System.out.println("Login Successful!");
        return true;
    } else {
        System.out.println("Invalid Username or Password");
        return false;
    }
    } 
    
   
}


}

    
 
   

