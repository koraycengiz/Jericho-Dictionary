import java.util.Locale;

public class Dictionary {

    final String[] languageList = {"eng","deu","tur","fra","ell","ita","swe"};


    public void getTranslations(Word word){
        FileManager fileManager = new FileManager();
        word.setText(word.getText().toLowerCase());
        for (String language: languageList){

            if (!language.equals(word.getLanguage())) {
                System.out.println(translate(fileManager.searchWord(word, language)));
            }
        }

    }

    public static String translate(String definition){
        String[] lines = definition.split("\n");
        String line = lines[1];
        String[] parts = line.split(" ");
        if (parts[0].equals("1.")){
            return parts[1].replaceAll(",","");
        }else {
            return parts[0].replaceAll(",","");
        }
    }



}
