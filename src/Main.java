import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String sentence = scanner.nextLine();
        int key = scanner.nextInt();

        switch (command) {
            case "enc":
                System.out.println(encryptMessage(sentence, key));
                break;
            case "dec":
                System.out.println(decryptMessage(sentence, key));
                break;
        }
    }

    public static String encryptMessage(String message, int key) {

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < message.length(); index++) {
            if (Character.isLowerCase(message.charAt(index))) {
                char ch = (char) (((int) message.charAt(index) +
                        key));
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(index) +
                        key));
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decryptMessage(String message, int key) {

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < message.length(); index++) {
            if (Character.isLowerCase(message.charAt(index))) {
                char ch = (char) (((int) message.charAt(index) -
                        key));
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(index) -
                        key));
                result.append(ch);
            }
        }
        return result.toString();
    }
}