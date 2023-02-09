package Service;




import org.eclipse.jetty.util.security.Password;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    public AccountDAO accountDAO;

    
    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        
        this.accountDAO = accountDAO;
    }

    public Account addUser(Account account) {
        if (account.getUsername() == null || account.getPassword() == null) {
            return null;
        } else if (account.password.length() < 4) {
            return null;
        } else if (account.username.length() < 1) {
            return null;
        } 
        
        return accountDAO.insertUser(account);           
     }

     public boolean userLogin(Account login) {
       
        
        return userLogin(login);

     }
}

