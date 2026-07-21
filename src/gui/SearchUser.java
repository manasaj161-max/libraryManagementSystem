package gui;

import dao.UserDAO;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;

public class SearchUser extends JFrame {

    private JTextField idField, nameField, emailField, phoneField;
    private JButton searchButton;

    public SearchUser() {

        setTitle("Search User");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // User ID
        JLabel idLabel = new JLabel("User ID");
        idLabel.setBounds(40, 30, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 30, 200, 25);
        add(idField);

        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 80, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 80, 200, 25);
        nameField.setEditable(false);
        add(nameField);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(40, 130, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 130, 200, 25);
        emailField.setEditable(false);
        add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(40, 180, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 180, 200, 25);
        phoneField.setEditable(false);
        add(phoneField);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(150, 240, 120, 35);
        add(searchButton);

        searchButton.addActionListener(e -> {

            try {

                int userId = Integer.parseInt(idField.getText());

                UserDAO dao = new UserDAO();

                ResultSet rs = dao.searchUser(userId);

                if (rs != null && rs.next()) {

                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));
                    phoneField.setText(rs.getString("phone"));

                } else {

                    JOptionPane.showMessageDialog(this, "User not found!");

                    nameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this, "Please enter a valid User ID.");

            } catch (Exception ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error searching user.");

            }

        });

        setVisible(true);
    }
}