public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String a = "<quote xml:lang=\"en\">apple</quote>";
        String quote = a.replaceAll("<.*?>", "").trim();
        System.out.println(quote);


    }
}
