import java.io.*;



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

                    String translation = line.replaceAll("<.*?>", "").trim();

                    if (word.equalsIgnoreCase(headword)) {
                        return translation;
                    }

                }


            }

            reader.close();

        } catch (Exception e) {

        }
        return "";
    }


    public void updateFile(String oldWord,String newWord,String filePath){
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(oldWord)) {
                    line = line.replace(oldWord, newWord);
                }
                bufferedWriter.write(line + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }





}
