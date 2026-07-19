package main;

import dao.UserDAO;
import model.User;

public class TestUser {

    public static void main(String[] args) {

        User user = new User(
                1,
                "Manasa",
                "manasaj161@gmail.com",
                "12345",
                "9876543210"
        );

        UserDAO dao = new UserDAO();

        dao.addUser(user);

        System.out.println("\n===== All Users =====");

        dao.viewUsers();
    }
}