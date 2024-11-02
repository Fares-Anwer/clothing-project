package com.mycompany.clothingproject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

class ViewProductsWindow {
    public ViewProductsWindow() {
        // إعداد الإطار الرئيسي
        JFrame frame = new JFrame("View Products");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240)); // لون خلفية النافذة

        // بيانات وهمية لعرضها في الجدول
        String[] columnNames = { "Product Name", "Price", "Quantity" };
        Object[][] data = {
                { "Shirt", "20$", "50" },
                { "Pants", "30$", "30" },
                { "Shoes", "40$", "20" }
        };

        // إعداد الجدول
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setGridColor(Color.LIGHT_GRAY); // لون خطوط الجدول
        table.setShowGrid(true);

        // إعداد رأس الجدول
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(63, 81, 181)); // لون خلفية رأس الجدول
        header.setForeground(Color.WHITE); // لون النص في رأس الجدول
        header.setFont(new Font("SansSerif", Font.BOLD, 14));

        // تخصيص خلايا الجدول
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // إضافة تمرير للجدول
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // مسافة حول الجدول

        // إضافة الجدول إلى النافذة
        frame.add(scrollPane, BorderLayout.CENTER);

        // عرض النافذة
        frame.setLocationRelativeTo(null); // عرض النافذة في وسط الشاشة
        frame.setVisible(true);
    }
}
