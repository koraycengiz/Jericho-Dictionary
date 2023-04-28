import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {



    public String searchWord(String word,String sourceLanTag, String targetLanTag) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionaries\\" + sourceLanTag + "-" + targetLanTag + ".tei"));

            String headword = "";
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.contains("</orth>")) {

                    headword = line.replaceAll("<.*?>", "").trim();

                    while (!(line.contains("</quote>")||line.contains("</def>"))&&reader.ready()) {
                        line = reader.readLine();

                    }

                    String quote = line.replaceAll("<.*?>", "").trim();

                    if (word.equalsIgnoreCase(headword)) {
                        return quote;
                    }

                }


            }

            reader.close();

        } catch (Exception e) {

        }
        return "";
    }



}
