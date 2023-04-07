public class Dictionary {

    final String[] languageList = {"eng","deu","tur","fra"};


    public void getTranslations(Word word){
        FileManager fileManager = new FileManager();
        for (String language: languageList){
            if (!language.equals(word.getLanguage())) {
                System.out.println(fileManager.searchWord(word, language));
            }
        }

    }
}
