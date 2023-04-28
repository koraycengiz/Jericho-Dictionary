import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dictionary {

    final String[] languageList = {"eng", "deu", "tur", "fra", "ell", "swe", "ita"};


    public ArrayList<ArrayList<String>> getTranslations(String word)  {
        FileManager fileManager = new FileManager();


        ArrayList<ArrayList<String>> allTranslations = new ArrayList<>();

        for (String language1 : languageList) {
            ArrayList<String> translationList = new ArrayList<>();
            translationList.add(language1);
            boolean flag = false;
            for(String language2: languageList) {
                String filePath = "dictionaries\\" + language1 + "-" + language2 + ".tei";
                if (!language1.equals(language2)) {
                    String translation = fileManager.searchWord(word,language1,language2);
                    if (!translation.equals("")) {
                        translationList.add(language2+":"+translation);
                        flag = true;
                    }


                }
            }
            if (flag) {
                translationList.add("--------------------------");
                allTranslations.add(translationList);

            }

        }
        return allTranslations;

    }






}
