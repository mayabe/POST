
package simClasses;

/**
 * Class for transaction items, stores UPC/quantity pairs. Values stored in the
 * UPC/quantity pairs are not guaranteed by methods of this class to be legal 
 * values.
 * @author Maya Gautschi
 */
public class TransactionItem {
    private String upc;
    private int quantity;
    
    public TransactionItem() {
        upc = "";
        quantity = 0;
    }
    
    public TransactionItem(String itemUPC, int itemQuantity) {
        upc = itemUPC;
        quantity = itemQuantity;
    }
    
    public TransactionItem(TransactionItem item) {
        upc = item.getUPC();
        quantity = item.getQuantity();
    }
    
    public String getUPC() { 
        return upc; 
    }
    
    public int getQuantity() { 
        return quantity; 
    }
    
    public void setUPC(String itemUPC) {
        upc = itemUPC;
    }
    
    public void setQuantity(int itemQuantity) {
        quantity = itemQuantity;
    }
}
