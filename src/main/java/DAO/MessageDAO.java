package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.util.json.JSONObject;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

import Model.Message;

import Util.ConnectionUtil;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared;

public class MessageDAO {
    
    ///////////////*Create Message*///////////////////////
    public Message newMessage(Message message) {

        Connection connection = ConnectionUtil.getConnection();
        try {
       
            String sql = "insert into message (posted_by, message_text, time_posted_epoch) values (?, ?, ?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
            
            
            preparedStatement.setInt(1, message.getPosted_by());

            preparedStatement.setString(2, message.getMessage_text());
            
            preparedStatement.setLong(3, message.getTime_posted_epoch());
    
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                int generated_message_id = (int) rs.getLong(1);
                return new Message(generated_message_id, message.getPosted_by(),message.getMessage_text(), message.getTime_posted_epoch());
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

////////////////////////////*Get Message By Id*////////////////////////////
public Message MessageById(int id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "select * from message where message_id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Message message = new Message(
                rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));
          
            return message;
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}

///////////////*Delete Message*///////////////////////
public Message deleteByID(String message_id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "select message_text from message where message_id = ?";
        
        PreparedStatement selectStatement = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.
        selectStatement.setString(1, message_id);
        ResultSet rs = selectStatement.executeQuery();
        if (rs.next()) {
           String messageText = rs.getString("message_text");
            PreparedStatement deleteStatement = connection.prepareStatement("delete from message where message_id = ?");
            deleteStatement.setString(1, message_id);
            deleteStatement.executeUpdate();

            connection.close();

            ctx.status(200);
            ctx.result(new JSONObject.put("message_text", messageText).toString());
        } else {
            ctx.status(404);
            ctx.result("Message not found");
                  
        });

    }


///////////////*Update Message*///////////////////////
public Message updateByID(int id, Message updateMessage){
    Connection connection = ConnectionUtil.getConnection();
    
    try {
        //Write SQL logic here
        String sql = "update set message_text = ? where message_id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.
        preparedStatement.setString(1, updateMessage.getMessage_text());
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeUpdate();
        while(rs.next()){
            Message message = new Message(
                rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));
          
            return message;
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}
}