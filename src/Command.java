public class Command {

    protected String userChoice;
    private int shiftKey;
    private String message;
    private StringBuilder result = new StringBuilder();

    public void setUserChoice(String command) {
        this.userChoice = command;
    }

    public void setShiftNumber(String shiftNumber) {
        shiftKey = Integer.parseInt(shiftNumber);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String encryptMessage() {

        for (int index = 0; index < message.length(); index++) {
            if (Character.isLowerCase(message.charAt(index))) {
                char ch = (char) (((int) message.charAt(index) + shiftKey));
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(index) + shiftKey));
                result.append(ch);
            }
        }
        return result.toString();
    }

    public String decryptMessage() {

        for (int index = 0; index < message.length(); index++) {
            if (Character.isLowerCase(message.charAt(index))) {
                char ch = (char) (((int) message.charAt(index) - shiftKey));
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(index) - shiftKey));
                result.append(ch);
            }
        }
        return result.toString();
    }

    public void printResult() {
        System.out.println(result);
    }
}
