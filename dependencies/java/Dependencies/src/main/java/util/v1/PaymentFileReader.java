package util.v1;

import domain.Payment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PaymentFileReader {

    public List<Payment> readPaymentFile(String filename)
            throws IOException {

        File paymentFile = new File(filename);
        BufferedReader reader
                = new BufferedReader(
                new FileReader(paymentFile));

        String line;
        while ((line = reader.readLine()) != null) {
            // Logic for parsing the file goes here...
        }

        // Fake the result
        return Arrays.asList(new Payment());
    }
}
