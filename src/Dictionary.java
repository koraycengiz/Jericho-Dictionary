
public class Dictionary {

    final String[] languageList = {"eng","deu","tur","fra","ell","ita","swe"};


    public void getTranslations(Word word){
        FileManager fileManager = new FileManager();
        word.setText(word.getText().toLowerCase());
        for (String language: languageList){

            if (!language.equals(word.getLanguage())) {
                System.out.println(language+": "+fileManager.searchWord(word, language)+"\n");
            }
        }

    }

    public static String translate(String definition){

        String[] lines = definition.split("\n");
        if (definition.isEmpty()|| lines.length == 1){
            return "Translation not found";
        }
        String line = lines[1];
        String[] parts = line.split(" ");
        boolean flag = true;
       for (String part: parts){
           String[] punctiations = {".","[","]",">","<","/","\\"};

           for (String punctiation:punctiations){
               if (part.contains(punctiation)){
                   flag = false;
               }
           }
           if (flag){
               return part;
           }
       }


       return "";
    }



}
