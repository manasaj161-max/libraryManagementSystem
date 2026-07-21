package gui;

import dao.Bookdao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ViewBooks extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewBooks() {

        setTitle("View Books");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Book ID");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Category");
        model.addColumn("Quantity");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadBooks();

        setVisible(true);
    }

    public void loadBooks() {

        try {

            Bookdao dao = new Bookdao();

            ResultSet rs = dao.getAllBooks();

            while (rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("quantity")

                });

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());

        }

    }
}
