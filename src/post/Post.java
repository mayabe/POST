package post;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import mastopay.*;


/**
 * @author Ray
 *
 */
public class Post {
	
	private String customerName;
	private String dateTime;
	
	private String upc;
	private int quantity;
	private double unitPrice;
	private double extendedPrice;

	private double totalCost;
	private double amountTendered;
	private double amountReturned;
	
	private boolean valid; // valid or invalid upc code
	private Payment paymentType;
	private String paymentTypeString;	// String: Amount tendered and Payment type
	private String itemDescription;
	
	private Store store;
	
	private PostItem postItems[];
	private int currentIndexOfArray;
			
	public static final int MAX_ITEMS = 100;
	
//	public Post() {	
//		customerName = "Bob Lname";
//		dateTime = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss").format(Calendar.getInstance().getTime());
//		totalCost = 55.55;
//		amountTendered = 100.00;		//get payment amount here
//		amountReturned = amountTendered - totalCost;
//	}
	
	
	public Post() {
		
	}
	
	/**
	 * Constructor for the post
	 */
	public Post(Store store) {
		
		this.store = store;

		dateTime = "";
		
		customerName = name;
		
		upc = "";
		quantity = 0;
		unitPrice = 0.00;
		extendedPrice = 0.00;
		
		totalCost = 0.00;
		amountTendered = 0.00;
		amountReturned = 0.00;
		
		valid = false; 
		paymentType = new Payment();
		paymentTypeString = "";
		itemDescription = "";
		
		postItems = new PostItem[MAX_ITEMS];
		currentIndexOfArray = 0;
		
	}
	
	/**
	 * Checks if the UPC is valid or not
	 * @param cat
	 * @return true is valid UPC
	 */
	public boolean validUPC(String upc) {
		valid = store.verifyUPC(upc);
		
		if(valid == false)  {	// invalid
			System.out.println("Invalid UPC");
		}
		
		return valid;
	}
	
	/**
	 * Creates an item and adds it to postItems[], array of items
	 * @param upc
	 * @param quantity
	 */
	public void addItem(String upc, int quantity) {
		if(validUPC(upc) == true) {	
			PostItem item = new PostItem();
			item.setUPC(upc);
			
			item.setItemDescription(getItemDescription(upc));
			
			item.setQuantity(quantity);
			
			item.setUnitPrice(getUnitPrice(upc));
			
			postItems[currentIndexOfArray] = item;
			currentIndexOfArray++;
		}
		
	}
	
	/**
	 * Gets the Item Description
	 * @param ProdSpecs
	 * @return
	 */
	public String getItemDescription(String upc) {
		itemDescription = store.getProductDescription(upc);
		
		return itemDescription;
	}
	
	/**
	 * Gets the unit price of an item
	 * @param ProdSpecs
	 * @return
	 */
	public double getUnitPrice(String upc) {
		unitPrice = store.getPrice();
		
		return unitPrice;
	}
	
												// No longer need I think
												/**
												 * Set the quantity purchased
												 */
												//public void setQuantity() {
													
													// get quantity from customer?
													
												//}
	
	/**
	 * Sets customer name
	 */
	public void setCustomerName(String name) {
		customerName = name;
	}
												
	/**
	 * Sets the extended price (unit price * quantity)
	 */
	public void setExtendedPrice() {
		extendedPrice = unitPrice * quantity;
	}
	
	/**
	 * Sets the total cost
	 */
	public void setTotal() {
		/////////totalCost = totalCost + extendedPrice;
		
		// sum up the extended price of all objects in the array
		for(int i = 0; i < currentIndexOfArray; i++ ) {
			totalCost = totalCost + postItems[i].getExtendedPrice();
		}
	}
	
	/**
	 * Calculates the amount returned
	 */
	public void setAmountReturned() {
		amountReturned = amountTendered - totalCost;
	}
	
	/**
	 * Gets the extended price
	 * @return
	 */
	public double getExtendedPrice() {
		return extendedPrice;
	}
	
	/**
	 * Gets the total cost
	 * @return
	 */
	public double getTotal() {
		return totalCost;
	}
	
	/**
	 * Gets the amount returned
	 * @return
	 */
	public double getAmountReturned() {
		return amountReturned;
	}
	
	/**
	 * Gets the payment type from Pay class and
	 * Sets paymentType to that type paymentTypeString
	 * @param pay
	 */
	public void setPaymentMethod(Payment pay) {
		paymentType.setPayType(pay.getPayType());
		
		// Payment type is CASH
		if(paymentType == paymentType.PayType.CASH) {
			paymentType.setAmountTotal(pay.getAmountTotal());
			amountTendered = paymentType.getAmountTotal();
			paymentTypeString = "Amount Tendered: " + amountTendered + " Paid by Cash";
		}
		//Payment type is CHECK
		else if(paymentType == paymentType.PayType.CHECK) {
			paymentType.setAmountTotal(pay.getAmountTotal());
			amountTendered = paymentType.getAmountTotal();
			paymentTypeString = "Amount Tendered: " + amountTendered + " Paid by Check";
		}
		// Payment type is CREDIT
		else {
			paymentType.setAmountTotal(totalCost);
			amountTendered = paymentType.getAmountTotal();
			paymentType.setCardNumber(pay.getCardNumber());
			paymentTypeString = "Amount Tendered: " + amountTendered + " Paid by Credit Card " + paymentType.getCardNumber();
		}
	}
	
	
	/**
	 * Prints out the invoice
	 */
	public void printInvoice() {
		
		System.out.println("<< Store Name Goes Here >>\n");
		dateTime = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(customerName + "     " + dateTime);
		
		//List items, price, quantity, etc here
		for(int i = 0; i < currentIndexOfArray; i++) {
			System.out.println(postItems[i].getItemDescription() + "   " + postItems[i].getQuantity() + "   " + postItems[i].getUnitPrice() + "   " + postItems[i].getExtendedPrice());
		}
		
		System.out.println("------");
		
		// Calculates total cost
		setTotal();
		System.out.println("Total $" + getTotal());
		
		// Amount tendered and Payment type
		System.out.println(paymentTypeString);
		
		// Calculates amount returned
		setAmountReturned();
		System.out.println("Amount Returned: $" + getAmountReturned() + "\n");
		
	}
	
	/**
	 * clears everything at the end of a transaction
	 */
	public void endTransaction() {
		customerName = "";
		dateTime = "";

		upc = "";
		quantity = 0;
		unitPrice = 0.00;
		extendedPrice = 0.00;

		totalCost = 0.00;
		amountTendered = 0.00;
		amountReturned = 0.00;

		valid = false; 
		paymentType = null;
		paymentTypeString = "";
		itemDescription = "";
		
		// Clears the array of all Items
		for(int i = 0; i < currentIndexOfArray; i++) {
			postItems[i] = null;
		}
		
		// Resets the index to 0 for the next transaction
		currentIndexOfArray = 0;
		
	}
	

}
