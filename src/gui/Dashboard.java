package gui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JButton bookButton, userButton, borrowButton, exitButton;

    public Dashboard() {

        setTitle("Library Management System");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 248, 250));

        JLabel title = new JLabel("📚 LIBRARY MANAGEMENT SYSTEM");
        title.setBounds(120, 40, 520, 45);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(25, 25, 112));
        add(title);

        JLabel subtitle = new JLabel("Java | JDBC | MySQL | Swing");
        subtitle.setBounds(235, 90, 300, 25);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(Color.DARK_GRAY);
        add(subtitle);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        bookButton = new JButton("📚 Book Management");
        bookButton.setBounds(220, 160, 280, 45);
        bookButton.setFont(buttonFont);
        add(bookButton);
        bookButton.addActionListener(e -> new BookManagement());

        userButton = new JButton("👤 User Management");
        userButton.setBounds(220, 225, 280, 45);
        userButton.setFont(buttonFont);
        add(userButton);
        userButton.addActionListener(e -> new UserManagement());

        borrowButton = new JButton("📖 Borrow Management");
        borrowButton.setBounds(220, 290, 280, 45);
        borrowButton.setFont(buttonFont);
        add(borrowButton);
        borrowButton.addActionListener(e -> new BorrowManagement());

        exitButton = new JButton("🚪 Exit");
        exitButton.setBounds(220, 355, 280, 45);
        exitButton.setFont(buttonFont);
        add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));

        JLabel footer = new JLabel("Developed by Manasa J");
        footer.setBounds(270, 465, 220, 20);
        footer.setFont(new Font("Arial", Font.ITALIC, 14));
        footer.setForeground(Color.GRAY);
        add(footer);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
