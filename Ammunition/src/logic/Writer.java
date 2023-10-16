package logic;

import com.fasterxml.jackson.core.type.TypeReference;
import view.Printer;
import entity.Ammunition;
import javax.swing.*;
import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

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


    public static void writeToTxt(String filePath) {

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

    public static void writeToJson(String filePath) {

        try {

            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".json";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(Manager.getList());
            writer.write(json);
            writer.close();
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            ex.printStackTrace();
        }
    }

    public static void write(String filePath, String text) {

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
