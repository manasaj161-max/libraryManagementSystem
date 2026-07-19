
package main;

import dao.Bookdao;

public class TestBook {

    public static void main(String[] args) {

        Bookdao dao = new Bookdao();

        dao.viewBooks();

    }
}