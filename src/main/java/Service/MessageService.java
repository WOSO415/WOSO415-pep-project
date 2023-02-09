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
        if (message.getMessage_text() == null) {
            return null;
        } else if (message.getPosted_by() == 0) {
            return null;
        } else if (message.getMessage_text().length() > 255) {
            return null;
        }
        
        return messageDAO.newMessage(message);
    }

///////////////*Create Message*///////////////////////
public List<String> getAllMessagesList() {

    return messageDAO.getAllMessages();
}

public static Message newMessage(Message message) {
    return null;
}
    
}
