package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ClothingStoreApp {
    private JPanel mainContentPanel; // اللوحة الرئيسية للتبديل بين المحتوى

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClothingStoreApp().createMainWindow());
    }

    public void createMainWindow() {
        // إعداد الإطار الرئيسي للنافذة
        JFrame mainFrame = new JFrame("Clothing Store");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // إعداد شريط القائمة كـ header ثابت
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(63, 81, 181));

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setForeground(Color.WHITE);
        optionsMenu.setFont(new Font("SansSerif", Font.BOLD, 14));

        // إنشاء عناصر القائمة
        JMenuItem addProduct = new JMenuItem("Add New Product");
        JMenuItem manageOrders = new JMenuItem("Manage Orders");
        JMenuItem viewProducts = new JMenuItem("View Products");
        JMenuItem viewCart = new JMenuItem("View Cart");

        // تخصيص وتنسيق أزرار القائمة
        customizeMenuItem(addProduct, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        customizeMenuItem(manageOrders, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        customizeMenuItem(viewProducts, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        customizeMenuItem(viewCart, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));

        // إضافة عناصر القائمة إلى القائمة الرئيسية
        optionsMenu.add(addProduct);
        optionsMenu.add(manageOrders);
        optionsMenu.add(viewProducts);
        optionsMenu.add(viewCart);
        menuBar.add(optionsMenu);

        // إضافة زر Login كعنصر منفصل
        JMenuItem loginButton = new JMenuItem("Login");
        customizeMenuItem(loginButton, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        loginButton.addActionListener(e -> openLoginFrame());
        menuBar.add(loginButton);

        mainFrame.setJMenuBar(menuBar); // تثبيت شريط القائمة في الأعلى

        // إعداد اللوحة الرئيسية للتبديل بين النوافذ
        mainContentPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainContentPanel, BorderLayout.CENTER);

        // عرض قائمة المنتجات كواجهة افتراضية
        openViewProductsWindow();

        // إعداد التفاعل مع القائمة
        addProduct.addActionListener(e -> openAddProductWindow());
        manageOrders.addActionListener(e -> openManageOrdersWindow());
        viewProducts.addActionListener(e -> openViewProductsWindow()); // فتح واجهة عرض المنتجات
        viewCart.addActionListener(e -> openCartWindow()); // فتح واجهة السلة

        mainFrame.setLocationRelativeTo(null); // ظهور النافذة في منتصف الشاشة
        mainFrame.setVisible(true);
    }

    private void customizeMenuItem(JMenuItem menuItem, Color backgroundColor, Font font) {
        menuItem.setBackground(backgroundColor);
        menuItem.setFont(font);
        menuItem.setOpaque(true);
    }

    public void openAddProductWindow() {
        mainContentPanel.removeAll();
        mainContentPanel.add(new AddProductWindow().getPanel(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void openViewProductsWindow() {
        mainContentPanel.removeAll();
        mainContentPanel.add(new ViewProductsWindow().getPanel(), BorderLayout.CENTER); // عرض لوحة المنتجات داخل
                                                                                        // mainContentPanel
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void openManageOrdersWindow() {
        mainContentPanel.removeAll();
        mainContentPanel.add(new ManageOrdersWindow().getPanel(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void openCartWindow() {
        mainContentPanel.removeAll();
        mainContentPanel.add(new CartWindow().getPanel(), BorderLayout.CENTER); // فتح واجهة Cart
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void openLoginFrame() {
        new LoginFrame(); // فتح إطار تسجيل الدخول
    }
}
