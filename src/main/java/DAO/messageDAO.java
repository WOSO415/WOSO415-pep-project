package DAO;

import java.sql.PreparedStatement;

import org.h2.command.ddl.PrepareProcedure;

public class messageDAO {
    public void getAllMessages() {
        try{
            PreparedStatement ps = conn.PreparedStatementsql: nt("SELECT * from message");
        }catch(SQlException e) {
            e.printStackTrace();
    } 
    }
}
