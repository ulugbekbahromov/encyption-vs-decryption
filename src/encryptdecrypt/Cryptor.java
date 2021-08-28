package encryptdecrypt;

public abstract class Cryptor {
    protected String data;
    protected int key;

    public Cryptor(String str, int key) {
        this.data = str;
        this.key = key;
    }

    protected abstract String process();
}
