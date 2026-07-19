package main;

import dao.BorrowDAO;
import model.Borrow;

public class TestBorrow {

    public static void main(String[] args) {


        Borrow borrow = new Borrow(
                1,          // borrow_id (not used because auto_increment)
                2,          // user_id (Manasa)
                2,          // book_id (Java Programming)
                "2026-07-19",
                null
        );


        BorrowDAO dao = new BorrowDAO();


        dao.issueBook(borrow);


        System.out.println("\n===== Borrow Records =====");

        dao.viewBorrowRecords();

    }
}
