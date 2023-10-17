package main.java.util;


import main.java.logic.Manager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import main.java.view.Printer;

import javax.swing.*;
import java.io.*;


import com.fasterxml.jackson.databind.ObjectMapper;

import static main.java.util.Logger.getLogg;

public class Writer {


    public static void writeToBin(String filePath) {
        org.apache.logging.log4j.Logger logger = getLogg();

        try {
            logger.info("Try writing to binary file " + filePath);
            if (!filePath.toLowerCase().endsWith(".bin")) {
                filePath += ".bin";
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(Manager.getList());
            objectOutputStream.close();
            logger.info("Writing successfully");
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            logger.error("Writing error: "+ ex.toString());
        }


    }


    public static void writeToTxt(String filePath) {

        org.apache.logging.log4j.Logger logger = getLogg();

        try {
            logger.info("Try writing to txt file " + filePath);

            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Printer.serialize(Manager.getList()));
            writer.close();
            logger.info("Writing successfully");
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            logger.error("Writing error: "+ ex.toString());
        }
    }

    public static void writeToJson(String filePath) {
        org.apache.logging.log4j.Logger logger = getLogg();

        try {
            logger.info("Try writing to json file " + filePath);
            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".json";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(Manager.getList());
            writer.write(json);
            writer.close();
            logger.info("Writing successfully");
            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            logger.error("Writing error: "+ ex.toString());
        }
    }

    public static void write(String filePath, String text) {
        org.apache.logging.log4j.Logger logger = getLogg();


        try {
            logger.info("Try writing output " + filePath);

            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            writer.write(text);
            writer.close();
            logger.info("Writing successfully");

            JOptionPane.showMessageDialog(null, "Файл успешно сохранен.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при сохранении файла.");
            logger.error("Writing error: "+ ex.toString());
        }
    }
}
