public class Main {
    public static void main(String[] args) {
        System.out.println(encryptMessage("we found a treasure!"));
    }

    public static String encryptMessage(String str) {
        final int MAX_VALUE = 123;
        final int MIN_VALUE = 96;

        StringBuilder originalMessage = new StringBuilder(str.toLowerCase());
        StringBuilder encodedMessageStringBuilder = new StringBuilder();
        String encodedMessage;

        int asciiValue;
        int displacement;

        for (int charIndex = 0; charIndex < originalMessage.length(); charIndex++) {
            asciiValue = originalMessage.charAt(charIndex);
            displacement = MAX_VALUE - Math.abs(MIN_VALUE - asciiValue);

            if (asciiValue <= MIN_VALUE || asciiValue >= MAX_VALUE) {
                encodedMessageStringBuilder.append(originalMessage.charAt(charIndex));
            } else {
                encodedMessageStringBuilder.append((char) displacement);
            }
        }

        encodedMessage = encodedMessageStringBuilder.toString();

        return encodedMessage;
    }
}

