
package simClasses;
import mastopay.Payment;


/**
 * Holds the transaction information
 * @author Maya Gautschi
 */
public class Transaction {
    
    private String customerName;
    private TransactionItem transItems[];
    private int numTransItems;
    private Payment payment;
    
    public static final int MAX_ITEMS = 100;
    
    public Transaction() {
        customerName = "";
        numTransItems = 0;
        transItems = new TransactionItem[MAX_ITEMS];
        payment = new Payment();
    }
    
    public Transaction(String name, TransactionItem items[], int numItems, Payment pay) {
        customerName = name;
        
        if(numItems < MAX_ITEMS) {
            numTransItems = numItems;
        } else if(numItems < 0 ) {
            numTransItems = 0;
        } else {
            numTransItems = MAX_ITEMS;
        }
        
        transItems = new TransactionItem[MAX_ITEMS];
        for(int i = 0; i < numTransItems; i++) {
            transItems[i] = new TransactionItem(items[i]);
        }
        
        payment = new Payment(pay);
        
    }
    
    public boolean addItem(TransactionItem item) {
        if(MAX_ITEMS > (numTransItems + 1)) {
            transItems[numTransItems] = item;
            numTransItems++;
            return true;
        }
        System.err.print("Error: setItem() failed. Number of items exceeds "+ MAX_ITEMS + ". ");
        return false;
    }
    
    public String getName() {
        return customerName;
    }
    
    /**
     *
     * @param i
     * @return TransactionItem at index i, or an empty TransactionItem if i is
     * not a valid index
     */
    public TransactionItem getItem(int i) {
        if(isLegalIndex(i)) {
            return transItems[i];
        }
        System.err.print("Error: getItem() attempted to access illegal index " + i +". ");
        return new TransactionItem();
    }
    
    public int getNumItems() {
        return numTransItems;
    }
    
    public Payment getPayment() {
        Payment pay = new Payment(payment);
        return pay;
    }
    
    public double getPaymentAmount() {
        return payment.getAmountTotal();
    }
    
    public Payment.PayType getPaymentType() {
        return payment.getPayType();
    }
    
    public String getPaymentCard() {
        return payment.getCardNumber();
    }
    
    public void setName(String name) {
        customerName = name;
    }
    
    public boolean setItem(int index, TransactionItem item) {
        if(isLegalIndex(index)) {
            transItems[index] = item;
            return true;
        }
        System.err.print("Error: setItem() failed. Index out of bounds. ");
        return false;
    }
    
    public boolean setAllItems(TransactionItem items[], int numItems) {
        if(numItems < MAX_ITEMS) {
            numTransItems = numItems;
            return true;
        } else if(numItems < 0 ) {
            numTransItems = 0;
        } else {
            numTransItems = MAX_ITEMS;
        }
        return false;
    }
    
    public boolean setNumItems(int numItems) {
        if(numItems > MAX_ITEMS) {
            System.err.print("Error: setNumItems() failed. Value exceeds maximum. Maximum is " + MAX_ITEMS +".");
            return false;
        }
        numTransItems = numItems;
        return true;
    }
    
    public void setPaymentAmount(double amt) {
        payment.setAmountTotal(amt);
    }
    
    public void setPaymentType(Payment.PayType pType) {
        payment.setPayType(pType);
    }
    
    public void setPaymentCard(String card) {
        payment.setCardNumber(card);
    }
    
    public boolean isEmpty() {
        return numTransItems == 0;
    }
    
    public boolean isLegalIndex(int index) {
        return index < numTransItems;
    }
}
