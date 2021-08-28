package encryptdecrypt.decryptors;

import encryptdecrypt.Cryptor;

public class ShiftDecryptor extends Cryptor {

    public ShiftDecryptor(String str, int key) {
        super(str, key);
    }

    @Override
    protected String process() {
        char[] cipherData = data.toCharArray();

        for (int i = 0; i < cipherData.length; i++) {
            if (cipherData[i] >= 'a' && cipherData[i] <= 'z') {
                if (cipherData[i] - key < 'a') {
                    cipherData[i] = (char) ('z' - 'a' % (cipherData[i] - key) + 1);
                } else {
                    cipherData[i] -= key;
                }
            }
        }

        return String.valueOf(cipherData);
    }
}
