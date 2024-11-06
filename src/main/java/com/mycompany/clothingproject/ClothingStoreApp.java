package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothingStoreApp {

    private JPanel mainContentPanel; // اللوحة الرئيسية لعرض المحتوى
    private List<String[]> cartItems; // قائمة العناصر الموجودة في سلة التسوق
    private boolean isLoggedIn = false; // متغير لتتبع حالة تسجيل الدخول

    // الدالة الرئيسية لتشغيل التطبيق
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClothingStoreApp().createMainWindow());
    }

    // دالة لإنشاء نافذة التطبيق الرئيسية
    public void createMainWindow() {
        JFrame mainFrame = new JFrame("Clothing Store");
        mainFrame.setSize(900, 600); // ضبط حجم النافذة
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // إنهاء التطبيق عند إغلاق النافذة
        mainFrame.setLayout(new BorderLayout()); // استخدام تخطيط الحدود

        cartItems = new ArrayList<>(); // تهيئة قائمة سلة التسوق
        JMenuBar menuBar = createMenuBar(); // إنشاء شريط القوائم
        mainFrame.setJMenuBar(menuBar); // إضافة شريط القوائم إلى الإطار

        mainContentPanel = new JPanel(new BorderLayout()); // إنشاء لوحة محتوى جديدة
        mainFrame.add(mainContentPanel, BorderLayout.CENTER); // إضافة اللوحة إلى الإطار

        showProducts(); // عرض المنتجات عند فتح التطبيق
        mainFrame.setLocationRelativeTo(null); // مركز النافذة في الشاشة
        mainFrame.setVisible(true); // عرض النافذة
    }

    // دالة لإنشاء شريط القوائم
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(63, 81, 181)); // لون خلفية شريط القوائم

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setForeground(Color.WHITE); // لون النص للأبيض
        optionsMenu.setFont(new Font("SansSerif", Font.BOLD, 14));

        JMenuItem viewProducts = new JMenuItem("View Products");
        viewProducts.setBackground(new Color(77, 121, 255)); // لون خلفية عنصر القائمة
        viewProducts.setForeground(Color.WHITE);

        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.setBackground(new Color(77, 121, 255));
        viewCart.setForeground(Color.WHITE);
        viewCart.addActionListener(e -> {
            if (isLoggedIn) {
                openCartWindow(); // فتح نافذة السلة إذا كان المستخدم مسجلاً للدخول
            } else {
                openLoginFrame(); // فتح نافذة تسجيل الدخول إذا لم يكن مسجلاً
            }
        });

        JMenuItem addProductItem = new JMenuItem("Add Product"); // عنصر "Add Product" الجديد
        addProductItem.setBackground(new Color(77, 121, 255));
        addProductItem.setForeground(Color.WHITE);
        addProductItem.addActionListener(e -> {
            if (isLoggedIn) {
                openAddProductWindow(); // فتح نافذة إضافة المنتج إذا كان المستخدم مسجلاً للدخول
            } else {
                openLoginFrame(); // فتح نافذة تسجيل الدخول إذا لم يكن مسجلاً
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setBackground(new Color(77, 121, 255));
        exitItem.setForeground(Color.WHITE);

        optionsMenu.add(viewProducts);
        optionsMenu.add(viewCart);
        optionsMenu.add(addProductItem); // إضافة عنصر "Add Product" إلى القائمة
        optionsMenu.addSeparator();
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);

        JMenuItem loginButton = new JMenuItem("Login");
        loginButton.setBackground(new Color(77, 121, 255)); // لون خلفية زر تسجيل الدخول
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> {
            if (!isLoggedIn) {
                openLoginFrame(); // فتح نافذة تسجيل الدخول
            }
        });

        JMenuItem registerButton = new JMenuItem("Register"); // زر "Register" الجديد
        registerButton.setBackground(new Color(77, 121, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(e -> openRegisterWindow()); // فتح نافذة التسجيل

        exitItem.addActionListener(e -> System.exit(0));

        menuBar.add(loginButton);
        menuBar.add(registerButton); // إضافة زر "Register" إلى شريط القوائم

        return menuBar;
    }

    // دالة لفتح نافذة التسجيل
    private void openRegisterWindow() {
        JFrame registerFrame = new JFrame("Register User");
        RegisterUserWindow registerWindow = new RegisterUserWindow(this);
        registerFrame.add(registerWindow.getPanel());
        registerFrame.setSize(400, 300);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
    }

    // دالة لتحديث حالة تسجيل الدخول
    public void updateLoginStatus(boolean loggedIn) {
        isLoggedIn = loggedIn; // تحديث حالة تسجيل الدخول
    }

    // دالة لعرض المنتجات
    private void showProducts() {
        mainContentPanel.removeAll();

        JPanel productsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        productsPanel.setBackground(new Color(230, 230, 250));

        String sql = "SELECT name, price, description, image FROM product";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                byte[] imageBytes = rs.getBytes("image");

                ImageIcon productImage = new ImageIcon(imageBytes);
                productImage = new ImageIcon(productImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

                JPanel productCard = createProductCard(productImage, name, "$" + price);
                productsPanel.add(productCard);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading products: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(productsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainContentPanel.add(scrollPane, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private JPanel createProductCard(ImageIcon productImage, String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        card.setBackground(new Color(255, 255, 240));
        card.setPreferredSize(new Dimension(200, 300));

        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(imageLabel);

        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(51, 51, 102));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(nameLabel);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setForeground(new Color(0, 100, 0));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(priceLabel);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCartButton.setBackground(new Color(72, 209, 204));
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.addActionListener(e -> addToCart(new String[] { productName, price }));
        card.add(addToCartButton);

        return card;
    }

    private void openCartWindow() {
        CartWindow cartWindow = new CartWindow(cartItems);
        mainContentPanel.removeAll();
        mainContentPanel.add(cartWindow.getPanel(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private void openAddProductWindow() {
        AddProductWindow addProductWindow = new AddProductWindow();
        mainContentPanel.removeAll();
        mainContentPanel.add(addProductWindow.getPanel(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private void openLoginFrame() {
        new LoginFrame();
        isLoggedIn = true;
    }

    private void addToCart(String[] product) {
        if (isLoggedIn) {
            cartItems.add(product);
            JOptionPane.showMessageDialog(null, product[1] + " has been added to the cart.");
        } else {
            openLoginFrame();
        }
    }
}
