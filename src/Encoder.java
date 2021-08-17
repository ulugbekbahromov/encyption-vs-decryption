public class Encoder {
    public static String encode(String text, int key) {
        StringBuilder x = new StringBuilder(text);
        for (int i = 0; i < x.length(); ++i) {
            x.setCharAt(i, (char) (x.charAt(i) + key));
        }
        return x.toString();
    }
}