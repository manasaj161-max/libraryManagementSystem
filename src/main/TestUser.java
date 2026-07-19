package main;

import java.util.Scanner;

import dao.UserDAO;

public class TestUser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO dao = new UserDAO();

        System.out.print("Enter User ID to Delete: ");
        int id = sc.nextInt();

        dao.deleteUser(id);

        System.out.println("\n===== Remaining Users =====");

        dao.viewUsers();

        sc.close();
    }
}