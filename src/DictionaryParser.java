public class DictionaryParser {

    final static String b64_list = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String b64Encode(int val) {

        String [] b64List = b64_list.split("");
        int startFound = 0;
        String retValue = "";
        for (int i = 5; i >= 0; i--) {
            int thispart = (val >> (6 * i)) & ((2 << 5) - 1);
            if (startFound == 0 && thispart == 0) {
                continue;
            }
            startFound = 1;
            retValue += b64List[thispart];
        }
        if (retValue.length() > 0) {
            return retValue;
        } else {
            return b64List[0];
        }
    }

    public static long b64Decode(String str) {


        if (str.isEmpty()) {
            return 0;
        }
        long retValue = 0;
        int shiftValue = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int val = b64_list.indexOf(str.charAt(i));
            retValue |= (long) val << shiftValue;
            shiftValue += 6;
        }
        return retValue;
    }
}
