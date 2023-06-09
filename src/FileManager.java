import java.io.*;
import java.util.ArrayList;


public class FileManager {


    public String readFile(String word, String sourceLanTag, String targetLanTag) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionaries\\" + sourceLanTag + "-" + targetLanTag + ".txt"));


            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\t");

                if (words[0].equalsIgnoreCase(word)){
                    return words[1];
                }

            }

            reader.close();

        } catch (Exception e) {

        }
        return "";
    }


    public boolean updateHeadword(String oldWord,String newWord,String filePath){
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\t");
                if (oldWord.equalsIgnoreCase(words[0])) {
                    line = newWord + "\t"+ words[1];
                }
                bufferedWriter.write(line + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateTranslation(String oldWord,String newWord,String filePath){
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\t");
                if (oldWord.equalsIgnoreCase(words[1])) {
                    line =words[0]+"\t"+ newWord;
                }
                bufferedWriter.write(line + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addFile(String word, String translation, String filePath) {
        FileManager fileManager = new FileManager();


        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Dictionary file doesn't exist for the selected languages!");
            return false;
        }

        // Check if the word already exists in the dictionary
        if (!fileManager.readFile(word, filePath.substring(0,3), filePath.substring(4,7)).equals("")){
            System.out.println("The word already exists in the dictionary!");
            return false;
        }


        String newEntry = "\n"+word+"\t"+translation;
        try {


            FileWriter fileWriter = new FileWriter(filePath,true);
            fileWriter.write(newEntry);
            fileWriter.close();


        }catch (IOException e){
            return false;
        }

        System.out.println("Word added to the dictionary!");
        return true;
    }

    public ArrayList<String> findTranslation(String word, String sourceLanTag,String targetLanTag){
        ArrayList<String> translations = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionaries\\" + sourceLanTag + "-" + targetLanTag + ".txt"));


            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\t");
                if (words.length>=2) {
                    if (words[1].equalsIgnoreCase(word)) {
                        translations.add(words[0]);
                    }
                }

            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return translations;
    }






}
