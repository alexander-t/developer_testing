package invoicing;

import domain.TransactionId;

public class TransactionIdGenerator {
    public TransactionId generateId() {
        return new TransactionId();
    }
}
