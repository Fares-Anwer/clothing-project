package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ClothingStoreApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClothingStoreApp().createMainWindow());
    }

    public void createMainWindow() {
        // إعداد الإطار الرئيسي للنافذة
        JFrame mainFrame = new JFrame("Clothing Store - Main Window");
        mainFrame.setSize(600, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // خلفية ملونة للإطار
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 245, 245)); // لون الخلفية الأساسي
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        // إنشاء شريط القائمة وتصميمه
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(63, 81, 181)); // لون خلفية شريط القائمة

        JMenu menu = new JMenu("Options");
        menu.setForeground(Color.WHITE); // لون النص في القائمة
        menu.setFont(new Font("SansSerif", Font.BOLD, 14));

        // عناصر القائمة مع تصميمها
        JMenuItem addProduct = new JMenuItem("Add New Product");
        JMenuItem viewProducts = new JMenuItem("View Products");
        JMenuItem manageOrders = new JMenuItem("Manage Orders");

        // تخصيص عناصر القائمة بألوان وخطوط
        Color menuItemBackgroundColor = new Color(220, 220, 220);
        Font menuItemFont = new Font("SansSerif", Font.PLAIN, 12);

        customizeMenuItem(addProduct, menuItemBackgroundColor, menuItemFont);
        customizeMenuItem(viewProducts, menuItemBackgroundColor, menuItemFont);
        customizeMenuItem(manageOrders, menuItemBackgroundColor, menuItemFont);

        // إضافة العناصر إلى القائمة
        menu.add(addProduct);
        menu.add(viewProducts);
        menu.add(manageOrders);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        // إعداد التفاعل مع القائمة
        addProduct.addActionListener(e -> openAddProductWindow());
        viewProducts.addActionListener(e -> openViewProductsWindow());
        manageOrders.addActionListener(e -> openManageOrdersWindow());

        mainFrame.setVisible(true);
    }

    private void customizeMenuItem(JMenuItem menuItem, Color backgroundColor, Font font) {
        menuItem.setBackground(backgroundColor);
        menuItem.setFont(font);
        menuItem.setOpaque(true);
    }

    public void openAddProductWindow() {
        new AddProductWindow();
    }

    public void openViewProductsWindow() {
        new ViewProductsWindow();
    }

    public void openManageOrdersWindow() {
        new ManageOrdersWindow();
    }
}
