package util.v2;

import java.io.File;

public class PaymentFile {
    private File file;

    public PaymentFile(File file) {
        this.file = file;
    }

    public boolean hasMoreLines() {

        // This would check for EOF
        return false;
    }

    public String readLine() {
        return "";
    }
}
