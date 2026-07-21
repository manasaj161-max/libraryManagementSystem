package gui;

import javax.swing.*;

import dao.Bookdao;
import model.Book;

import java.awt.*;

public class SearchBook extends JFrame {

    JTextField idField;
    JButton searchButton, backButton;

    JLabel titleLabel, authorLabel, categoryLabel, quantityLabel;

    public SearchBook() {

        setTitle("Search Book");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Search Book");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(170, 20, 200, 30);
        add(heading);

        JLabel id = new JLabel("Book ID");
        id.setBounds(70, 80, 100, 25);
        add(id);

        idField = new JTextField();
        idField.setBounds(170, 80, 180, 30);
        add(idField);

        searchButton = new JButton("Search");
        searchButton.setBounds(90, 140, 120, 35);
        add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(250, 140, 120, 35);
        add(backButton);

        titleLabel = new JLabel("Title : ");
        titleLabel.setBounds(70, 210, 350, 25);
        add(titleLabel);

        authorLabel = new JLabel("Author : ");
        authorLabel.setBounds(70, 240, 350, 25);
        add(authorLabel);

        categoryLabel = new JLabel("Category : ");
        categoryLabel.setBounds(70, 270, 350, 25);
        add(categoryLabel);

        quantityLabel = new JLabel("Quantity : ");
        quantityLabel.setBounds(70, 300, 350, 25);
        add(quantityLabel);

        backButton.addActionListener(e -> dispose());
searchButton.addActionListener(e -> {

    try {

        int bookId = Integer.parseInt(idField.getText());

        Bookdao dao = new Bookdao();

        Book book = dao.getBookById(bookId);

        if (book != null) {

            titleLabel.setText("Title : " + book.getTitle());
            authorLabel.setText("Author : " + book.getAuthor());
            categoryLabel.setText("Category : " + book.getCategory());
            quantityLabel.setText("Quantity : " + book.getQuantity());

        } else {

            JOptionPane.showMessageDialog(this, "Book Not Found");

        }

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this, ex.getMessage());

    }

});
        setVisible(true);
    }
}
