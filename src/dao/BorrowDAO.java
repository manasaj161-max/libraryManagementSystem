package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Borrow;
import util.DBConnection;

public class BorrowDAO {


    // Issue Book
    public void issueBook(Borrow borrow) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO borrow_records(user_id, book_id, borrow_date, return_date) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, borrow.getUserId());
            ps.setInt(2, borrow.getBookId());
            ps.setString(3, borrow.getBorrowDate());
            ps.setString(4, borrow.getReturnDate());


            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Book issued successfully!");
            }
            else {
                System.out.println("Failed to issue book!");
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    // View Borrow Records
    public void viewBorrowRecords() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM borrow_records";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                System.out.println("Borrow ID   : " + rs.getInt("borrow_id"));
                System.out.println("User ID     : " + rs.getInt("user_id"));
                System.out.println("Book ID     : " + rs.getInt("book_id"));
                System.out.println("Borrow Date : " + rs.getDate("borrow_date"));
                System.out.println("Return Date : " + rs.getDate("return_date"));
                System.out.println("----------------------------");

            }


        } catch(Exception e) {

            e.printStackTrace();

        }
    }



    // Return Book
    public void returnBook(int borrowId, String returnDate) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE borrow_records SET return_date=? WHERE borrow_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, returnDate);
            ps.setInt(2, borrowId);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Book returned successfully!");
            }
            else {
                System.out.println("Borrow record not found!");
            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}
