package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Message;

import Util.ConnectionUtil;

public class MessageDAO {
    
    ///////////////*Create Message*///////////////////////
    public Message newMessage(Message message) {

        Connection connection = ConnectionUtil.getConnection();
        try {
       
            String sql = "insert into message (message_text, posted_by) values (?, ?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
            
            
            preparedStatement.setString(1, message.getMessage_text());
            preparedStatement.setInt(2, message.getPosted_by());
    
            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_message_id = (int) pkeyResultSet.getLong(1);
                return new Message(generated_message_id, message.getMessage_text(), message.getPosted_by());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
   
}

///////////////*Get All Messages*///////////////////////
public List<String> getAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    List<String> message = new ArrayList<>();
    try {
        //Write SQL logic here
        String sql = "SELECT * FROM message";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            message.add(rs.getString("message"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    System.out.println(message);
    return message;



}
}


