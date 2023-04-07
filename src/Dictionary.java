public class Dictionary {

    final String[] languageList = {"eng","deu","tur","fra"};


    public void getTranslations(Word word){
        FileManager fileManager = new FileManager();
        for (String language: languageList){

            if (!language.equals(word.getLanguage())) {
                System.out.println(translate(fileManager.searchWord(word, language)));
            }
        }

    }

    public String translate(String definition){
        String[] lines = definition.split("\n");
        String line = lines[1];
        String[] parts = line.split(" ");
        if (parts[0].equals("1.")){
            return parts[1];
        }else {
            return parts[0];
        }
    }



}
