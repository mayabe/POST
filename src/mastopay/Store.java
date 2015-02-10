/*
 * Store will hold information including the product catalog
 */
package mastopay;


import post;
import Catalog;


/**
 *
 * @author tenzinwangchuk
 */
public class Store {
    
    private String storeName;
   
    /**
     *
     */
    public Store() { }
    
    /**
     *
     * @param newStoreName
     */
    public void setStoreName(String newStoreName) {
        this.storeName = newStoreName;
    }
    
    /**
     *
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }
   
    public void catalogInfo(Manager man) {
        man.initCatalog();
        
        }
        
    public void checkUPC(Post post, String upc) {
        post.validUPC(upc);
    }
    
    public void priceCheck(String itemUpc, Post post, ProductSpec[] productList)  {
        boolean checkUpc = post.validUPC(itemUpc);
        if(checkUpc) {
            for (ProductSpec productList1 : productList) {
                if (itemUpc == productList1.getProductUPC()) {
                    double price = productList1.getProductPrice();
                    System.out.println("Price is " +price);
                } else {
                    System.out.println("UPC not match");
                }
                {
                    System.out.println("UPC Invalid");
                }   }
        }
       
    
}
