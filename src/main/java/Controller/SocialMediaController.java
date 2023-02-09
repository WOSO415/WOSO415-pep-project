package Controller;







import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
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
        
       
        //*registration//*
        app.post("/register", this::postUserHandler);     
        /*login*/
        app.post("/login", this::postLoginHandler);
        /*create new message*/
        app.post("/messages", this::postMessagesHandler);

        
        
        
        return app;
        }
  
   
    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */

    /*Signup Handler*/
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
    
    /*Login Handler*/
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
    /*Create Messages Handler*/
    private void postMessagesHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account mess = mapper.readValue(ctx.body(), Account.class);
        Account addedMess = accountService.addMessage(mess);
        if(addedMessage != null){
            ctx.json(mapper.writeValueAsString(addedMessage));
        }else{
            ctx.status(400);
        }
    }
   
    };
 


