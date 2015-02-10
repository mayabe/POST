/*
 * Store will hold information including the product catalog
 */
package mastopay;

/**
 *
 * @author Maya
 */
public class Store {
    
    private String storeName;
    private Catalog catalog;
    private boolean open;
    
    /**
     *
     */
    public Store() {
        storeName = "";
        catalog = null;
        open = false;
    }
    
    public Store(String name, String productFile){
        storeName = name;
        catalog = new Catalog();//(String productFile);
        open = false;
    }
    
    /**
     *
     * @param newStoreName
     */
    public void setStoreName(String newStoreName) {
        storeName = newStoreName;
    }
    
    /**
     *
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }
    
    public ProductSpec getProduct(String upc) {
        return catalog.getProduct(upc);
    }
    
    public void initCatalog(String productFile) {
        //catalog = new Catalog(String productFile);
    }
    
    public boolean validUPC(String upc) {
        return catalog.verifyUPC(upc) > -1;
    }
    
    public boolean openStore() {
        if(catalog != null) {
            open = true;
        }
        return open;
    }
    
    public void closeStore() {
        catalog = null;
        open = true;
    }
    
    public boolean isOpen(){
        return open;
    }
}
