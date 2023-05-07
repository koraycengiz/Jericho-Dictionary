
import java.io.*;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;



public class Dictionary {

    final String[] languageList = {"eng", "deu", "tur", "fra", "ell", "swe", "ita"};
    final String[] languageNames = {"English","German","Turkish","French","Modern Greek","Swedish","Italian"};


    public ArrayList<ArrayList<String>> getTranslations(String word)  {
        FileManager fileManager = new FileManager();


        ArrayList<ArrayList<String>> allTranslations = new ArrayList<>();

        for (String language1 : languageList) {
            ArrayList<String> translationList = new ArrayList<>();
            translationList.add(getLanName(language1));
            boolean flag = false;
            for(String language2: languageList) {



                    if (!language1.equals(language2)) {
                        File file = new File("dictionaries\\"+language1 + "-" + language2 + ".txt");
                        if (file.exists()) {
                            String translation = fileManager.readFile(word, language1, language2);

                            if (!translation.equals("")) {
                                translationList.add(getLanName(language2) + ":" + translation);
                                flag = true;
                            }


                        }else{
                            String engTranslation = fileManager.readFile(word,language1,"eng");
                            String translation = fileManager.readFile(engTranslation,"eng",language2);

                            if (!translation.equals("")) {
                                translationList.add(getLanName(language2)  + ":" + translation);
                                flag = true;
                            }
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

    public String getLanName(String lanTag){
        for (int i = 0; i < languageList.length; i++) {
            if (languageList[i].equals(lanTag)){
                return languageNames[i];
            }
        }
        return "";
    }

    public ArrayList<String> findSynonyms(String word,String sourceLanTag){
        FileManager fileManager = new FileManager();
        ArrayList<String> synonyms = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for (String language:languageList){
            if (new File("dictionaries\\"+sourceLanTag + "-"+ language+".txt").exists()) {
                String translation = fileManager.readFile(word, sourceLanTag, language);
                 synonyms.addAll(fileManager.findTranslation(translation, sourceLanTag, language));
            }
        }

        synonyms.removeIf(str -> !set.add(str)||word.equalsIgnoreCase(str));
        return synonyms;
    }














}
