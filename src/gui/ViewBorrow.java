package gui;

import dao.BorrowDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ViewBorrow extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewBorrow() {

        setTitle("View Borrow Records");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Borrow ID");
        model.addColumn("User ID");
        model.addColumn("Book ID");
        model.addColumn("Borrow Date");
        model.addColumn("Return Date");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadBorrowRecords();

        setVisible(true);
    }

    public void loadBorrowRecords() {

        try {

            BorrowDAO dao = new BorrowDAO();

            ResultSet rs = dao.getAllBorrowRecords();

            while(rs.next()){

                model.addRow(new Object[]{

                        rs.getInt("borrow_id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getString("borrow_date"),
                        rs.getString("return_date")

                });

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,e.getMessage());

        }

    }
}
