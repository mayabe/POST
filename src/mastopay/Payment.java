/*
 * Payment hold information of the payment type
 */
package mastopay;

import java.util.regex.Pattern;

/**
 *
 * @author tenzinwangchuk
 */
public class Payment {
    
    /**
     *
     */
    public enum PayType {
        CASH,
        CREDIT,
        CHECK
    };
    
    private PayType type;
    private double amountTotal;
    private String cardNumber;
    
    /**
     *
     */
    public Payment() {
        type = null;
        amountTotal = 0;
        cardNumber = "";
    }
    
    public Payment(PayType pType) {
        type = pType;
        amountTotal = 0;
        cardNumber = "";
    }
    
    public Payment(Payment pay) {
        amountTotal = pay.getAmountTotal();
        type = pay.getPayType();
    }
    
    /**
     *
     * @param total
     */
    public void setAmountTotal(double total) {
        this.amountTotal = total;
    }
    
    public void setPayType(PayType t) {
        type = t;
    }
    
    public void setCardNumber(String card) {
        if(type == PayType.CREDIT) {
            if(Pattern.matches("\\d{5}", card)) {
                cardNumber = card;
            } else {
                System.err.println("Error: setCardNumber() only accepts input of a string of 5 digits");
            }
        } else {
            System.err.println("Error: Cannot set cardNumber for payment of type " + type);
        }
        
    }
    
    /**
     *
     * @return amountTotal
     */
    public double getAmountTotal() {
        return amountTotal;
    }
    
    /**
     *
     * @return type of payment
     */
    public PayType getPayType() {
        return type;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
}
