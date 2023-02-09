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
    public Message createMessage() {

        return messageDAO.newMessage(createMessage());
    }

///////////////*Create Message*///////////////////////
public List<Message> getAllMessages() {

    return messageDAO.getAllMessages();
}
    
}
