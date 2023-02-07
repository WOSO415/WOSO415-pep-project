package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.command.ddl.PrepareProcedure;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO {

    public List<Message> getAllMessages() {
        Connection connection = ConnectionUtil.getConnection();
        List<Message> Messages = new ArrayList<>();
        try{
            String sql = "SELECT * from message";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
         while (rs.next()) {
            Message message = new Message(0, 0, rs.getString("Message"), 0);
            message.add(message);
         }}
        catch(SQLException e) {
            e.printStackTrace();
    }
        return Messages; 
    }
}

