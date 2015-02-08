/*
 * Payment hold information of the payment type
 */
package mastopay;

/**
 *
 * @author tenzinwangchuk
 */
public class Payment {
    
    /**
     *
     */
    public enum PayType {
        
        /**
         *
         */
        CASH,
        
        /**
         *
         */
        CREDIT,
        
        /**
         *
         */
        CHECK };
    
    private PayType type;
    private int amountTotal;
    
    /**
     *
     */
    public Payment() { }
    
    public Payment(int amtTotal, PayType pType) {
        amountTotal = amtTotal;
        type = pType;
    }
    
    /**
     *
     * @param total
     */
    public void setAmountTotal(int total) {
        this.amountTotal = total;
    }
    
    public void setPayType(PayType t) {
        type = t;
    }
    
    /**
     *
     * @return amountTotal
     */
    public int getAmountTotal() {
        return amountTotal;
    }
    
    /**
     *
     * @return type of payment
     */
    public PayType getPayType() {
        return type;
    }
    
}
