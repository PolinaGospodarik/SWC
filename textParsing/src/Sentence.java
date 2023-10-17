import java.util.ArrayList;
import java.util.List;

class Sentence {
    private List<String> words;

    public Sentence() {
        words = new ArrayList<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }
}
