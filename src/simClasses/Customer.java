
package simClasses;

/**
 * Customer class simulates an actual customer performing a transaction using 
 * Post 
 * @author Maya Gautschi
 */
public class Customer {
    
    private String name;
    private Transaction transaction;
    private TransactionReader tReader;
    
    public Customer(){
        name = "";
        transaction = new Transaction();
        tReader = null;
    }
    
    /**
     * Initializes with the next transaction in transaction file, or default if 
     * file is empty, or eof has been reached
     * @param transactionFile 
     */
    public Customer(String transactionFile){
        tReader = new TransactionReader("transaction.txt");
        transaction = tReader.getNextTransaction();
        name = transaction.getName();
    }
    
    /**
     * Gets the next transaction from a transaction file
     * @param transactionFile
     * @return true if successful, false if eof has been reached or empty file
     */
    public boolean getTransaction(String transactionFile){
        transaction = tReader.getNextTransaction();
        name = transaction.getName();
        return transaction.getPaymentType() != null;
    }
    
    /**
     * Simulates a customer performing a transaction 
     * @return true if transaction was successfully performed
     */
    public boolean performTransaction(){
        // use post methods here to perform a transaction
        return true;
    }
    
    public void leaveStore() {
        tReader.close();
    }
    
}
