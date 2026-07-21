package gui;

import javax.swing.*;
import java.awt.*;

public class BookManagement extends JFrame {

    public BookManagement() {

        setTitle("Book Management");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 248, 250));

        JLabel title = new JLabel("📚 BOOK MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(25, 25, 112));
        title.setBounds(130, 25, 350, 40);
        add(title);

        Font buttonFont = new Font("Arial", Font.BOLD, 15);

        JButton addButton = new JButton("➕ Add Book");
        addButton.setBounds(170, 90, 250, 40);
        addButton.setFont(buttonFont);
        add(addButton);
        addButton.addActionListener(e -> new AddBook());

        JButton viewButton = new JButton("📖 View Books");
        viewButton.setBounds(170, 145, 250, 40);
        viewButton.setFont(buttonFont);
        add(viewButton);
        viewButton.addActionListener(e -> new ViewBooks());

        JButton searchButton = new JButton("🔍 Search Book");
        searchButton.setBounds(170, 200, 250, 40);
        searchButton.setFont(buttonFont);
        add(searchButton);
        searchButton.addActionListener(e -> new SearchBook());

        JButton updateButton = new JButton("✏ Update Book");
        updateButton.setBounds(170, 255, 250, 40);
        updateButton.setFont(buttonFont);
        add(updateButton);
        updateButton.addActionListener(e -> new UpdateBook());

        JButton deleteButton = new JButton("🗑 Delete Book");
        deleteButton.setBounds(170, 310, 250, 40);
        deleteButton.setFont(buttonFont);
        add(deleteButton);
        deleteButton.addActionListener(e -> new DeleteBook());

        JButton backButton = new JButton("⬅ Back");
        backButton.setBounds(170, 365, 250, 40);
        backButton.setFont(buttonFont);
        add(backButton);
        backButton.addActionListener(e -> dispose());

        JLabel footer = new JLabel("Library Management System");
        footer.setBounds(205, 430, 220, 20);
        footer.setFont(new Font("Arial", Font.ITALIC, 13));
        footer.setForeground(Color.GRAY);
        add(footer);

        setVisible(true);
    }
}