package lt.vu.transactions;

import lombok.Getter;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.TransactionSynchronizationRegistry;
@Named
@ApplicationScoped

public class SecondComponent {

    @Resource
    private TransactionSynchronizationRegistry tx;
    @Getter
    private String transactionId2; // For storing the transaction ID

    @Transactional
    public void secondMethod() {
        System.out.println("SecondComponent's Transaction ID: " + tx.getTransactionKey());
        this.transactionId2 = "Transaction ID from Second: " + tx.getTransactionKey().toString();
    }
}
