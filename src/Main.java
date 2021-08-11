public class Main {
    public static void main(String[] args) {

        Command message = new Command();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    message.setUserChoice(args[i + 1]);
                    break;
                case "-key":
                    message.setShiftNumber(args[i + 1]);
                    break;
                case "-data":
                    message.setMessage(args[i + 1]);
                    break;
            }
        }

        switch (message.userChoice) {
            case "enc":
                message.encryptMessage();
                break;
            case "dec":
                message.decryptMessage();
                break;
        }

        message.printResult();
    }
}