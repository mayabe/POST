import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	
	private boolean valid; // valid upc code
	private Payment paymentType;
	private String itemDescription;
	private Catalog cat;
	
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
		this.customerName = "";
		
	}
	
	/**
	 * Constructor for the post
	 */
	public Post(String name, Catalog cat) {
		dateTime = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss").format(Calendar.getInstance().getTime());
		customerName = name;
		this.cat = cat;
		
		postItems = new PostItem[MAX_ITEMS];
		currentIndexOfArray = 0;
	}
	
	/**
	 * Checks if the UPC is valid or not
	 * @param cat
	 * @return true is valid UPC
	 */
	public boolean validUPC(String upc) {
		valid = cat.verifyUPC(upc);
		
		if(valid == false)  {
			System.out.println("Invalid UPC");
		}
		
		return valid;
	}
	
	public void addItem(String upc, int quantity) {
		if(validUPC(upc) == true) {
			PostItem item = new PostItem();
			item.setUPC(upc);
			item.setItemDescription(itemDescription);
			item.setQuantity(quantity);
			item.setUnitPrice(unitPrice);
			
			postItems[currentIndexOfArray] = item;
			currentIndexOfArray++;
		}
		
	}
	
	/**
	 * Gets the Item Description
	 * @param ProdSpecs
	 * @return
	 */
	public String getItemDescription(ProductSpec ProdSpecs) {
		itemDescription = ProdSpecs.getDescription(upc);
		
		return itemDescription;
	}
	
	/**
	 * Gets the unit price of an item
	 * @param ProdSpecs
	 * @return
	 */
	public double getUnitPrice(ProductSpec ProdSpecs) {
		unitPrice = ProdSpecs.getPrice(upc);
		
		return unitPrice;
	}
	
	/**
	 * Set the quantity purchased
	 */
	public void setQuantity() {
		
		// get quantity from customer?
		
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
	 * Gets the payment type from Pay class and
	 * Sets paymentType to that type
	 * @param pay
	 */
	public void setPaymentMethod(Payment pay) {
		paymentType = pay.getPayType();
	}
	
	
	/**
	 * Prints out the invoice
	 */
	public void printInvoice() {
		
		System.out.println("<< Store Name Goes Here >>\n");
		System.out.println(customerName + "     " + dateTime);
		
		//List items, price, quantity, etc here
		
		System.out.println("------");
		System.out.println("Total $" + totalCost);
		System.out.println("Amount Tendered: $" + amountTendered + "	Paid by --- << GET PAYMENT TYPE HERE >>");
		System.out.println("Amount Returned: $" + amountReturned + "\n");
		
	}
	
	/**
	 * clears everything at the end of a transaction
	 */
	public void endTransaction() {
		
	}
	

}
