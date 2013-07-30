package util.v2;

import domain.Payment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PaymentFileReader {

    public List<Payment> readPaymentFile(PaymentFile paymentFile)
            throws IOException {

        while (paymentFile.hasMoreLines()) {

            String line = paymentFile.readLine();
            // Logic for parsing the file goes here...
        }

        // Fake the result
        return Arrays.asList(new Payment());
    }
}
