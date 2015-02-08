/*
 * Store will hold information including the product catalog
 */
package mastopay;

/**
 *
 * @author tenzinwangchuk
 */
public class Store {
    
    private String storeName;
    
    // private Catalog catalog;
    
    // private Post post;
    
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
   
    
       
    
}
