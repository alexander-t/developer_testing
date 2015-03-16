package algorithm;

import algorithm.supplier.RandomString;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class CaesarCipherTest {

    @Theory
    public void caesarCipherRoundTrip(@RandomString(maxLength = 128) String plainText,
                                      @TestedOn(ints = {0, 1, 2, 10, 26, 27, 1000}) int offset) {
        System.err.println(plainText);
        assertEquals(plainText, CaesarCipher.decode(CaesarCipher.encode(plainText, offset), offset));
    }
}
