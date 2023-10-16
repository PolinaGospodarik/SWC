package view;




import entity.Ammunition;
import logic.Sorter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TypeSelector extends JDialog {

    static List<Ammunition> list = null;
    public TypeSelector(JFrame parent) {
        super(parent, "Выбор типа", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(200, 200);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));



        JRadioButton radioButton1 = new JRadioButton();
        JRadioButton radioButton2 = new JRadioButton();
        JRadioButton radioButton3 = new JRadioButton();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        JLabel label1 = new JLabel("Мечи");
        JLabel label2 = new JLabel("Нагрудники");
        JLabel label3 = new JLabel("Шлемы");



        inputPanel.add(radioButton1);
        inputPanel.add(label1);
        inputPanel.add(radioButton2);
        inputPanel.add(label2);
        inputPanel.add(radioButton3);
        inputPanel.add(label3);

        radioButton1.setSelected(true);

        JButton submitButton = new JButton("Отправить");

        // Создаем вложенное окно
        JDialog frame = new JDialog(parent, "Второе окно", true);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setSize(200, 200);

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        /*secondPanel.add(menuPanel, BorderLayout.NORTH);*/
        secondPanel.add(inputPanel, BorderLayout.WEST);
        secondPanel.add(submitButton, BorderLayout.SOUTH);

        frame.add(secondPanel);
        add(secondPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем выбранный элемент из меню

                if (radioButton1.isSelected()) {
                    list = Sorter.getSwords();
                } else if (radioButton2.isSelected()) {
                    list = Sorter.getChestplates();
                }
                else
                {
                    list = Sorter.getHelmets();
                }


                dispose();
            }
        });


    }

    public static List<Ammunition> Show(JFrame parent) {
        TypeSelector dialog = new TypeSelector(parent);
        dialog.setVisible(true);
        return list;
    }
}
