package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class CartWindow {
    private List<String> cartItems; // قائمة العناصر في السلة

    public CartWindow(List<String> cartItems) {
        this.cartItems = cartItems;

        JFrame frame = new JFrame("Shopping Cart");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // إعداد لوحة لعرض العناصر في السلة
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        // إضافة العناصر إلى اللوحة
        for (String item : cartItems) {
            JLabel itemLabel = new JLabel(item);
            itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            cartPanel.add(itemLabel);
        }

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // إضافة زر لإغلاق النافذة
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
