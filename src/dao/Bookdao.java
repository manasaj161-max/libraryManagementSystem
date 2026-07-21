package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Book;
import util.DBConnection;

public class Bookdao{

    // Add Book
    public void addBook(Book book) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO books(title, author, category, quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book added successfully!");
            } else {
                System.out.println("Failed to add book!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Books
    public void viewBooks() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM books";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Book ID   : " + rs.getInt("book_id"));
                System.out.println("Title     : " + rs.getString("title"));
                System.out.println("Author    : " + rs.getString("author"));
                System.out.println("Category  : " + rs.getString("category"));
                System.out.println("Quantity  : " + rs.getInt("quantity"));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Book
    public void searchBook(int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM books WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Book Found!");
                System.out.println("Book ID   : " + rs.getInt("book_id"));
                System.out.println("Title     : " + rs.getString("title"));
                System.out.println("Author    : " + rs.getString("author"));
                System.out.println("Category  : " + rs.getString("category"));
                System.out.println("Quantity  : " + rs.getInt("quantity"));
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Book getBookById(int bookId) {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM books WHERE book_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, bookId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Book book = new Book();

            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            book.setQuantity(rs.getInt("quantity"));

            return book;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    // Update Book
    public void updateBook(Book book) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE books SET title = ?, author = ?, category = ?, quantity = ? WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getBookId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Book
    public void deleteBook(int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM books WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getAllBooks() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM books";

        PreparedStatement ps = con.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        e.printStackTrace();

    }

    return null;
}
}

        
