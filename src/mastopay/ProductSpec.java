/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastopay;

/**
 *
 * @author Synonic
 */
public class ProductSpec {
     int productUPC = 0000;
     String productDescription = "";
     double productPrice = 0.0;
     
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
     
     public void setProductUPC() {
         productUPC = 1234;
     }
     
     public void setProductDescription() {
         productDescription = "";
     }
     
     public void setProductPrice() {
         productPrice = 0.0;
     }
     
}
