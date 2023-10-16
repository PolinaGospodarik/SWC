package logic;

import entity.Ammunition;
import util.Creator;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    public static List<Ammunition> readFromBin(String filePath) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

            Object readObject = objectInputStream.readObject();
            if (readObject instanceof List) {
                List<Ammunition> loadedData = (List<Ammunition>) readObject;
                objectInputStream.close();

                JOptionPane.showMessageDialog(null, "Данные успешно загружены из бинарного файла.");
                return loadedData;
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при чтении файла.");
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Ammunition> readFromTXT(String filePath) {
        try {

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
            JOptionPane.showMessageDialog(null, "Данные успешно загружены из текстового файла.");
            return ammunition;



        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Произошла ошибка при чтении файла.");
            ex.printStackTrace();
        }
        return null;
    }
}
