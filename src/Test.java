import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        ArrayList<String> list = dictionary.findSynonyms("silence", "eng");
        if (list!=null) {
            for (String word : list) {
                System.out.println(word);
            }
        }





    }


}
