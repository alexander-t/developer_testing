package algorithm;

import net.java.quickcheck.Generator;
import org.junit.Test;

import static net.java.quickcheck.generator.PrimitiveGenerators.*;
import static org.junit.Assert.assertEquals;

public class MyFancyCipherTest {
    @Test
    public void encryptionRoundTrip() {
        Generator<String> plainTextGenerator
                = strings(integers(1, 128), characters());
        for (int i = 0; i < 100; i++) {
            String plainText = plainTextGenerator.next();
            assertEquals(plainText, MyFancyCipher
                    .decrypt(MyFancyCipher.encrypt(plainText)));
        }
    }

}


