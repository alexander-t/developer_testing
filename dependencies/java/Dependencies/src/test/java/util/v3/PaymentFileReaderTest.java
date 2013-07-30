package util.v3;

import domain.Payment;
import org.junit.Test;
import util.v3.PaymentFileReaderV3;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentFileReaderTest {

    @Test
    public void correctPaymentIsParsed()
            throws Exception {
        String line = "912438784;1000.00;20130102\n";

        List<Payment> payments
                = new PaymentFileReaderV3()
                .readFileContents(
                        new ByteArrayInputStream(line.getBytes()));

        Calendar cal = Calendar.getInstance();
        cal.set(2013, 1, 2);
        Payment expectedPayment = new Payment("912438784",
                new BigDecimal(1000), cal.getTime());
        assertEquals(expectedPayment, payments.get(0));
    }
}
