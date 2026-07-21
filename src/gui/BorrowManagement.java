package gui;

import javax.swing.*;
import java.awt.*;

public class BorrowManagement extends JFrame {

    public BorrowManagement() {

        setTitle("Borrow Management");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 248, 250));

        JLabel title = new JLabel("📖 BORROW MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(25, 25, 112));
        title.setBounds(120, 25, 380, 40);
        add(title);

        Font buttonFont = new Font("Arial", Font.BOLD, 15);

        JButton issueButton = new JButton("📚 Issue Book");
        issueButton.setBounds(170, 100, 250, 40);
        issueButton.setFont(buttonFont);
        add(issueButton);
        issueButton.addActionListener(e -> new IssueBook());

        JButton returnButton = new JButton("📥 Return Book");
        returnButton.setBounds(170, 160, 250, 40);
        returnButton.setFont(buttonFont);
        add(returnButton);
        returnButton.addActionListener(e -> new ReturnBook());

        JButton viewButton = new JButton("📋 View Borrow Records");
        viewButton.setBounds(170, 220, 250, 40);
        viewButton.setFont(buttonFont);
        add(viewButton);
        viewButton.addActionListener(e -> new ViewBorrow());

        JButton backButton = new JButton("⬅ Back");
        backButton.setBounds(170, 280, 250, 40);
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