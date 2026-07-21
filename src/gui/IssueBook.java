package gui;

import dao.BorrowDAO;
import model.Borrow;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class IssueBook extends JFrame {

    JTextField userIdField, bookIdField, borrowDateField, returnDateField;
    JButton issueButton;

    public IssueBook() {

        setTitle("Issue Book");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel userLabel = new JLabel("User ID");
        userLabel.setBounds(40, 30, 100, 25);
        add(userLabel);

        userIdField = new JTextField();
        userIdField.setBounds(170, 30, 200, 25);
        add(userIdField);

        JLabel bookLabel = new JLabel("Book ID");
        bookLabel.setBounds(40, 80, 100, 25);
        add(bookLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(170, 80, 200, 25);
        add(bookIdField);

        JLabel borrowLabel = new JLabel("Borrow Date");
        borrowLabel.setBounds(40, 130, 100, 25);
        add(borrowLabel);

        borrowDateField = new JTextField(LocalDate.now().toString());
        borrowDateField.setBounds(170, 130, 200, 25);
        add(borrowDateField);

        JLabel returnLabel = new JLabel("Return Date");
        returnLabel.setBounds(40, 180, 100, 25);
        add(returnLabel);

        returnDateField = new JTextField();
        returnDateField.setBounds(170, 180, 200, 25);
        add(returnDateField);

        issueButton = new JButton("Issue Book");
        issueButton.setBounds(140, 240, 150, 35);
        add(issueButton);

        issueButton.addActionListener(e -> {

            try {

                Borrow borrow = new Borrow();

                borrow.setUserId(Integer.parseInt(userIdField.getText()));
                borrow.setBookId(Integer.parseInt(bookIdField.getText()));
                borrow.setBorrowDate(borrowDateField.getText());
                borrow.setReturnDate(returnDateField.getText());

                BorrowDAO dao = new BorrowDAO();

                dao.issueBook(borrow);

                JOptionPane.showMessageDialog(this,
                        "Book Issued Successfully!");

                userIdField.setText("");
                bookIdField.setText("");
                borrowDateField.setText(LocalDate.now().toString());
                returnDateField.setText("");

            } catch (Exception ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Failed to issue book!");

            }

        });

        setVisible(true);
    }
}



