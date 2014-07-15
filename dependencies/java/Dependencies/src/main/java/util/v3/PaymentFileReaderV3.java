package util.v3;

import domain.Payment;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PaymentFileReaderV3 {

    private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    public List<Payment> readPaymentFile(String filename)
            throws IOException {
        return readFileContents(new FileInputStream(filename));
    }

    List<Payment> readFileContents(InputStream inputStream)
            throws IOException {
        List<Payment> parsedPayments
                = new ArrayList<Payment>();
        BufferedReader reader
                = new BufferedReader(
                new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            parsedPayments.add(new Payment(
                    parseReference(values[0]),
                    parseAmount(values[1]),
                    parseDate(values[2])));
        }
        return parsedPayments;
    }

    private Date parseDate(String d) {
        try {
            return df.parse(d);
        } catch (ParseException e) {

            // Just to get rid of a checked exception in sample code
            throw new IllegalArgumentException(e);
        }
    }

    private String parseReference(String r) {
        return r;
    }

    private BigDecimal parseAmount(String a) {
        return new BigDecimal(a);
    }
}
