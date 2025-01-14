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
public List<Message> getAllMessages(){
    Connection connection = ConnectionUtil.getConnection();
    List<Message> message = new ArrayList<>();
    try {
        //Write SQL logic here
        String sql = "SELECT * FROM message";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Message anything = new Message(
                
            rs.getInt("message_id"),
            rs.getInt("posted_by"),
            rs.getString("message_text"),
            rs.getLong("time_posted_epoch"));
            message.add(anything);
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
/**
 * @param id
 * @return 
 */
public Message DeleteById(int id){
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "delete from message where message_id = ?";
        
        PreparedStatement ps = connection.prepareStatement(sql);

        //write preparedStatement's setString and setInt methods here.
        ps.setInt(1, id);

        int rs = ps.executeUpdate();

        System.out.println("Number of affected records: " + rs);
        
          
            
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
   
}
        
        

    


///////////////*Update Message*///////////////////////

public Message updateMessage(int id, Message message) {
    Connection connection = ConnectionUtil.getConnection();
    try {
        //Write SQL logic here
        String sql = "update message set message_text = ? where message_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //write PreparedStatement setString and setInt methods here.
        preparedStatement.setString(1, message.getMessage_text());
        
        preparedStatement.setInt(2, id);

        preparedStatement.executeUpdate();
        return MessageById(id);
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return null;
}

///////////////*Get All From Particular User*///////////////////////
public List<Message> getMessageAccount(int id){
    Connection connection = ConnectionUtil.getConnection();
    List<Message> message = new ArrayList<>();
    try {
        //Write SQL logic here
        String sql = "SELECT * FROM message where posted_by = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Message anything = new Message(
                
            rs.getInt("message_id"),
            rs.getInt("posted_by"),
            rs.getString("message_text"),
            rs.getLong("time_posted_epoch"));
            message.add(anything);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    System.out.println(message);
    return message;
}
}
