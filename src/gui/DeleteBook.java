package gui;

import javax.swing.*;

import dao.Bookdao;

import javax.swing.JOptionPane;

import java.awt.*;

public class DeleteBook extends JFrame {

    JTextField idField;
    JButton deleteButton;
    JButton backButton;

    public DeleteBook() {

        setTitle("Delete Book");

        setSize(400,250);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel heading = new JLabel("Delete Book");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(120,20,200,30);
        add(heading);

        JLabel idLabel = new JLabel("Book ID");
        idLabel.setBounds(40,80,100,25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(130,80,180,30);
        add(idField);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(60,140,110,35);
        add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(200,140,110,35);
        add(backButton);

        backButton.addActionListener(e -> dispose());
        deleteButton.addActionListener(e -> {

    try {

        int bookId = Integer.parseInt(idField.getText());

        int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this book?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            Bookdao dao = new Bookdao();

            dao.deleteBook(bookId);

            JOptionPane.showMessageDialog(this,
                    "Book Deleted Successfully!");

            idField.setText("");

        }

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this,
                ex.getMessage());

    }

});

        setVisible(true);
    }
}

