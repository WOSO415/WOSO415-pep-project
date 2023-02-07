package Service;

import java.util.List;


import DAO.MessageDAO;
import Model.Message;


public class MessageService {
    static MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    /*
     * return all messages
     */
    public static List<Message> getAllMessages() {
        return  messageDAO.getAllMessages();
         
       
     }

    public static void add(MessageService message) {
    }
}
