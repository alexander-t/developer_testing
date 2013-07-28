package util;

import domain.Payment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PaymentFileReaderV2 {

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
