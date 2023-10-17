package main.java.view;


import main.java.logic.Manager;
import main.java.util.Creator;
import main.java.util.Localisation;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CreatorWindow extends JDialog {


    public CreatorWindow(JFrame parent) {
        super(parent, Localisation.getMessage("add"), true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);

        // Остальной код вашего окна остается без изменений
        JPanel menuPanel = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>(new String[]{Localisation.getMessage("sword"), Localisation.getMessage("chestplate"), Localisation.getMessage("helmet")});
        menuPanel.add(comboBox);

        // Создаем панель для ввода полей и кнопки
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JCheckBox checkBox = new JCheckBox(Localisation.getMessage("random"));

        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(20);

        JLabel label1 = new JLabel(Localisation.getMessage("name")+":");
        JLabel label2 = new JLabel(Localisation.getMessage("material")+":");
        JLabel label3 = new JLabel(Localisation.getMessage("weight")+":");
        JLabel label4 = new JLabel(Localisation.getMessage("cost")+":");

        inputPanel.add(label1);
        inputPanel.add(textField1);
        inputPanel.add(label2);
        inputPanel.add(textField2);
        inputPanel.add(label3);
        inputPanel.add(textField3);
        inputPanel.add(label4);
        inputPanel.add(textField4);
        inputPanel.add(checkBox);

        JButton submitButton = new JButton(Localisation.getMessage("send"));

        // Создаем вложенное окно
        JDialog frame = new JDialog(parent, Localisation.getMessage("add"), true);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        secondPanel.add(menuPanel, BorderLayout.NORTH);
        secondPanel.add(inputPanel, BorderLayout.CENTER);
        secondPanel.add(submitButton, BorderLayout.SOUTH);

        frame.add(secondPanel);
        add(secondPanel);

        submitButton.addActionListener(e -> {


            Map<String, String> dict = new HashMap<>();
            dict.put(Localisation.getMessage("chestplate"), "Chestplate");
            dict.put(Localisation.getMessage("helmet"), "Helmet");
            dict.put(Localisation.getMessage("sword"), "Sword");

            if(checkBox.isSelected())
            {
                Manager.Add(Creator.Create(dict.get((String) comboBox.getSelectedItem())));
                JOptionPane.showMessageDialog(parent, Localisation.getMessage("added"));
            }
            else
            {
                try {
                    Manager.Add(Creator.Create(
                            dict.get((String) comboBox.getSelectedItem()),
                            textField1.getText(),
                            textField2.getText(),
                            Integer.parseInt(textField3.getText()),
                            Integer.parseInt(textField4.getText())
                    ));
                    JOptionPane.showMessageDialog(parent, Localisation.getMessage("added"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(parent, Localisation.getMessage("error"));
                }
            }


            // Закрываем окно
            dispose();

            // После закрытия окна, отображаем сообщение

        });

        checkBox.addActionListener(e ->{

            boolean isSelected = checkBox.isSelected();
            textField1.setEnabled(!isSelected);
            textField2.setEnabled(!isSelected);
            textField3.setEnabled(!isSelected);
            textField4.setEnabled(!isSelected);
            });



    }

    public static void Show(JFrame parent) {
        CreatorWindow dialog = new CreatorWindow(parent);
        dialog.setVisible(true);
    }


}
