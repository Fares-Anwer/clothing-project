package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingStoreApp {

    private JPanel mainContentPanel;
    private List<String[]> cartItems; // قائمة لتخزين المنتجات المضافة إلى السلة

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClothingStoreApp().createMainWindow());
    }

    public void createMainWindow() {
        JFrame mainFrame = new JFrame("Clothing Store");
        mainFrame.setSize(900, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        cartItems = new ArrayList<>(); // تهيئة السلة

        JMenuBar menuBar = createMenuBar();
        mainFrame.setJMenuBar(menuBar);

        mainContentPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainContentPanel, BorderLayout.CENTER);

        showProducts(); // عرض المنتجات بتنسيقها الأصلي

        mainFrame.setLocationRelativeTo(null);
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

        customizeMenuItem(viewProducts, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        customizeMenuItem(viewCart, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));

        optionsMenu.add(viewProducts);
        optionsMenu.add(viewCart);
        menuBar.add(optionsMenu);

        JMenuItem loginButton = new JMenuItem("Login");
        customizeMenuItem(loginButton, new Color(220, 220, 220), new Font("SansSerif", Font.PLAIN, 12));
        loginButton.addActionListener(e -> openLoginFrame());
        menuBar.add(loginButton);

        viewProducts.addActionListener(e -> showProducts());
        viewCart.addActionListener(e -> openCartWindow());

        return menuBar;
    }

    private void showProducts() {
        mainContentPanel.removeAll();
        JPanel productsPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // شبكة 3 أعمدة

        productsPanel.setBackground(new Color(240, 240, 240));

        String[][] products = {
                { "../../../../resources/images/Hat.jpg", "Shirt", "$20" },
                { "../../../../resources/images/Bags.jpg", "Pants", "$30" },
                { "/../../../../../../images/Shoes.jpg", "Shoes", "$40" },
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

        // الصورة - تأكد من تحديث المسار ليعمل بشكل صحيح
        ImageIcon productImage = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(imageLabel);

        // اسم المنتج
        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(nameLabel);

        // السعر
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(priceLabel);

        // زر "Add to Cart"
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCartButton.addActionListener(e -> addToCart(new String[] { imagePath, productName, price }));
        card.add(addToCartButton);

        return card;
    }

    private void addToCart(String[] product) {
        cartItems.add(product);
        JOptionPane.showMessageDialog(null, product[1] + " has been added to the cart.");
    }

    private void openCartWindow() {
        CartWindow cartWindow = new CartWindow(cartItems);
        mainContentPanel.removeAll();
        mainContentPanel.add(cartWindow.getPanel(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private void customizeMenuItem(JMenuItem menuItem, Color backgroundColor, Font font) {
        menuItem.setBackground(backgroundColor);
        menuItem.setFont(font);
        menuItem.setOpaque(true);
    }

    public void openLoginFrame() {
        new LoginFrame();
    }
}
