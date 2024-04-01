package lt.vu.transactions;

import lombok.Getter;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.TransactionSynchronizationRegistry;
@Named
@RequestScoped
public class FirstComponent {

    @Inject
    private SecondComponent secondComponent;

    @Getter
    private String transactionId1; // For storing the transaction ID

    @Resource
    private TransactionSynchronizationRegistry tx;

    @Transactional
    public void firstMethod() { // Changed return type to void
        secondComponent.secondMethod(); // Your business logic call
        this.transactionId1 = "Transaction ID from FirstComponent: " + tx.getTransactionKey().toString();
    }
}
