import java.util.ArrayList;
import java.util.List;

public class TextAnalyzer {

    public static void z1(String text)
    {
        TextParser parser = new TextParser();
        Text parsedText = parser.parse(text);

        List<String> firstSentenceWords = parsedText.getBlocks().get(0).getSentences().get(0).getWords();
        List<String> otherSentenceWords = new ArrayList<>();
        for (int i = 1; i < parsedText.getBlocks().size(); i++) {
            otherSentenceWords.addAll(parsedText.getBlocks().get(i).getSentences().get(0).getWords());
        }

        for (String word : firstSentenceWords) {
            if (!otherSentenceWords.contains(word)) {
                System.out.println("Слово в первом предложении, которого нет ни в одном из остальных предложений: " + word);
                break;
            }
        }
    }

    public static void z2(String text)
    {
        TextParser parser = new TextParser();
        Text parsedText = parser.parse(text);

        int targetLength = 5;
        char[] consonants = "бвгджзклмнпрстфхцчшщ".toCharArray();
        for (TextBlock block : parsedText.getBlocks()) {
            for (Sentence sentence : block.getSentences()) {
                for (int i = sentence.getWords().size() - 1; i >= 0; i--) {
                    String word = sentence.getWords().get(i);
                    if (word.length() == targetLength && isConsonant(word.charAt(0), consonants)) {
                        sentence.getWords().remove(i);
                    }
                }
            }
        }

        String originalText = reconstructText(parsedText);
        System.out.println("Оригинальный текст после удаления слов заданной длины: \n" + originalText);
    }

    private static boolean isConsonant(char c, char[] consonants) {
        for (char consonant : consonants) {
            if (c == consonant) {
                return true;
            }
        }
        return false;
    }

    // Метод для восстановления текста
    private static String reconstructText(Text parsedText) {
        StringBuilder reconstructedText = new StringBuilder();

        for (TextBlock block : parsedText.getBlocks()) {
            for (Sentence sentence : block.getSentences()) {
                for (String word : sentence.getWords()) {
                    reconstructedText.append(word).append(" ");
                }
                reconstructedText.append(". ");
            }
            reconstructedText.append("\n");
        }

        return reconstructedText.toString().trim();
    }
}
