package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ClothingStoreApp {

    private JPanel mainContentPanel; // اللوحة الرئيسية لعرض المحتوى
    private List<String[]> cartItems; // قائمة العناصر الموجودة في سلة التسوق

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
    // دالة لإنشاء شريط القوائم
    private boolean isLoggedIn = false; // متغير لتتبع حالة تسجيل الدخول

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

        exitItem.addActionListener(e -> System.exit(0));

        menuBar.add(loginButton);

        return menuBar;
    }

    // دالة لتحديث حالة تسجيل الدخول
    public void updateLoginStatus(boolean loggedIn) {
        isLoggedIn = loggedIn; // تحديث حالة تسجيل الدخول
    }

    // دالة لعرض المنتجات
    private void showProducts() {
        mainContentPanel.removeAll();

        JPanel productsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        productsPanel.setBackground(new Color(230, 230, 250)); // لون خلفية اللوحة التي تحتوي المنتجات

        // بيانات المنتجات (صورة، اسم، سعر)
        String[][] products = {
                { "/src/main/resources/datab", "Shirt", "$20" },
                { "images/Pants.jpg", "Pants", "$30" },
                { "images/Shoes.jpg", "Shoes", "$40" },
                { "images/Jacket.jpg", "Jacket", "$60" },
                { "images/Hat.jpg", "Hat", "$15" },
                { "images/Sweater.jpg", "Sweater", "$10" },
                { "images/T-Shirt.jpg", "T-Shirt", "$5" },
                { "images/Bags.jpg", "Bags", "$25" },
                { "images/Socks.jpg", "Socks", "$50" },
                { "images/Jeans.jpg", "Jeans", "$12" },
                { "images/Scarf.jpg", "Scarf", "$18" },
                { "images/Shorts.jpg", "Shorts", "$8" }
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

    // دالة لإنشاء بطاقة المنتج
    private JPanel createProductCard(String imagePath, String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1)); // حدود البطاقة بلون رمادي فاتح
        card.setBackground(new Color(255, 255, 240)); // لون خلفية البطاقة كريمي
        card.setPreferredSize(new Dimension(200, 300));

        ImageIcon productImage = loadImage(imagePath);
        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(imageLabel);

        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(51, 51, 102)); // لون النص
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(nameLabel);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setForeground(new Color(0, 100, 0)); // لون النص للسعر أخضر داكن
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(priceLabel);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCartButton.setBackground(new Color(72, 209, 204)); // لون زر إضافة للسلة
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.addActionListener(e -> addToCart(new String[] { imagePath, productName, price }));
        card.add(addToCartButton);

        return card;
    }

    // دالة لتحميل الصورة
    private ImageIcon loadImage(String imagePath) {
        try {
            // InputStream imageStream = getClass().getResourceAsStream(imagePath);
            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("images/" + imagePath);

            if (imageStream != null) {
                Image originalImage = ImageIO.read(imageStream);
                Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // تغيير حجم الصورة
                return new ImageIcon(resizedImage); // إرجاع الصورة المعدلة
            } else {
                System.out.println("Image not found at: " + imagePath);
                return new ImageIcon(); // إرجاع أيقونة فارغة إذا لم توجد الصورة
            }
        } catch (Exception e) {
            System.out.println("Error loading image from: " + imagePath + " - " + e.getMessage());
            return new ImageIcon(); // إرجاع أيقونة فارغة إذا حدث خطأ أثناء التحميل
        }
    }

    // دالة لإضافة المنتج إلى السلة
    private void addToCart(String[] product) {
        cartItems.add(product); // إضافة المنتج إلى القائمة
        JOptionPane.showMessageDialog(null, product[1] + " has been added to the cart."); // عرض رسالة للمستخدم
    }

    // دالة لفتح نافذة السلة
    private void openCartWindow() {
        CartWindow cartWindow = new CartWindow(cartItems); // إنشاء نافذة السلة
        mainContentPanel.removeAll(); // إزالة المكونات السابقة
        mainContentPanel.add(cartWindow.getPanel(), BorderLayout.CENTER); // إضافة لوحة السلة
        mainContentPanel.revalidate(); // تحديث المكونات
        mainContentPanel.repaint(); // إعادة رسم اللوحة
    }

    // دالة لفتح نافذة إضافة المنتج
    private void openAddProductWindow() {
        AddProductWindow addProductWindow = new AddProductWindow(); // إنشاء نافذة إضافة المنتج
        mainContentPanel.removeAll(); // إزالة المحتويات السابقة
        mainContentPanel.add(addProductWindow.getPanel(), BorderLayout.CENTER); // إضافة اللوحة الجديدة
        mainContentPanel.revalidate(); // تحديث المحتويات
        mainContentPanel.repaint(); // إعادة رسم اللوحة
    }

    // دالة لفتح نافذة تسجيل الدخول
    private void openLoginFrame() {
        new LoginFrame(); // إنشاء نافذة تسجيل الدخول
    }

}
