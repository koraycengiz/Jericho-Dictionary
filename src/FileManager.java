import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {



    public String searchWord(Word word,String targetLanTag){
        String retString = "";
        try {

            String path = String.format("dictionaries\\%s-%s\\%s-%s.",word.getLanguage(),targetLanTag,word.getLanguage(),targetLanTag);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path+"index"));
            String st;

            while ((st = bufferedReader.readLine()) != null){

                String[] parts = st.split("\t");

                if (word.getText().equals(parts[0])){
                    retString = searchDef(DictionaryParser.b64Decode(parts[1]),DictionaryParser.b64Decode(parts[2]),path);
                    break;
                }

            }
        }catch (IOException e){
           Word tempWord = new Word(Dictionary.translate(searchWord(word,"eng")),"eng");
            retString = searchWord(tempWord,targetLanTag);
        }
        return retString;

    }

    public String searchDef(long abBytePath, long textLength,String filePath){
        String text = "";


        try (RandomAccessFile file = new RandomAccessFile(filePath+"dict", "r")) {

            file.seek(abBytePath);


            byte[] textBytes = new byte[(int)textLength];
            file.read(textBytes);


            text = new String(textBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;


    }
}
