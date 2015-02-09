
package simClasses;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import mastopay.Payment;

/**
 * Reads transactions from transaction file
 * @author Maya Gautschi
 */
public class TransactionReader {
    private Scanner in;
    
    
    //public static final int MAX_LINES = 102;
    
    
    public TransactionReader(String transactionFile) {
        
        in = null;
        try {
            in = new Scanner(new FileInputStream(transactionFile));
        } catch(FileNotFoundException e) {
            System.err.println("Error: TransactionReader transaction file not found.");            System.err.println("Error: TransactionReader transaction file not found.");
            System.err.println("Exiting program.");
            System.exit(0);
        }
    }
    
    public void close() {
        in.close();
    }
    
    public boolean hasMoreTransactions() {
        return in.hasNext();
    }
    
    public Transaction getNextTransaction() {
        //int index = 0;
        double paymentAmount;
        Transaction nextTrans = new Transaction();
        
        if(in.hasNext()){
            nextTrans.setName(in.nextLine());
            String line = in.nextLine();
            while(!line.isEmpty()) {
                if (line.substring(0, 4).equalsIgnoreCase("CASH")) {
                    nextTrans.setPaymentType(Payment.PayType.CASH);
                    paymentAmount = Double.parseDouble(line.substring(6));
                    nextTrans.setPaymentAmount(paymentAmount);
                } else if(line.length() > 4 && line.substring(0, 5).equalsIgnoreCase("CHECK")) {
                    nextTrans.setPaymentType(Payment.PayType.CHECK);
                    paymentAmount = Double.parseDouble(line.substring(7));
                    nextTrans.setPaymentAmount(paymentAmount);
                } else if(line.length() > 4 && line.substring(0, 6).equalsIgnoreCase("CREDIT")) {
                    nextTrans.setPaymentType(Payment.PayType.CREDIT);
                    nextTrans.setPaymentCard(line.substring(7));
                } else {
                    TransactionItem temp = new TransactionItem();
                    if(line.length() == 4) {
                        temp.setUPC(line);
                        temp.setQuantity(1);
                        nextTrans.addItem(temp);
                    } else if(line.length() > 4) {
                        temp.setUPC(line.substring(0, 4));
                        temp.setQuantity(Integer.parseInt(line.substring(9)));
                        nextTrans.addItem(temp);
                    }
                    //index++;
                }
                if(in.hasNextLine()) {
                    line = in.nextLine();
                } else {
                    line = "";
                }
            }
        }
        
        return nextTrans;
    }
}
