

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
        boolean flag = true;
        String retString = "";

        for (String part : parts) {
            flag = true;
            String[] punctiations = {".", "[", "]", ">", "<", "/"};

            for (String punctiation : punctiations) {
                if (part.contains(punctiation)) {
                    flag = false;
                }
            }
            if (flag&&!part.isEmpty()&&!retString.contains(",")) {
                retString = retString.concat(part+" ");
            }
        }
        return retString.trim().replaceAll(",","").replaceAll("!","");
    }

}
