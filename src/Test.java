import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        ArrayList<ArrayList<String>> allTrans = dictionary.getTranslations("pasta");

        for (ArrayList<String> translationList: allTrans ){
            for (String translation: translationList){
                System.out.println(translation);
            }
            System.out.println("----------------------------------------------");
        }




    }
}
