package domain;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private String reference;
    private BigDecimal amount;
    private Date date;

    public Payment() {
    }

    public Payment(String reference, BigDecimal amount, Date date) {
        this.reference = reference;
        this.amount = amount;
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (!amount.equals(payment.amount)) return false;
        if (!date.equals(payment.date)) return false;
        if (!reference.equals(payment.reference)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reference.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "reference='" + reference + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
