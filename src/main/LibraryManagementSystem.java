package main;

import java.util.Scanner;

import dao.Bookdao;
import dao.UserDAO;
import dao.BorrowDAO;

import model.Book;
import model.User;
import model.Borrow;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bookdao bookDAO = new Bookdao();
        UserDAO userDAO = new UserDAO();
        BorrowDAO borrowDAO = new BorrowDAO();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add User");
            System.out.println("7. View Users");
            System.out.println("8. Update User");
            System.out.println("9. Delete User");
            System.out.println("10. Issue Book");
            System.out.println("11. Return Book");
            System.out.println("12. View Borrow Records");
            System.out.println("13. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Book book = new Book(
                            0,
                            title,
                            author,
                            category,
                            quantity
                    );

                    bookDAO.addBook(book);

                    break;

                case 2:

                    bookDAO.viewBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    bookDAO.searchBook(bookId);

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int updateBookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();

                    Book updateBook = new Book(
                            updateBookId,
                            newTitle,
                            newAuthor,
                            newCategory,
                            newQuantity
                    );

                    bookDAO.updateBook(updateBook);

                    break;

                case 5:

                    System.out.print("Enter Book ID to Delete: ");
                    int deleteBookId = sc.nextInt();

                    bookDAO.deleteBook(deleteBookId);

                    break;
                    case 6:

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    User user = new User(
                            0,
                            name,
                            email,
                            password,
                            phone
                    );

                    userDAO.addUser(user);

                    break;

                case 7:

                    userDAO.viewUsers();

                    break;

                case 8:

                    sc.nextLine();

                    System.out.print("Enter User ID: ");
                    int updateUserId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Password: ");
                    String newPassword = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    User updateUser = new User(
                            updateUserId,
                            newName,
                            newEmail,
                            newPassword,
                            newPhone
                    );

                    userDAO.updateUser(updateUser);

                    break;

                case 9:

                    System.out.print("Enter User ID to Delete: ");
                    int deleteUserId = sc.nextInt();

                    userDAO.deleteUser(deleteUserId);

                    break;

                case 10:

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Borrow Date (YYYY-MM-DD): ");
                    String borrowDate = sc.nextLine();

                    Borrow borrow = new Borrow(
                            0,
                            userId,
                            issueBookId,
                            borrowDate,
                            null
                    );

                    borrowDAO.issueBook(borrow);

                    break;

                case 11:

                    System.out.print("Enter Borrow ID: ");
                    int borrowId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    String returnDate = sc.nextLine();

                    borrowDAO.returnBook(
                            borrowId,
                            returnBookId,
                            returnDate
                    );

                    break;

                case 12:

                    borrowDAO.viewBorrowRecords();

                    break;

                case 13:

                    System.out.println("Thank you for using Library Management System!");

                    sc.close();

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        }

    }

}

                