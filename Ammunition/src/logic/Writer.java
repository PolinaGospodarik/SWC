package logic;

import view.Printer;

import javax.swing.*;
import java.io.*;

public class Writer {
    public static void writeToBin(String filePath) {

        boolean result = true;

        try {
            if (!filePath.toLowerCase().endsWith(".bin")) {
                filePath += ".bin";
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(Manager.getList());
            objectOutputStream.close();
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            ex.printStackTrace();
        }

    }


    public static void writeToTXT(String filePath) {

        boolean result = true;
        try {

            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Printer.serialize(Manager.getList()));
            writer.close();
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            ex.printStackTrace();
        }
    }

    public static void write(String filePath, String text) {

        boolean result = true;
        try {

            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            writer.close();
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            ex.printStackTrace();
        }
    }
}
