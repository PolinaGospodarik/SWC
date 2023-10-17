package main.java.view;


import main.java.entity.Ammunition;
import main.java.logic.Manager;
import main.java.util.Localisation;
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

    public void updateUI() {
        frame.setTitle(Localisation.getMessage("windowName"));
        view_but.setText(Localisation.getMessage("add"));
        add_but.setText(Localisation.getMessage("view"));
        summ_but.setText(Localisation.getMessage("pricesSum"));
        max_but.setText(Localisation.getMessage("expensive"));
        maxSort_but.setText(Localisation.getMessage("ascending"));
        minSort_but.setText(Localisation.getMessage("descending"));
        typeSort_but.setText(Localisation.getMessage("sortByType"));
        clear_but.setText(Localisation.getMessage("clear"));

        // Обновите названия меню и их элементов, если они есть
        fileMenu.setText(Localisation.getMessage("file"));
        outSave_menu.setText(Localisation.getMessage("saveOutput"));
        saveCondition_menu.setText(Localisation.getMessage("saveCondition"));
        saveToBinary_menu.setText(Localisation.getMessage("saveToBinary"));
        saveToTxt_menu.setText(Localisation.getMessage("saveToTxt"));
        saveToJson_menu.setText(Localisation.getMessage("saveToJson"));
        loadCondition_menu.setText(Localisation.getMessage("loadCondition"));
        loadFromBinary_menu.setText(Localisation.getMessage("loadFormBinary"));
        loadFromTxt_menu.setText(Localisation.getMessage("loadFormTxt"));
        loadFromJson_menu.setText(Localisation.getMessage("loadFromJson"));
        languageMenu.setText(Localisation.getMessage("language"));
    }
    private final JFrame frame;
    private final JButton view_but;
    private final JButton add_but;
    private final JButton summ_but;
    private final JButton max_but;
    private final JButton maxSort_but;
    private final JButton minSort_but;
    private final JButton typeSort_but;
    private final JButton clear_but;
    private final JMenu fileMenu;
    private final JMenuItem outSave_menu;
    private final JMenu saveCondition_menu;
    private final JMenuItem saveToBinary_menu;
    private final JMenuItem saveToTxt_menu;
    private final JMenuItem saveToJson_menu;
    private final JMenu loadCondition_menu;
    private final JMenuItem loadFromBinary_menu;
    private final JMenuItem loadFromTxt_menu;
    private final JMenuItem loadFromJson_menu;
    private JMenu languageMenu;

    MainWindow()
    {
        frame = new JFrame(Localisation.getMessage("windowName"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 1));

        view_but = new JButton(Localisation.getMessage("add"));
        add_but = new JButton(Localisation.getMessage("view"));
        summ_but = new JButton(Localisation.getMessage("pricesSum"));
        max_but = new JButton(Localisation.getMessage("expensive"));
        maxSort_but = new JButton(Localisation.getMessage("ascending"));
        minSort_but = new JButton(Localisation.getMessage("descending"));
        typeSort_but = new JButton(Localisation.getMessage("sortByType"));
        clear_but = new JButton(Localisation.getMessage("clear"));


        buttonPanel.add(view_but);
        buttonPanel.add(add_but);
        buttonPanel.add(summ_but);
        buttonPanel.add(max_but);
        buttonPanel.add(maxSort_but);
        buttonPanel.add(minSort_but);
        buttonPanel.add(typeSort_but);
        buttonPanel.add(clear_but);

        panel.add(buttonPanel, BorderLayout.EAST);
        frame.add(panel);

        JMenuBar menuBar = new JMenuBar();

        fileMenu = new JMenu(Localisation.getMessage("file"));
        outSave_menu= new JMenuItem(Localisation.getMessage("saveOutput"));

        saveCondition_menu = new JMenu(Localisation.getMessage("saveCondition"));
        saveToBinary_menu= new JMenuItem(Localisation.getMessage("saveToBinary"));
        saveToTxt_menu= new JMenuItem(Localisation.getMessage("saveToTxt"));
        saveToJson_menu= new JMenuItem(Localisation.getMessage("saveToJson"));

        loadCondition_menu = new JMenu(Localisation.getMessage("loadCondition"));
        loadFromBinary_menu= new JMenuItem(Localisation.getMessage("loadFormBinary"));
        loadFromTxt_menu= new JMenuItem(Localisation.getMessage("loadFormTxt"));
        loadFromJson_menu= new JMenuItem(Localisation.getMessage("loadFromJson"));

        fileMenu.add(outSave_menu);

        saveCondition_menu.add(saveToBinary_menu);
        saveCondition_menu.add(saveToTxt_menu);
        saveCondition_menu.add(saveToJson_menu);
        fileMenu.add(saveCondition_menu);

        loadCondition_menu.add(loadFromBinary_menu);
        loadCondition_menu.add(loadFromTxt_menu);
        loadCondition_menu.add(loadFromJson_menu);
        fileMenu.add(loadCondition_menu);

        languageMenu = new JMenu(Localisation.getMessage("language"));
        JMenuItem russianLanguage = new JMenuItem("Русский");
        JMenuItem englishLanguage = new JMenuItem("English");

        languageMenu.add(englishLanguage);
        languageMenu.add(russianLanguage);

        menuBar.add(fileMenu);
        menuBar.add(languageMenu);
        frame.setJMenuBar(menuBar);


        frame.setVisible(true);

        view_but.addActionListener(e -> CreatorWindow.Show(frame));

        add_but.addActionListener(e -> textArea.append("-------\n" + Printer.printInfo()));

        summ_but.addActionListener(e -> textArea.append("-------\n" + Localisation.getMessage("totalAmount")+" =" + Manager.Sum() + "\n"));

        max_but.addActionListener(e -> textArea.append("-------\n" + Manager.MaxPrice().toString() + "\n"));
        clear_but.addActionListener(e -> textArea.setText(""));

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
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("textFiles")+"(*.txt)", "txt");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                Writer.writeToTxt(filePath);
            }
        });

        saveToBinary_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("binaryFiles")+"(*.bin)", "bin");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();

                Writer.writeToBin(filePath);
            }
        });

        saveToJson_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("jsonFiles")+"(*.json)", "json");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();

                Writer.writeToJson(filePath);
            }
        });


        outSave_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("textFiles")+"(*.txt)", "txt");
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
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("binaryFiles")+"(*.bin)", "bin");
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
                else textArea.append(Localisation.getMessage("fileWithoutData"));

            }
        });

        loadFromTxt_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            // Создаем фильтр для файлов с расширением .txt
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("textFiles")+"(*.txt)", "txt");
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
                else textArea.append(Localisation.getMessage("fileWithoutData"));
            }
        });

        loadFromJson_menu.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            // Создаем фильтр для файлов с расширением .bin
            FileNameExtensionFilter filter = new FileNameExtensionFilter(Localisation.getMessage("jsonFiles")+"(*.json)", "json");
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
                else textArea.append(Localisation.getMessage("fileWithoutData"));

            }
        });

        russianLanguage.addActionListener(e -> {
            Localisation.setLocale("ru", "RU");
            updateUI();
        });

        englishLanguage.addActionListener(e -> {
            Localisation.setLocale("en", "US");
            updateUI();
        });


    }
}