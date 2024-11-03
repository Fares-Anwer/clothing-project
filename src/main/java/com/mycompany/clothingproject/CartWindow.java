package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CartWindow {
    private JPanel cartPanel; // لوحة السلة
    private List<String[]> cartItems; // قائمة العناصر في السلة

    // Constructor: يستقبل العناصر الموجودة في السلة ويقوم بإنشاء واجهة المستخدم
    public CartWindow(List<String[]> cartItems) {
        this.cartItems = cartItems; // تخزين العناصر في متغير الفئة
        createCartUI(); // استدعاء الدالة لإنشاء واجهة المستخدم
    }

    // دالة لإنشاء واجهة مستخدم السلة
    private void createCartUI() {
        cartPanel = new JPanel(); // إنشاء لوحة جديدة
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS)); // استخدام تخطيط عمودي
        cartPanel.setBackground(new Color(250, 250, 250)); // تعيين لون الخلفية

        // إضافة عنوان للسلة
        JLabel titleLabel = new JLabel("Your Shopping Cart");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18)); // تعيين الخط
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة العنوان في الوسط
        cartPanel.add(titleLabel); // إضافة العنوان إلى اللوحة
        cartPanel.add(Box.createRigidArea(new Dimension(0, 20))); // إضافة مساحة فارغة بين العنوان والعناصر

        // التحقق إذا كانت السلة فارغة
        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("Your cart is empty."); // رسالة للسلة الفارغة
            emptyLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cartPanel.add(emptyLabel); // إضافة الرسالة إلى اللوحة
        } else {
            // إذا كانت السلة تحتوي على عناصر، إضافة كل عنصر إلى اللوحة
            for (String[] item : cartItems) {
                JPanel itemPanel = new JPanel(); // إنشاء لوحة جديدة لكل عنصر
                itemPanel.setLayout(new BorderLayout()); // استخدام تخطيط الحدود
                itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // إضافة حدود فارغة
                itemPanel.setBackground(Color.WHITE); // تعيين لون خلفية العنصر

                // إنشاء تسمية تحتوي على اسم المنتج وسعره
                JLabel nameLabel = new JLabel(item[1] + " - " + item[2]);
                nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين الخط
                itemPanel.add(nameLabel, BorderLayout.CENTER); // إضافة التسمية إلى وسط اللوحة

                cartPanel.add(itemPanel); // إضافة لوحة العنصر إلى لوحة السلة
                cartPanel.add(Box.createRigidArea(new Dimension(0, 10))); // إضافة مساحة فارغة بين العناصر
            }
        }
    }

    // دالة لاسترجاع اللوحة الخاصة بالسلة
    public JPanel getPanel() {
        return cartPanel; // إرجاع اللوحة
    }
}
