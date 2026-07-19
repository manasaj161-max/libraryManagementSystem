package main;

import dao.BorrowDAO;

public class TestReturn {

    public static void main(String[] args) {

        BorrowDAO dao = new BorrowDAO();

        // Returning book with borrow_id = 3 bookid =2
        dao.returnBook(3, 2,"2026-07-19");

        System.out.println("\n===== Updated Borrow Records =====");

        dao.viewBorrowRecords();
    }
}
