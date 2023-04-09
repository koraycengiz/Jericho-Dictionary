

public class Dictionary {

    final String[] languageList = {"eng", "deu", "tur", "fra", "ell", "swe", "ita"};


    public void getTranslations(Word word) {
        FileManager fileManager = new FileManager();
        word.setText(word.getText().toLowerCase());
        for (String language : languageList) {

            if (!language.equals(word.getLanguage())) {
                System.out.println(language + ": " + translate(fileManager.searchWord(word, language)));
            }
        }

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

        for (int i = 0; i<parts.length;i++) {
            flag = true;
            String[] punctiations = {"[", "]", ">", "<", "/","1","2","3","4","(",")"};

            for (String punctiation : punctiations) {
                if (parts[i].contains(punctiation)) {
                    flag = false;
                }
            }
            if (flag&&!parts[i].isEmpty()&&!retString.contains(",")) {
                retString = retString.concat(parts[i]+" ");

            }
        }
        return retString.trim().replaceAll(",","").replaceAll("!","");
    }

}
