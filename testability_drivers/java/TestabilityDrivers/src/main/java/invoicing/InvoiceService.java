package invoicing;

import domain.Invoice;
import domain.TransactionId;

public class InvoiceService {
    private static final int BATCH_SIZE = 10000;
    private int processedInvoices;

    private InvoiceRepository invoiceRepository;
    private TransactionIdGenerator transactionIdGenerator;
    private InvoiceQueue invoiceQueue;

    public void dispatchInvoice(Invoice invoice) {
        TransactionId transactionId = transactionIdGenerator.generateId();
        invoice.setTransactionId(transactionId);
        invoiceRepository.updateInvoice(invoice);
        invoiceQueue.enqueue(invoice);

        if (++processedInvoices == BATCH_SIZE) {
            invoiceRepository.archiveOldInvoices();
            invoiceQueue.ensureEmptied();
        }
    }
}
