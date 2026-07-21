package gui;
import javax.swing.*;
import dao.Bookdao;
import model.Book;
import java.awt.*;

public class UpdateBook extends JFrame {

    JTextField idField;
    JTextField titleField;
    JTextField authorField;
    JTextField categoryField;
    JTextField quantityField;

    JButton loadButton;
    JButton updateButton;
    JButton backButton;

    public UpdateBook() {

        setTitle("Update Book");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Update Book");
        heading.setFont(new Font("Arial",Font.BOLD,20));
        heading.setBounds(170,20,200,30);
        add(heading);

        JLabel id = new JLabel("Book ID");
        id.setBounds(50,80,100,25);
        add(id);

        idField = new JTextField();
        idField.setBounds(170,80,200,30);
        add(idField);

        loadButton = new JButton("Load");
        loadButton.setBounds(170,120,100,30);
        add(loadButton);

        JLabel title = new JLabel("Title");
        title.setBounds(50,170,100,25);
        add(title);

        titleField = new JTextField();
        titleField.setBounds(170,170,200,30);
        add(titleField);

        JLabel author = new JLabel("Author");
        author.setBounds(50,220,100,25);
        add(author);

        authorField = new JTextField();
        authorField.setBounds(170,220,200,30);
        add(authorField);

        JLabel category = new JLabel("Category");
        category.setBounds(50,270,100,25);
        add(category);

        categoryField = new JTextField();
        categoryField.setBounds(170,270,200,30);
        add(categoryField);

        JLabel quantity = new JLabel("Quantity");
        quantity.setBounds(50,320,100,25);
        add(quantity);

        quantityField = new JTextField();
        quantityField.setBounds(170,320,200,30);
        add(quantityField);

        updateButton = new JButton("Update");
        updateButton.setBounds(80,390,120,35);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(250,390,120,35);
        add(backButton);

        backButton.addActionListener(e -> dispose());
        updateButton.addActionListener(e -> {

    try {

        Book book = new Book();

        book.setBookId(Integer.parseInt(idField.getText()));
        book.setTitle(titleField.getText());
        book.setAuthor(authorField.getText());
        book.setCategory(categoryField.getText());
        book.setQuantity(Integer.parseInt(quantityField.getText()));

        Bookdao dao = new Bookdao();

        dao.updateBook(book);

        JOptionPane.showMessageDialog(this, "Book Updated Successfully!");

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this, ex.getMessage());

    }

});
        loadButton.addActionListener(e -> {

    try {

        int bookId = Integer.parseInt(idField.getText());

        Bookdao dao = new Bookdao();

        Book book = dao.getBookById(bookId);

        if (book != null) {

            titleField.setText(book.getTitle());
            authorField.setText(book.getAuthor());
            categoryField.setText(book.getCategory());
            quantityField.setText(String.valueOf(book.getQuantity()));

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