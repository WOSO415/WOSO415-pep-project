package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    /*
     * return all messages
     */
public List<Message> getAllMessages() {
    return messageDAO.getAllMessages();
}
}
