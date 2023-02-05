package Service;

import java.util.List;

public class messageService {
    public DAO.messageDAO messageDAO;
    public messageService() {
        this.messageDAO = new DAO.messageDAO();
    }
}public List<message> getAllMessages() {
    return DAO.messageDAO.getAllMessages();
}
