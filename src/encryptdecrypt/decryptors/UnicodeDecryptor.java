package encryptdecrypt.decryptors;

import encryptdecrypt.Cryptor;

public class UnicodeDecryptor extends Cryptor {

    public UnicodeDecryptor(String data, int key) {
        super(data, key);
    }

    @Override
    protected String process() {
        char[] cipherData = data.toCharArray();

        for (int i = 0; i < cipherData.length; i++) {
            cipherData[i] -= key;
        }

        return String.valueOf(cipherData);
    }
}
