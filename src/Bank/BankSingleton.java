package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {

    private static BankSingleton instance;
    private List<User> users;

    private BankSingleton() {
        users = new ArrayList<>();
    }


    public static BankSingleton getInstance() {
        if (instance == null) {
            instance = new BankSingleton();
        }
        return instance;
    }

    public User createUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                throw new IllegalArgumentException("User already exists" + user.getUsername());
        }
        User duplicate = new User(username, password);
        users.add(duplicate);
        return duplicate;
    }


    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User " + username + " authenticated successfully  "  );
                return user;
            }
        }
        System.out.println("Authentication failed");
        return null;
    }



}