package by.bntu.fitr.poisit.polmac.university.view;

import by.bntu.fitr.poisit.polmac.university.model.entity.Ammunition;
import by.bntu.fitr.poisit.polmac.university.model.entity.Sword;
import by.bntu.fitr.poisit.polmac.university.model.entity.Helmet;
import by.bntu.fitr.poisit.polmac.university.model.entity.Chestplate;
import by.bntu.fitr.poisit.polmac.university.model.logic.Manager;
import by.bntu.fitr.poisit.polmac.university.model.logic.Sorter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример интерфейса");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea =  new JTextArea();
        textArea.setEditable(false);


        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1));

        JButton button1 = new JButton("Добавить");
        JButton button2 = new JButton("Вывести");
        JButton button3 = new JButton("Сумма цен");
        JButton button4 = new JButton("Самая дорогая");
        JButton button5 = new JButton("Вывод по возрастанию цены");
        JButton button6 = new JButton("Вывод по убыванию цены");
        JButton button7 = new JButton("Отсортировать по типу аммуници");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);

        panel.add(buttonPanel, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatorWindow.Show(frame); // Передаем родительское окно
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("-------\n"+ Printer.printAll());
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("-------\n"+"Общая сумма =" + Manager.Sum()+"\n");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("-------\n"+Manager.MaxPrice().toString()+"\n");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorter.bubbleSorterUp();
                textArea.append("-------\n"+ Printer.printAll()+"\n");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorter.bubbleSorterDown();
                textArea.append("-------\n"+ Printer.printAll()+"\n");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorter.bubbleSorterUp();
                textArea.append("-------\n"+ Printer.printAll()+"\n");
            }
        });
    }
}