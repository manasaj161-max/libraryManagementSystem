package gui;

import dao.UserDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ViewUsers extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewUsers() {

        setTitle("View Users");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("User ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadUsers();

        setVisible(true);
    }

    public void loadUsers() {

        try {

            UserDAO dao = new UserDAO();

            ResultSet rs = dao.getAllUsers();

            while(rs.next()){

                model.addRow(new Object[]{

                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")

                });

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,e.getMessage());

        }

    }
}
