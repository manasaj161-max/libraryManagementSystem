package gui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class DeleteUser extends JFrame {

    JTextField idField;
    JButton deleteButton;

    public DeleteUser() {

        setTitle("Delete User");
        setSize(400,220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel idLabel = new JLabel("User ID");
        idLabel.setBounds(40,40,100,25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140,40,180,25);
        add(idField);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(140,100,120,35);
        add(deleteButton);

        deleteButton.addActionListener(e -> {

            try {

                int userId = Integer.parseInt(idField.getText());

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);

                if(choice == JOptionPane.YES_OPTION){

                    UserDAO dao = new UserDAO();
                    dao.deleteUser(userId);

                    JOptionPane.showMessageDialog(this,"User Deleted Successfully!");

                    idField.setText("");
                }

            } catch (Exception ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,"Invalid User ID");

            }

        });

        setVisible(true);
    }
}
