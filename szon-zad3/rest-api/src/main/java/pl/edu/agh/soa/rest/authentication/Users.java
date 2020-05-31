package pl.edu.agh.soa.rest.authentication;

import pl.edu.agh.soa.models.User;

import java.util.HashMap;

public class Users {

    private HashMap<String, String> users = new HashMap<>();

    private static Users instance;

    private Users() {
        users = new HashMap<>();
    }

    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
    public HashMap<String, String> getUsers(){
        return users;
    }

    public boolean addUser(User user){
        if(users.get(user.getLogin()) != null){
            return false;
        } else{
            users.put(user.getLogin(), user.getPassword());
            return true;
        }
    }
}