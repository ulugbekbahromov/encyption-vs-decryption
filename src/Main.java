import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String option = "enc";
        String text = "";
        boolean isData = false;
        int key = 0;
        String fileToRead = "";
        boolean isIn = false;
        String fileToWrite = "";
        boolean isOut = false;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    option = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    isData = true;
                    break;
                case "-in":
                    fileToRead = args[i + 1];
                    isIn = true;
                    break;
                case "-out":
                    fileToWrite = args[i + 1];
                    isOut = true;
                    break;
            }
        }

        if (!isData && !isIn) {
            System.out.println("Error !!!");
        }

        if (!isData && !isIn) {
            File in = new File(fileToRead);
            try (Scanner file_s = new Scanner(in)) {
                text = file_s.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String response;
        if (option.equals("enc")) {
            response = Encoder.encode(text, key);
        } else {
            response = Decoder.decode(text, key);
        }
        if (isOut) {
            File out = new File(fileToWrite);
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(response);
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }

        if (!isOut) {
            System.out.println(response);
        }
    }
}