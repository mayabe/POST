package mastopay;

/**
 *
 * @author Synonic
 */
public class ProductSpec {
     private int productUPC = 0000;
     private String productDescription = "";
     private double productPrice = 0.0;
     
     //Default Constructor
     public ProductSpec() {}
     
     //Main Constructor for ProductSpec
     public ProductSpec(int productUPC, String productDescription, double productPrice) {
         this.productUPC = productUPC;
         this.productDescription = productDescription;
         this.productPrice = productPrice;
     }
     
     public int getProductUPC() {
         return productUPC;
     }
     
     public String getProductDescription() {
         return productDescription;
     }
     
     public double getProductPrice() {
         return productPrice;
     }
     
     public void setProductUPC(int productUPC) {
         this.productUPC = productUPC;
     }
     
     public void setProductDescription(String productDescription) {
         this.productDescription = productDescription;
     }
     
     public void setProductPrice(double productPrice) {
         this.productPrice = productPrice;
     }
     
     //Main method for testing individual file       **REMOVABLE**
     public static void main(String []args) {
         ProductSpec item1 = new ProductSpec(1234, "Hello World", 25);
         System.out.println(item1.getProductPrice());
         System.out.println(item1.getProductDescription());
         item1.setProductDescription("I wrote a new Description");
         System.out.println(item1.getProductDescription());
     }//end main
}
