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
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(63, 81, 181)); // تعيين لون خلفية شريط القوائم

        JMenu optionsMenu = new JMenu("Options"); // قائمة الخيارات
        optionsMenu.setForeground(Color.WHITE); // لون النص
        optionsMenu.setFont(new Font("SansSerif", Font.BOLD, 14)); // تعيين خط القائمة

        JMenuItem viewProducts = new JMenuItem("View Products"); // عنصر قائمة لعرض المنتجات
        JMenuItem viewCart = new JMenuItem("View Cart"); // عنصر قائمة لعرض سلة التسوق

        optionsMenu.add(viewProducts); // إضافة العناصر إلى القائمة
        optionsMenu.add(viewCart);
        menuBar.add(optionsMenu); // إضافة القائمة إلى شريط القوائم

        JMenuItem loginButton = new JMenuItem("Login"); // عنصر قائمة لتسجيل الدخول
        menuBar.add(loginButton); // إضافة زر تسجيل الدخول إلى شريط القوائم

        // إضافة أحداث الضغط على الأزرار
        viewProducts.addActionListener(e -> showProducts()); // عرض المنتجات عند الضغط
        viewCart.addActionListener(e -> openCartWindow()); // فتح نافذة السلة
        loginButton.addActionListener(e -> openLoginFrame()); // فتح نافذة تسجيل الدخول

        return menuBar; // إرجاع شريط القوائم
    }

    // دالة لعرض المنتجات
    private void showProducts() {
        mainContentPanel.removeAll(); // إزالة جميع المكونات السابقة

        JPanel productsPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // لوحة جديدة لتخطيط المنتجات

        // بيانات المنتجات (صورة، اسم، سعر)
        String[][] products = {
                { "images/Shirt.jpg", "Shirt", "$20" },
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

        // إنشاء بطاقات للمنتجات وإضافتها إلى اللوحة
        for (String[] product : products) {
            JPanel productCard = createProductCard(product[0], product[1], product[2]);
            productsPanel.add(productCard);
        }

        // إضافة شريط تمرير للوحة المنتجات
        JScrollPane scrollPane = new JScrollPane(productsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // إخفاء شريط التمرير الأفقي
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // إظهار شريط التمرير العمودي
                                                                                         // عند الحاجة

        mainContentPanel.add(scrollPane, BorderLayout.CENTER); // إضافة اللوحة إلى اللوحة الرئيسية
        mainContentPanel.revalidate(); // تحديث المكونات
        mainContentPanel.repaint(); // إعادة رسم اللوحة
    }

    // دالة لإنشاء بطاقة المنتج
    private JPanel createProductCard(String imagePath, String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS)); // استخدام تخطيط عمودي
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // تعيين حدود البطاقة
        card.setBackground(Color.WHITE); // تعيين لون خلفية البطاقة
        card.setPreferredSize(new Dimension(200, 300)); // تعيين حجم البطاقة

        // تحميل الصورة للمنتج
        ImageIcon productImage = loadImage(imagePath);
        JLabel imageLabel = new JLabel(productImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة الصورة في الوسط
        card.add(imageLabel);

        // إضافة اسم المنتج
        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); // تعيين الخط
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة الاسم في الوسط
        card.add(nameLabel);

        // إضافة سعر المنتج
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين الخط
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة السعر في الوسط
        card.add(priceLabel);

        // إضافة زر "إضافة إلى السلة"
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة الزر في الوسط
        addToCartButton.addActionListener(e -> addToCart(new String[] { imagePath, productName, price })); // إضافة حدث
                                                                                                           // للزر
        card.add(addToCartButton);

        return card; // إرجاع البطاقة
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

    // دالة لفتح نافذة تسجيل الدخول
    private void openLoginFrame() {
        new LoginFrame(); // إنشاء نافذة تسجيل الدخول
    }
}
