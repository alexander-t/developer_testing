package algorithm;

// Stub class required by an example. The "cipher" doesn't even work.
public class MyFancyCipher {

    public static String encrypt(String plainText) {
      return plainText.replaceAll("a", "q");
    }

    public static String decrypt(String cipherText) {
        return cipherText.replaceAll("q", "a");
    }
}
