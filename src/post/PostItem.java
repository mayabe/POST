
public class PostItem {

	private String upc;
	private String itemDescription;
	private int quantity;
	private double unitPrice;
	private double extendedPrice;
	
	public PostItem() {
		this.upc = "";
		this.itemDescription = "";
		this.quantity = 0;
	}
	
	public PostItem(String upc, int quantity) {
		this.upc = upc;
		this.quantity = quantity;
	}

	public void setUPC(String upc) {
		this.upc = upc;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getUPC() {
		return upc;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
	public double getExtendedPrice() {
		extendedPrice = unitPrice * quantity;
		
		return extendedPrice;
	}
	
}
