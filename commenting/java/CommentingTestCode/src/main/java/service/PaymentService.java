package service;

import domain.Payment;
import repository.PaymentRepository;

public class PaymentService {
    private PaymentRepository paymentRepository;

    public String checksum(Payment payment) {
        return null;
    }

    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment findPaymentByReferenceNumber(long referenceNumberWithChecksum) {
        return null;
    }
}
