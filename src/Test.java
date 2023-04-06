public class Test {
    public static void main(String[] args) {
        DictionaryParser dictionaryParser = new DictionaryParser();
        FileManager fileManager = new FileManager();


        System.out.println(fileManager.searchWord("apple","eng"));
    }
}
