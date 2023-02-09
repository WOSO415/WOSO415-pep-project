package Controller;







import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    private static final String ViewUtil = null;
    AccountService accountService;
    MessageService messageService;
    public SocialMediaController(){
        accountService = new AccountService();
        messageService = new MessageService();
    }
     
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return 
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        
       
////////////////////////////*Registration*////////////////////////////
        app.post("/register", this::postUserHandler);     
////////////////////////////*Login*////////////////////////////
        app.post("/login", this::postLoginHandler);
////////////////////////////*Create Message*////////////////////////////
        app.post("/messages", this::postMessagesHandler);
////////////////////////////*Get All Messages*////////////////////////////
        app.get("/messages", this::getAllMessagesHandler);

        
        
        
        return app;
        }
  
   
    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */

////////////////////////////*sign Up Handler*////////////////////////////
    private void postUserHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account user = mapper.readValue(ctx.body(), Account.class);
        Account addedUser = accountService.addUser(user);
        if(addedUser != null){
            ctx.json(mapper.writeValueAsString(addedUser));
        }else{
            ctx.status(400);
        }
    }
    
////////////////////////////*Login Handler*////////////////////////////
    private void postLoginHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account login = mapper.readValue(ctx.body(), Account.class);
        Account loginInfo = accountService.accountDAO.userLogin(login);
        if(loginInfo != null) {
            ctx.json(mapper.writeValueAsString(loginInfo));
        }else{
            ctx.status(401);
        }
    }
////////////////////////////*Create Message Handler*////////////////////////////
    
    private void postMessagesHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);
        
        Message newMessage = MessageService.newMessage(message);
        System.out.println(newMessage);
        if(newMessage == null){
            ctx.status(400);
        }else{
            ctx.json(mapper.writeValueAsString(newMessage));
        }

    }
////////////////////////////*Get All Messages Handler*////////////////////////////    
private void getAllMessagesHandler(Context ctx){
    ctx.json(messageService.getAllMessagesList());
}
    };
 


