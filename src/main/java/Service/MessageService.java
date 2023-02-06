package Service;

import java.util.List;

public class MessageService {
    public DAO.MessageDAO messageDAO;
    public MessageService() {
        this.messageDAO = new MessageDAO();
    }
public List<MessageDAO> getAllMessages() {
    return DAO.MessageDAO.getAllMessages();
}
