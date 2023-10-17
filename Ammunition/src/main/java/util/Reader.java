package main.java.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.entity.Ammunition;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.java.util.Logger.getLogg;

public class Reader {
    public static List<Ammunition> readFromBin(String filePath) {
        org.apache.logging.log4j.Logger logger = getLogg();

        try {
            logger.info("Try read from binary file " + filePath);

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

            Object readObject = objectInputStream.readObject();
            objectInputStream.close();

            if (readObject instanceof List) {
                List<Ammunition> loadedData = (List<Ammunition>) readObject;
                logger.info("Reading successfully");

                JOptionPane.showMessageDialog(null, "Данные успешно загружены из бинарного файла.");
                return loadedData;
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при чтении файла.");
            logger.error("Reading error: "+ ex.toString());
            return null;
        }
    }

    public static List<Ammunition> readFromTxt(String filePath) {
        org.apache.logging.log4j.Logger logger = getLogg();

        try {
            logger.info("Try read from txt file " + filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;

            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();


            Pattern pattern = Pattern.compile("\\[(.*?)\\]");

            // Создаем Matcher
            Matcher matcher = pattern.matcher(text.toString());

            // Находим все совпадения и выводим содержимое квадратных скобок
            List<Ammunition> ammunition = new ArrayList<Ammunition>();

            while (matcher.find()) {
                String[] data = matcher.group(1).split(",");
                ; // Группа 1 содержит текст внутри скобок
                ammunition.add(Creator.Create(data[0], data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4])));
            }
            logger.info("Reading successfully");
            JOptionPane.showMessageDialog(null, "Данные успешно загружены из текстового файла.");
            return ammunition;


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при чтении файла.");
            logger.error("Reading error: "+ ex.toString());
        }
        return null;
    }

    public static List<Ammunition> readFromJson(String filePath) {
        org.apache.logging.log4j.Logger logger = getLogg();
        try {
            logger.info("Try read from json file " + filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line = reader.readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            reader.close();
            List<Ammunition> ammunition = objectMapper.readValue(line, new TypeReference<List<Ammunition>>() {
            });

            logger.info("Reading successfully");
            JOptionPane.showMessageDialog(null, "Данные успешно загружены из текстового файла.");
            return ammunition;


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при чтении файла.");
            logger.error("Reading error: "+ ex.toString());
        }
        return null;
    }

}
