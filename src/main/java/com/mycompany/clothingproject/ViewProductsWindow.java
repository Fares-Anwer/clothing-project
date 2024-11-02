package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ViewProductsWindow {
    private ArrayList<String> cartItems; // لحفظ العناصر المضافة إلى السلة

    public ViewProductsWindow() {
        this.cartItems = new ArrayList<>(); // تهيئة قائمة السلة
        JFrame frame = new JFrame("View Products");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // إعداد لوحة رئيسية مع تخطيط عمودي
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 أعمدة مع مسافة بين العناصر
        mainPanel.setBackground(new Color(240, 240, 240)); // لون الخلفية

        // إضافة خلفية ملونة
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(63, 81, 181)); // لون خلفية مذهل
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        // بيانات المنتجات (يمكنك إضافة المزيد من المنتجات كما تشاء)
        Object[][] products = {
                { "path/to/shirt_image.jpg", "Shirt", "20$" },
                { "path/to/pants_image.jpg", "Pants", "30$" },
                { "path/to/shoes_image.jpg", "Shoes", "40$" },
                { "path/to/dress_image.jpg", "Dress", "50$" },
                { "path/to/hat_image.jpg", "Hat", "15$" },
                { "path/to/bag_image.jpg", "Bag", "35$" },
                { "path/to/sweater_image.jpg", "Sweater", "25$" },
                { "path/to/jacket_image.jpg", "Jacket", "60$" },
                { "path/to/shorts_image.jpg", "Shorts", "20$" },
                { "path/to/scarf_image.jpg", "Scarf", "12$" },
                { "path/to/jeans_image.jpg", "Jeans", "45$" },
                { "path/to/coat_image.jpg", "Coat", "80$" },
                { "path/to/boots_image.jpg", "Boots", "55$" },
                { "path/to/t-shirt_image.jpg", "T-Shirt", "18$" },
                { "path/to/sandals_image.jpg", "Sandals", "22$" },
                { "path/to/socks_image.jpg", "Socks", "5$" },
        };

        // إنشاء بطاقات لكل منتج
        for (Object[] product : products) {
            JPanel productPanel = createProductCard((String) product[0], (String) product[1], (String) product[2]);
            mainPanel.add(productPanel);
        }

        // إضافة زر لفتح سلة المشتريات
        JButton cartButton = new JButton("View Cart");
        cartButton.addActionListener(e -> openCartWindow());
        backgroundPanel.add(cartButton, BorderLayout.SOUTH); // إضافة الزر إلى الأسفل

        // إضافة اللوحة إلى الإطار
        JScrollPane scrollPane = new JScrollPane(backgroundPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // إعداد الإطار
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void openCartWindow() {
        new CartWindow(cartItems);
    }

    private JPanel createProductCard(String imagePath, String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(200, 300));
        card.setOpaque(true);

        // إضافة الصورة
        ImageIcon productImage = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(imageLabel);

        // إضافة اسم المنتج
        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(nameLabel);

        // إضافة السعر
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(priceLabel);

        // زر لإضافة المنتج إلى السلة
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> {
            cartItems.add(productName); // إضافة المنتج إلى السلة
            JOptionPane.showMessageDialog(card, productName + " has been added to the cart.");
        });
        card.add(addToCartButton);

        // إضافة تأثير عند تمرير الماوس فوق البطاقة
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                card.setBackground(new Color(230, 230, 250)); // لون خلفية مختلف عند التمرير
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                card.setBackground(Color.WHITE); // استرجاع اللون الأصلي
            }
        });

        return card;
    }
}
