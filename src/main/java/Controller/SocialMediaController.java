package Controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

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
   AccountService accountService;
   MessageService messageService;

   public SocialMediaController() {
    this.accountService = new AccountService();
    this.messageService = new MessageService();
   }
   
        

    






    
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        
        app.post("8080/register", ctx -> {

        });
       
        app.post("8080/login", ctx -> {

        });
        
        app.post("8080/messages", ctx -> {
            // post message
            ObjectMapper om = new ObjectMapper();
            SocialMediaController social = om.readValue(ctx.body(), SocialMediaController.class);
            MessageService.insertMessage();
            ctx.json(ctx);
        });
        //*get all messages//*
        app.get("8080/messages", ctx -> {
            List<Message> message = SocialMediaController.getAllMessages();
        });
        
        app.get("8080/messages{message_id}", getMessagesByMessage_id);
        
        app.delete("8080/messages{message_id}", deleteByMessage_id);
        
        app.patch("8080/messages/{message_id}", postMessagesByMessage_id);
        
        app.get("8080/accounts/{account_id}/messages}", getMessagesByAccount_id);

        return app;
            
        }

        
    

    







    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    public void getAllMessagesHandler(Context ctx) {
       List<Message> messages = messageService.getAllMessages();
       ctx.json(messages);
    }


}