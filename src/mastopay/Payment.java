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

    public PayType getPayType() {
        return type;
    }
    
}
