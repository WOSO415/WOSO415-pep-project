package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    public AccountDAO accountDAO;

    
    public AccountService(){
        accountDAO = new AccountDAO();
    }
    public Account addUser(Account user) {
        if (accountDAO.insertUser(user) != null) {
         return null;
        } else {
         return accountDAO.insertUser(user);
        }
     }
}
