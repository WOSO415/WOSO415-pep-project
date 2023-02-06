package DAO;

import io.javalin.Javalin;

public class AccountDAO {
    

    /**
    * register account
    */
   public static Javalin userRegister() {
       
       Javalin reg = Javalin.create();

       reg.get("/register", ctx -> {
           ctx.result("Welcome!");
       });
       return reg;

   }

   /**
    * login
    */
   public static Javalin userLogin() {
       
       Javalin login = Javalin.create();

       login.get("/login", ctx -> {
           ctx.result("You Are Authorized!");
       });
       return login;

   }

   
}
