package encryptdecrypt;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Cryptor cryptor;

        String mode = "enc";
        String alg = "shift";
        int key = 0;
        StringBuilder data = new StringBuilder();
        File in = null;
        File out = null;

        String changedData = null;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
                case "-data":
                    data = new StringBuilder(args[i + 1]);
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-in":
                    in = new File(args[i + 1]);
                    break;
                case "-out":
                    out = new File(args[i + 1]);
                    break;
            }
        }

        if (in != null && (data.length() == 0)) {
            try (FileReader reader = new FileReader(in)) {
                while (reader.ready()) {
                    data.append((char) (reader.read()));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error! File to read not found");
            } catch (IOException e) {
                System.out.println("Error! Can't read file");
            }
        }

        cryptor = CryptorFactory.getCipher(mode, alg, data.toString(), key);
        assert cryptor != null;
        changedData = cryptor.process();

        if (out != null) {
            try (FileWriter writer = new FileWriter(out)) {

                for (int i = 0; i < changedData.length(); i++) {
                    writer.write(changedData.charAt(i));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error! File to write not found");
            } catch (IOException e) {
                System.out.println("Error! Can't write file");
            }
        } else {
            System.out.println(changedData);
        }
    }
}