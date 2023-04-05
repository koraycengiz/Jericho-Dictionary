import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {




    public String searchWord(String word){
        String retString = "";
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("dictionaries\\eng-deu\\eng-deu.index"));
            String st;

            while ((st = bufferedReader.readLine()) != null){

                String[] parts = st.split("\t");

                if (word.equals(parts[0])){
                    retString = searchDef(DictionaryParser.b64Decode(parts[1]),DictionaryParser.b64Decode(parts[2]));
                    break;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return retString;

    }
    public String searchDef(long abBytePath, long textLength){
        String filePath = "dictionaries\\eng-deu\\eng-deu.dict";
        String text = "";


        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {

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
