package main;

import java.util.Scanner;

import dao.Bookdao;

public class TestBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bookdao dao = new Bookdao();

        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        dao.deleteBook(id);

        sc.close();
    }
}