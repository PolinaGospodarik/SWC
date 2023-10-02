package university.view;



import university.model.logic.Manager;
import university.util.Creator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CreatorWindow extends JDialog {
    private static String res = "Добавлено!";

    public CreatorWindow(JFrame parent) {
        super(parent, "Второе окно", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);

        // Остальной код вашего окна остается без изменений
        JPanel menuPanel = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Меч", "Нагурдник", "Шлем"});
        menuPanel.add(comboBox);

        // Создаем панель для ввода полей и кнопки
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(20);

        JLabel label1 = new JLabel("Поле 1:");
        JLabel label2 = new JLabel("Поле 2:");
        JLabel label3 = new JLabel("Поле 3:");
        JLabel label4 = new JLabel("Поле 3:");

        inputPanel.add(label1);
        inputPanel.add(textField1);
        inputPanel.add(label2);
        inputPanel.add(textField2);
        inputPanel.add(label3);
        inputPanel.add(textField3);
        inputPanel.add(label4);
        inputPanel.add(textField4);

        JButton submitButton = new JButton("Отправить");

        // Создаем вложенное окно
        JDialog frame = new JDialog(parent, "Второе окно", true);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        secondPanel.add(menuPanel, BorderLayout.NORTH);
        secondPanel.add(inputPanel, BorderLayout.CENTER);
        secondPanel.add(submitButton, BorderLayout.SOUTH);

        frame.add(secondPanel);
        add(secondPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем выбранный элемент из меню

                Map<String, String> dict = new HashMap<>();
                dict.put("Нагрудник", "Chestplate");
                dict.put("Шлем", "Helmet");
                dict.put("Меч", "Sword");


                /*System.out.println(dict.get((String) comboBox.getSelectedItem()));
                System.out.println(textField1.getText());
                System.out.println(textField2.getText());
                System.out.println(Integer.parseInt(textField3.getText()));
                System.out.println(Integer.parseInt(textField4.getText()));*/
                try {
                    Manager.Add(Creator.Create(
                            dict.get((String) comboBox.getSelectedItem()),
                            textField1.getText(),
                            textField2.getText(),
                            Integer.parseInt(textField3.getText()),
                            Integer.parseInt(textField4.getText())
                    ));
                    res = "Добавлено!";
                } catch (Exception ex) {
                    res = "Ошибка!";
                }

                // Закрываем окно
                dispose();

                // После закрытия окна, отображаем сообщение
                JOptionPane.showMessageDialog(parent, res);
            }
        });


    }

    public static String Show(JFrame parent) {
        CreatorWindow dialog = new CreatorWindow(parent);
        dialog.setVisible(true);
        return res;
    }
}
