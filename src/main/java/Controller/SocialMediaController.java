package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {

    public class SocialController {
        SocialService socialService;
        public SocialController() {
            socialService = new SocialService();
        }
    }






    pr
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        Handler postRegister;
        app.post("localhost:8080/register", postRegister);
        Handler postLogin;
        app.post("localhost:8080/login", postLogin);
        Handler postMessages;
        app.post("/messages", postMessages);
        Handler getAllmessages;
        app.get("/messages", getAllmessages);
        Handler getMessagesByMessage_id;
        app.get("/messages{message_id}", getMessagesByMessage_id);
        Handler deleteByMessage_id;
        app.delete("/messages{message_id}", deleteByMessage_id);
        Handler postMessagesByMessage_id;
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