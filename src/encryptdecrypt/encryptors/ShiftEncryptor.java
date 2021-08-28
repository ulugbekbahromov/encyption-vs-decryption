package encryptdecrypt.encryptors;

import encryptdecrypt.Cryptor;

public class ShiftEncryptor extends Cryptor {

    public ShiftEncryptor(String str, int key) {
        super(str, key);
    }

    @Override
    protected String process() {
        char[] cipherData = data.toCharArray();

        for (int i = 0; i < cipherData.length; i++) {
            if (cipherData[i] >= 'a' && cipherData[i] <= 'z') {
                if (cipherData[i] + key > 'z') {
                    cipherData[i] = (char) ('a' + (cipherData[i] + key) % 'z' - 1);
                } else {
                    cipherData[i] += key;
                }
            }
        }

        return String.valueOf(cipherData);
    }
}
