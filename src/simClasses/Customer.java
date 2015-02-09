
package simClasses;

import post.Post;

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
     * @return true if successful, false if eof has been reached or empty file
     */
    public boolean getTransaction(){
        transaction = tReader.getNextTransaction();
        name = transaction.getName();
        return transaction.getPaymentType() != null;
    }
    
    /**
     * Simulates a customer performing a transaction
     *
     * @pre The customer must have a transaction prior to calling this method
     * @param post
     * @return true if transaction was successfully performed
     */
    public boolean performTransaction(Post post){
        if(transaction == null) {
            System.err.println("Error: (performTransaction) No transaction information.");
            return false;
        }
        // use post methods here to perform a transaction
        
        //post.setName(name);
        for (int i = 0; i < transaction.getNumItems(); i++) {
            String item = transaction.getItem(i).getUPC();
            int quantity = transaction.getItem(i).getQuantity();
            post.addItem(item, quantity);
        }
        post.setPaymentMethod(transaction.getPayment());
        post.printInvoice();
        post.endTransaction();
        return true;
    }
    
    public void leaveStore() {
        tReader.close();
    }
    
}
