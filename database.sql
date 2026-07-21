package gui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JButton bookButton;
    JButton userButton;
    JButton borrowButton;
    JButton exitButton;

    public Dashboard() {

        setTitle("Library Management System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("📚 Library Management System");
        title.setBounds(150, 30, 400, 40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        add(title);

        // Book Management Button
        bookButton = new JButton("📚 Book Management");
        bookButton.setBounds(220, 120, 250, 40);
        add(bookButton);

        // Open Book Management Window
        bookButton.addActionListener(e -> {
            new BookManagement();
        });

        // User Management Button
        userButton = new JButton("👤 User Management");
        userButton.setBounds(220, 180, 250, 40);
        add(userButton);
        userButton.addActionListener(e -> new UserManagement());

        // Borrow Management Button
        borrowButton = new JButton("📖 Borrow Management");
        borrowButton.setBounds(220, 240, 250, 40);
        add(borrowButton);
        borrowButton.addActionListener(e -> new BorrowManagement());

        // Exit Button
        exitButton = new JButton("🚪 Exit");
        exitButton.setBounds(220, 300, 250, 40);
        add(exitButton);

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
