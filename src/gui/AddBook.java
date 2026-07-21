package gui;

import javax.swing.*;
import java.awt.*;
import dao.Bookdao;
import model.Book;

public class AddBook extends JFrame {

    JLabel heading;
    JLabel titleLabel;
    JLabel authorLabel;
    JLabel categoryLabel;
    JLabel quantityLabel;

    JTextField titleField;
    JTextField authorField;
    JTextField categoryField;
    JTextField quantityField;

    JButton saveButton;
    JButton backButton;

    public AddBook() {

        setTitle("Add Book");

        setSize(450, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        heading = new JLabel("Add New Book");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(120, 20, 250, 30);
        add(heading);

        titleLabel = new JLabel("Title");
        titleLabel.setBounds(40, 80, 100, 25);
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(150, 80, 220, 25);
        add(titleField);

        authorLabel = new JLabel("Author");
        authorLabel.setBounds(40, 120, 100, 25);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 120, 220, 25);
        add(authorField);

        categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(40, 160, 100, 25);
        add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(150, 160, 220, 25);
        add(categoryField);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(40, 200, 100, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(150, 200, 220, 25);
        add(quantityField);

        saveButton = new JButton("Save");
        saveButton.setBounds(80, 280, 120, 35);
        add(saveButton);
        saveButton.addActionListener(e -> {

    try {

        Book book = new Book();

        book.setTitle(titleField.getText());
        book.setAuthor(authorField.getText());
        book.setCategory(categoryField.getText());
        book.setQuantity(Integer.parseInt(quantityField.getText()));

        Bookdao dao = new Bookdao();

        dao.addBook(book);

        JOptionPane.showMessageDialog(this, "Book Added Successfully!");

        titleField.setText("");
        authorField.setText("");
        categoryField.setText("");
        quantityField.setText("");

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this, ex.getMessage());

    }

});

        backButton = new JButton("Back");
        backButton.setBounds(220, 280, 120, 35);
        add(backButton);

        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}