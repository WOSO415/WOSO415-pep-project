package Service;

import java.sql.SQLException;
import java.util.List;


import DAO.MessageDAO;
import Model.Message;


public class MessageService {
    static MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    ///////////////*Create Message*///////////////////////
    public Message createMessage(Message message) {
        if (message.message_text == "" || message.getMessage_text().length() > 255) {
            return null;
        }
        return messageDAO.newMessage(message);
    }

///////////////*Get All Messages*///////////////////////
public List<Message> getAllMessagesList() {

    return messageDAO.getAllMessages();
}
////////////////////////////*Get Message by Id*////////////////////////////
public Message getMessageById(int id) {
    
    return messageDAO.MessageById(id);
}

///////////////*Delete Message by ID*///////////////////////
public Message deleteMessageByID(int id) {
    Message messageFromDb = messageDAO.MessageById(id);

    if (messageFromDb == null) return null;
    messageDAO.DeleteById(id);

    return messageFromDb;
}


///////////////*Update Message*///////////////////////
public Message updateMessage(int id, Message message) {
    
        if (message.message_text == "" || message.message_text.length() > 255) {
            return null;
        }
    return messageDAO.updateMessage(id, message);
    
   
}

///////////////*Get All From Particular User*///////////////////////

public List<Message> geMessageAccount(int id) {
    
    return messageDAO.getMessageAccount(id);
}




    
}
