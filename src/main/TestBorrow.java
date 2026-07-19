package main;

import dao.BorrowDAO;
import model.Borrow;

public class TestBorrow {

    public static void main(String[] args) {

        Borrow borrow = new Borrow(
                1,
                2,
                2,
                "2026-07-19",
                null
        );

        BorrowDAO dao = new BorrowDAO();

        dao.issueBook(borrow);

        System.out.println("\n===== Borrow Records =====");

        dao.viewBorrowRecords();
    }
}
