package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import Service.AccountService;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
   
    Javalin app;
    public AccountService socialMediaService;
    public SocialMediaController() {
        app = Javalin.create();
        socialMediaService = new AccountService();
    }
    
        

    






    
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        
        
        app.post("localhost:8080/register", ctx -> {

        });
       
        app.post("localhost:8080/login", ctx -> {

        });
        
        app.post("/messages", ctx -> {
            // post message
            ObjectMapper om = new ObjectMapper();
            SocialMediaController social = om.readValue(ctx.body(), SocialMediaController.class);
            MessageService.insertMessage(message);
            ctx.json(ctx);
        });
        //*get all messages//*
        app.get("/messages", ctx -> {
            List<Social> message = SocialMediaController.getAllMessages();
        });
        
        app.get("/messages{message_id}", getMessagesByMessage_id);
        
        app.delete("/messages{message_id}", deleteByMessage_id);
        
        app.patch("/messages/{message_id}", postMessagesByMessage_id);
        
        app.get("/accounts/{account_id}/messages}", getMessagesByAccount_id);

        return app;
            
        }

        
    

    







    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }


}