package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ClothingStoreApp {

    private JPanel mainContentPanel; // اللوحة الرئيسية للتبديل بين المحتوى

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClothingStoreApp().createMainWindow());
    }

    public void createMainWindow() {
        JFrame mainFrame = new JFrame("Clothing Store");
        mainFrame.setSize(900, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // إعداد شريط القائمة كـ header ثابت
        JMenuBar menuBar = createMenuBar();
        mainFrame.setJMenuBar(menuBar); // تثبيت شريط القائمة في الأعلى

        // إعداد اللوحة الرئيسية للتبديل بين النوافذ
        mainContentPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainContentPanel, BorderLayout.CENTER);

        // عرض قائمة المنتجات كواجهة افتراضية
        showProducts();

        mainFrame.setLocationRelativeTo(null); // ظهور النافذة في منتصف الشاشة
        mainFrame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(63, 81, 181));

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setForeground(Color.WHITE);
        optionsMenu.setFont(new Font("SansSerif", Font.BOLD, 14));

        JMenuItem viewProducts = new JMenuItem("View Products");
        JMenuItem viewCart = new JMenuItem("View Cart");

        // تخصيص وتنسيق عناصر القائمة
        customizeMenuItem(viewProducts, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        customizeMenuItem(viewCart, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));

        optionsMenu.add(viewProducts);
        optionsMenu.add(viewCart);
        menuBar.add(optionsMenu);

        // زر تسجيل الدخول كعنصر منفصل
        JMenuItem loginButton = new JMenuItem("Login");
        customizeMenuItem(loginButton, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        loginButton.addActionListener(e -> openLoginFrame());
        menuBar.add(loginButton);

        // إعداد التفاعل مع عناصر القائمة
        viewProducts.addActionListener(e -> showProducts());
        viewCart.addActionListener(e -> openCartWindow());

        return menuBar;
    }

    private void showProducts() {
        mainContentPanel.removeAll();
        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(0, 3, 15, 15)); // 3 أعمدة مع مسافة بين العناصر
        productsPanel.setBackground(new Color(240, 240, 240)); // لون الخلفية

        // بيانات المنتجات
        String[][] products = {
                { "path/to/shirt_image.jpg", "Shirt", "$20" },
                { "path/to/pants_image.jpg", "Pants", "$30" },
                { "path/to/shoes_image.jpg", "Shoes", "$40" },
                { "path/to/dress_image.jpg", "Dress", "$50" },
                { "path/to/hat_image.jpg", "Hat", "$15" },
                { "path/to/bag_image.jpg", "Bag", "$35" },
                { "path/to/sweater_image.jpg", "Sweater", "$25" },
                { "path/to/jacket_image.jpg", "Jacket", "$60" },
                { "path/to/shorts_image.jpg", "Shorts", "$20" },
                { "path/to/scarf_image.jpg", "Scarf", "$12" },
                { "path/to/jeans_image.jpg", "Jeans", "$45" },
                { "path/to/coat_image.jpg", "Coat", "$80" },
                { "path/to/boots_image.jpg", "Boots", "$55" },
                { "path/to/t-shirt_image.jpg", "T-Shirt", "$18" },
                { "path/to/sandals_image.jpg", "Sandals", "$22" },
                { "path/to/socks_image.jpg", "Socks", "$5" },
        };

        for (String[] product : products) {
            JPanel productCard = createProductCard(product[0], product[1], product[2]);
            productsPanel.add(productCard);
        }

        JScrollPane scrollPane = new JScrollPane(productsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainContentPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private JPanel createProductCard(String imagePath, String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(200, 300));

        // إضافة الصورة
        ImageIcon productImage = new ImageIcon(imagePath); // تعديل هنا بحيث يتم وضع المسار الصحيح للصور
        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(imageLabel);

        // إضافة اسم المنتج
        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(Box.createRigidArea(new Dimension(0, 10))); // مسافة صغيرة
        card.add(nameLabel);

        // إضافة السعر
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(Box.createRigidArea(new Dimension(0, 5))); // مسافة صغيرة
        card.add(priceLabel);

        // زر لإضافة المنتج إلى السلة
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCartButton.addActionListener(
                e -> JOptionPane.showMessageDialog(card, productName + " has been added to the cart."));
        card.add(Box.createRigidArea(new Dimension(0, 10))); // مسافة صغيرة
        card.add(addToCartButton);

        return card;
    }

    private void customizeMenuItem(JMenuItem menuItem, Color backgroundColor, Font font) {
        menuItem.setBackground(backgroundColor);
        menuItem.setFont(font);
        menuItem.setOpaque(true);
    }

    public void openLoginFrame() {
        new LoginFrame(); // استدعاء التصميم الجاهز لتسجيل الدخول
    }

    public void openCartWindow() {
        mainContentPanel.removeAll();
        mainContentPanel.add(new CartWindow().getPanel(), BorderLayout.CENTER); // استدعاء تصميم السلة
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
}
