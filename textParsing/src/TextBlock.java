import java.util.ArrayList;
import java.util.List;

class TextBlock {
    private List<Sentence> sentences;

    public TextBlock() {
        sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
