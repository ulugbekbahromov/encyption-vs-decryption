import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String choice = "enc";
        String text = "";
        boolean isData = false;
        int key = 0;
        String file_to_read = "";
        boolean isIn = false;
        String file_to_write = "";
        boolean isOut = false;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    choice = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    isData = true;
                    break;
                case "-in":
                    file_to_read = args[i + 1];
                    isIn = true;
                    break;
                case "-out":
                    file_to_write = args[i + 1];
                    isOut = true;
                    break;
            }
        }

        if (!isData && !isIn) {
            System.out.print("Error");
        }

        if (!isData && isIn) {
            File in = new File(file_to_read);
            try (Scanner file_s = new Scanner(in)) {
                text = file_s.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String res;
        if (choice.equals("enc")) {
            res = Encoder.encode(text, key);
        } else {
            res = Decoder.decode(text, key);
        }
        if (isOut) {
            File out = new File(file_to_write);
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(res);
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
        if (!isOut) {
            System.out.println(res);
        }

    }
}