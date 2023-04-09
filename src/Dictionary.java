import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    final String[] languageList = {"eng", "deu", "tur", "fra", "ell", "swe", "ita"};


    public ArrayList<String> getTranslations(Word word) {
        FileManager fileManager = new FileManager();
        word.setText(word.getText().toLowerCase());

        ArrayList<String > translationList = new ArrayList<>();
        for (String language : languageList) {

            if (!language.equals(word.getLanguage())) {
                translationList.add(language + ": " + translate(fileManager.searchWord(word, language)));
            }
        }
        return translationList;

    }

    public static String translate(String definition) {
        if (definition.isEmpty()){
            return "Translation not found";
        }
        String[] lines = definition.split("\n");

        String line = lines[1];
        if (line.isEmpty()){
            line = lines[2];
        }
        String[] parts = line.split(" ");
        boolean flag;
        String retString = "";
        int passChecker = -1;

        for (int i = 0; i<parts.length;i++) {

            flag = true;
            String[] punctiations = {"[", "]", ">", "<", "/","1","2","3","4","(",")"};

            for (String punctiation : punctiations) {
                if (parts[i].contains(punctiation)) {
                    flag = false;
                }
            }
            if (flag&&!parts[i].isEmpty()&&!retString.contains(",")&&(passChecker == i-1||parts[0].contains("."))){
                retString = retString.concat(parts[i]+" ");


                passChecker = i;
            }

        }
        return retString.trim().replaceAll(",","").replaceAll("!","").replaceAll("‐","");
    }

}
