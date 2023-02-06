package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.command.ddl.PrepareProcedure;

public class MessageDAO {
    public void getAllMessages() {
        try{
            
            PreparedStatement ps = conn.PreparedStatementsql: nt("SELECT * from message");
        }catch(SQLException e) {
            e.printStackTrace();
    } 
    }
}
