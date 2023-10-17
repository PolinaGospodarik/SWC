import java.lang.constant.Constable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String line;

        System.out.print("Введите текст(0 - конец ввода):");

        while (!(line = scanner.nextLine()).equals("0")) {
            if(!text.toString().equals(""))
                text.append("\n");
            text.append(line);
        }

        System.out.print("Введите номер задания:");
        if(scanner.nextInt()==1)
            TextAnalyzer.z1(text.toString());
        else
            TextAnalyzer.z2(text.toString());

    }
}
