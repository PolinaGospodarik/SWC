
class TextParser {
    public Text parse(String text) {
        Text parsedText = new Text();
        String[] blocks = text.split("\n");

        for (String block : blocks) {
            TextBlock textBlock = new TextBlock();
            String[] sentences = block.split("[.!?]");
            for (String sentence : sentences) {
                Sentence textSentence = new Sentence();
                String[] sentenceWords = sentence.split("\\s+");
                for (String word : sentenceWords) {
                    textSentence.addWord(word);
                }
                textBlock.addSentence(textSentence);
            }
            parsedText.addBlock(textBlock);
        }

        return parsedText;
    }
}

