import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        int key = scanner.nextInt();

        System.out.println(encryptMessage(sentence, key));
    }

    public static String encryptMessage(String message, int key) {
        final int MAX_VALUE = 123;
        final int MIN_VALUE = 96;
        final int alphabetLength = 26;

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < message.length(); index++) {
            if (message.charAt(index) == ' ') {
                result.append(' ');
            } else if (Character.isLowerCase(message.charAt(index))) {
                char ch = (char) (((int) message.charAt(index) +
                        key - MIN_VALUE) % alphabetLength + MIN_VALUE);
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(index) +
                        key - MAX_VALUE) % alphabetLength + MAX_VALUE);
                result.append(ch);
            }
        }

        return result.toString();
    }
}