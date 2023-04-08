public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Word word = new Word("yaş","tur");

        dictionary.getTranslations(word);
    }
}
