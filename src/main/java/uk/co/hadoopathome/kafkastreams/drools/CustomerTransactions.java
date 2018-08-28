package uk.co.hadoopathome.kafkastreams.drools;

import java.util.Date;

public class CustomerTransactions {
    public CustomerTransactions(int customerId, int countOfTransactions, Date lastTransactionDate) {
        this.customerId = customerId;
        this.countOfTransactions = countOfTransactions;
        this.lastTransactionDate = lastTransactionDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCountOfTransactions() {
        return countOfTransactions;
    }

    public void setCountOfTransactions(int countOfTransactions) {
        this.countOfTransactions = countOfTransactions;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(Date lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    private int customerId;
    private int countOfTransactions;
    private Date lastTransactionDate;

}
