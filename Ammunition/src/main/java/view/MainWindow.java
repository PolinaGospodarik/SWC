package main.java.view;


import main.java.entity.Ammunition;
import main.java.logic.Manager;
import main.java.util.Reader;
import main.java.logic.Sorter;
import main.java.util.Writer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.List;
import java.util.Objects;


public class MainWindow extends Component {
    public static void main(String[] args) {
        new MainWindow();
    }

    MainWindow()
    {
        JFrame frame = new JFrame("Аммуниция");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1));

        JButton view_but = new JButton("Добавить");
        JButton add_but = new JButton("Вывести");
        JButton summ_but = new JButton("Сумма цен");
        JButton max_but = new JButton("Самая дорогая");
        JButton maxSort_but = new JButton("Вывод по возрастанию цены");
        JButton minSort_but = new JButton("Вывод по убыванию цены");
        JButton typeSort_but = new JButton("Отсортировать по типу аммуници");


        buttonPanel.add(view_but);
        buttonPanel.add(add_but);
        buttonPanel.add(summ_but);
        buttonPanel.add(max_but);
        buttonPanel.add(maxSort_but);
        buttonPanel.add(minSort_but);
        buttonPanel.add(typeSort_but);

        panel.add(buttonPanel, BorderLayout.EAST);
        frame.add(panel);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem outSave_menu= new JMenuItem("Сохранить вывод");

        JMenu saveCondition_menu = new JMenu("Сохранить состояние");
        JMenuItem saveToBinary_menu= new JMenuItem("Сохранить в биинарный файл");
        JMenuItem saveToTxt_menu= new JMenuItem("Сохранить в тестовый файл");
        JMenuItem saveToJson_menu= new JMenuItem("Сохранить в Json");

        JMenu loadCondition_menu = new JMenu("Загрузить состояние");
        JMenuItem loadFromBinary_menu= new JMenuItem("Загрузить из биинарного файла");
        JMenuItem loadFromTxt_menu= new JMenuItem("Загрузить из тестового файла");
        JMenuItem loadFromJson_menu= new JMenuItem("Загрузить из Json");

        fileMenu.add(outSave_menu);

        saveCondition_menu.add(saveToBinary_menu);
        saveCondition_menu.add(saveToTxt_menu);
        saveCondition_menu.add(saveToJson_menu);
        fileMenu.add(saveCondition_menu);

        loadCondition_menu.add(loadFromBinary_menu);
        loadCondition_menu.add(loadFromTxt_menu);
        loadCondition_menu.add(loadFromJson_menu);
        fileMenu.add(loadCondition_menu);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);


        frame.setVisible(true);

        view_but.addActionListener(e -> CreatorWindow.Show(frame));

        add_but.addActionListener(e -> textArea.append("-------\n" + Printer.printInfo()));

        summ_but.addActionListener(e -> textArea.append("-------\n" + "Общая сумма =" + Manager.Sum() + "\n"));

        max_but.addActionListener(e -> textArea.append("-------\n" + Manager.MaxPrice().toString() + "\n"));

        maxSort_but.addActionListener(e -> {
            Sorter.bubbleSorterUp();
            textArea.append("-------\n" + Printer.printInfo() + "\n");
        });

        minSort_but.addActionListener(e -> {
            Sorter.bubbleSorterDown();
            textArea.append("-------\n" + Printer.printInfo() + "\n");
        });

        typeSort_but.addActionListener(e -> textArea.append("-------\n" + Printer.printInfo(TypeSelector.Show(frame)) + "\n"));

        saveToTxt_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы(*.txt)", "txt");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                Writer.writeToTxt(filePath);
            }
        });

        saveToBinary_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Бинарные файлы (*.bin)", "bin");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();

                Writer.writeToBin(filePath);
            }
        });

        saveToJson_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Бинарные файлы (*.json)", "json");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();

                Writer.writeToJson(filePath);
            }
        });


        outSave_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы(*.txt)", "txt");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                Writer.write(filePath, textArea.getText());
            }
        });

        loadFromBinary_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            // Создаем фильтр для файлов с расширением .bin
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Бинарные файлы (*.bin)", "bin");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                String filePath = fileChooser.getSelectedFile().getPath();

                List<Ammunition> list = Reader.readFromBin(filePath);
                if(Objects.requireNonNull(list).size() > 0) {
                    Manager.ClearList();

                    for (Ammunition a : list) {
                        Manager.Add(a);
                    }
                }
                else textArea.append("Файл не содержит данных");

            }
        });

        loadFromTxt_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            // Создаем фильтр для файлов с расширением .txt
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы (*.txt)", "txt");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();

                List<Ammunition> list = Reader.readFromTxt(filePath);

                if(list.size() > 0) {
                    Manager.ClearList();

                    for (Ammunition a : list) {
                        Manager.Add(a);
                    }
                }
                else textArea.append("Файл не содержит данных");
            }
        });

        loadFromJson_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            // Создаем фильтр для файлов с расширением .bin
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Json файлы (*.json)", "json");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                String filePath = fileChooser.getSelectedFile().getPath();

                List<Ammunition> list = Reader.readFromJson(filePath);
                if(Objects.requireNonNull(list).size() > 0) {
                    Manager.ClearList();

                    for (Ammunition a : list) {
                        Manager.Add(a);
                    }
                }
                else textArea.append("Файл не содержит данных");

            }
        });

    }
}