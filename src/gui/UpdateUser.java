package gui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class UpdateUser extends JFrame {

    JTextField idField, nameField, emailField, phoneField;
    JButton searchButton, updateButton;

    public UpdateUser() {

        setTitle("Update User");
        setSize(450,420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel idLabel = new JLabel("User ID");
        idLabel.setBounds(40,30,100,25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150,30,200,25);
        add(idField);

        searchButton = new JButton("Search");
        searchButton.setBounds(150,70,100,30);
        add(searchButton);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40,120,100,25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150,120,200,25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(40,170,100,25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150,170,200,25);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(40,220,100,25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150,220,200,25);
        add(phoneField);

        updateButton = new JButton("Update");
        updateButton.setBounds(150,290,120,35);
        add(updateButton);

        searchButton.addActionListener(e -> {

            try {

                int userId = Integer.parseInt(idField.getText());

                UserDAO dao = new UserDAO();

                ResultSet rs = dao.searchUser(userId);

                if(rs != null && rs.next()){

                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));
                    phoneField.setText(rs.getString("phone"));

                }else{

                    JOptionPane.showMessageDialog(this,"User not found!");

                }

            }catch(Exception ex){

                ex.printStackTrace();

            }

        });

        updateButton.addActionListener(e -> {

            try{

                User user = new User();

                user.setUserId(Integer.parseInt(idField.getText()));
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setPhone(phoneField.getText());

                user.setPassword("");

                UserDAO dao = new UserDAO();

                dao.updateUser(user);

                JOptionPane.showMessageDialog(this,"User Updated Successfully!");

            }catch(Exception ex){

                ex.printStackTrace();

            }

        });
        setVisible(true);
    }
}