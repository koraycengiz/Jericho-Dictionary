import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dictionary {

    final String[] languageList = {"eng", "deu", "tur", "fra", "ell", "swe", "ita"};


    public ArrayList<String> getTranslations(String word, String sourceLan)  {
        FileManager fileManager = new FileManager();
        word = word.toLowerCase();

        ArrayList<String > translationList = new ArrayList<>();
        for (String language : languageList) {

            if (!language.equals(sourceLan)) {
                File file = new File("dictionaries\\"+ sourceLan+"-"+ language+".tei");
                if (file.exists()) {
                    translationList.add(language + ": " + fileManager.searchWord(word, sourceLan, language));
                }else{
                    translationList.add(language + ": " + fileManager.searchWord(fileManager.searchWord(word, sourceLan, "eng"),"eng",language));
                }


            }
        }
        return translationList;

    }


}
