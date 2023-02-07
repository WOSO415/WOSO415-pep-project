package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.jetty.server.Authentication.User;

import Model.Account;
import Util.ConnectionUtil;
import io.javalin.Javalin;

public class AccountDAO {
    public Account insertUser(Account user){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "insert into account (username, password) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            
            //write preparedStatement's setString and setInt methods here.
                       
           
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            
            preparedStatement.executeUpdate();
            return user;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
 
   
}
