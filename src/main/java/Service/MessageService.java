package Service;

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
public List<String> getAllMessagesList() {

    return messageDAO.getAllMessages();
}
////////////////////////////*Get Message by Id*////////////////////////////
public Message getMessageById(int id) {
    
    return messageDAO.MessageById(id);
}





    
}
