
import java.io.File;
import java.util.ArrayList;


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
                        File file = new File("dictionaries\\"+language1 + "-" + language2 + ".tei");
                        if (file.exists()) {
                            String translation = fileManager.searchWord(word, language1, language2);

                            if (!translation.equals("")) {
                                translationList.add(getLanName(language2) + ":" + translation);
                                flag = true;
                            }


                        }else{
                            String engTranslation = fileManager.searchWord(word,language1,"eng");
                            String translation = fileManager.searchWord(engTranslation,"eng",language2);

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

    public void editWord(String oldWord,String newWord,String filePath){
        FileManager fileManager = new FileManager();
        String oldText = "<orth>"+oldWord+"</orth>";
        String newText = "<orth>"+newWord+"</orth>";
        fileManager.updateFile(oldText,newText,filePath);
    }

    public void editTranslation(String oldWord,String newWord,String filePath){
        FileManager fileManager = new FileManager();
        String oldText = "<quote>"+oldWord+"</quote>";
        String oldText2 = "<def>"+oldWord+"</def>";
        String newText = "<quote>"+newWord+"</quote>";
        fileManager.updateFile(oldText,newText,filePath);
        fileManager.updateFile(oldText2,newText,filePath);
    }






}
