package gui;

import dao.BorrowDAO;

import javax.swing.*;

public class ReturnBook extends JFrame {

    JTextField borrowIdField, bookIdField, returnDateField;
    JButton returnButton;

    public ReturnBook() {

        setTitle("Return Book");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel borrowLabel = new JLabel("Borrow ID");
        borrowLabel.setBounds(40,40,100,25);
        add(borrowLabel);

        borrowIdField = new JTextField();
        borrowIdField.setBounds(160,40,170,25);
        add(borrowIdField);

        JLabel bookLabel = new JLabel("Book ID");
        bookLabel.setBounds(40,90,100,25);
        add(bookLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(160,90,170,25);
        add(bookIdField);

        JLabel returnLabel = new JLabel("Return Date");
        returnLabel.setBounds(40,140,100,25);
        add(returnLabel);

        returnDateField = new JTextField();
        returnDateField.setBounds(160,140,170,25);
        add(returnDateField);

        returnButton = new JButton("Return Book");
        returnButton.setBounds(120,200,150,35);
        add(returnButton);

        returnButton.addActionListener(e -> {

            try {

                int borrowId = Integer.parseInt(borrowIdField.getText());
                int bookId = Integer.parseInt(bookIdField.getText());
                String returnDate = returnDateField.getText();

                BorrowDAO dao = new BorrowDAO();

                dao.returnBook(borrowId, bookId, returnDate);

                JOptionPane.showMessageDialog(this,
                        "Book Returned Successfully!");

                borrowIdField.setText("");
                bookIdField.setText("");
                returnDateField.setText("");

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,
                        "Failed to Return Book!");

            }

        });

        setVisible(true);
    }
}
