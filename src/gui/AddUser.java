package gui;

import javax.swing.*;

import dao.UserDAO;
import model.User;

import java.awt.*;

public class AddUser extends JFrame {

    JTextField nameField;
    JTextField emailField;
    JTextField phoneField;

    JButton saveButton;
    JButton backButton;

    public AddUser() {

        setTitle("Add User");
        setSize(450,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Add New User");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(120,20,250,30);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(40,80,100,25);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150,80,220,25);
        add(nameField);

        JLabel email = new JLabel("Email");
        email.setBounds(40,130,100,25);
        add(email);

        emailField = new JTextField();
        emailField.setBounds(150,130,220,25);
        add(emailField);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(40,180,100,25);
        add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(150,180,220,25);
        add(phoneField);

        saveButton = new JButton("Save");
        saveButton.setBounds(80,260,120,35);
        add(saveButton);
        saveButton.addActionListener(e -> {

    String userName = nameField.getText();
    String userEmail = emailField.getText();
    String userPhone = phoneField.getText();

    if (userName.isEmpty() || userEmail.isEmpty() || userPhone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields");
        return;
    }

    User user = new User();

    user.setName(userName);
    user.setEmail(userEmail);
    user.setPhone(userPhone);

    UserDAO dao = new UserDAO();
    dao.addUser(user);

    JOptionPane.showMessageDialog(this, "User Added Successfully!");

    nameField.setText("");
    emailField.setText("");
    phoneField.setText("");

});
       
        backButton = new JButton("Back");
        backButton.setBounds(220,260,120,35);
        add(backButton);

        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
