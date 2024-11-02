package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class CartWindow {
    private JPanel panel;

    public CartWindow() {
        // إعداد الخصائص الخاصة بـ CartWindow
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Shopping Cart");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(63, 81, 181));
        panel.add(titleLabel, BorderLayout.NORTH);

        // منطقة عرض العناصر في السلة
        JTextArea cartItemsArea = new JTextArea(10, 30);
        cartItemsArea.setEditable(false); // لجعل المنطقة غير قابلة للتحرير
        panel.add(new JScrollPane(cartItemsArea), BorderLayout.CENTER);

        // إضافة بعض العناصر التجريبية
        cartItemsArea.setText("1. Product A\n2. Product B\n3. Product C");
    }

    public JPanel getPanel() {
        return panel; // إرجاع اللوحة الخاصة بالسلة
    }
}
