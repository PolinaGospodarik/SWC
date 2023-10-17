import java.util.ArrayList;
import java.util.List;

// Класс для представления текста и его структуры
class Text {
    private List<TextBlock> blocks;

    public Text() {
        blocks = new ArrayList<>();
    }

    public void addBlock(TextBlock block) {
        blocks.add(block);
    }

    public List<TextBlock> getBlocks() {
        return blocks;
    }
}
