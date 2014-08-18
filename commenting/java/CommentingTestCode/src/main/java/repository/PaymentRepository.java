package repository;

import domain.Payment;

public interface PaymentRepository {
    Payment getPayment(long referenceNumber);
}
