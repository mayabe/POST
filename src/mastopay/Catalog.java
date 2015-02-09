package mastopay;

/**
 *
 * @author Synonic
 */
public class Catalog {
    final static int catalogSize = 30;
    private final static ProductSpec[] productList = new ProductSpec[catalogSize];
    
    //Default Constructor
    public Catalog() {}
    
    //Main Constructor for Catalog
    public Catalog(ProductSpec[] productList) {
        System.arraycopy(productList, 0, Catalog.productList, 0, productList.length);
    }
    
    //Edits Catalog by replacing item in specified position
    public static void editCatalog(int position, ProductSpec product) {
            productList[position] = product;
    }
    
    //Compares UPC and Returns position of Item in Catalog if matching
    public static int verifyUPC(ProductSpec product) {
        for(int i = 0; i < productList.length; i++) {
            if (product.getProductUPC() == productList[i].getProductUPC()) {
                return i; 
            }
        }
        return -1;
    }
    
    //Main method for testing individual file       **REMOVABLE**
    public static void main(String []args) {
        
        ProductSpec item1 = new ProductSpec(4322, "My Item", 67);
        for(int i = 0; i < productList.length; i++) {
            productList[i] = item1;
        }
        
        ProductSpec item2 = new ProductSpec(6531, "My NEW Item", 42);
        
        //Adds item2 to the Catalog
        editCatalog(2, item2);
        
        //item2 is in position 2 of the Catalog
        System.out.println("productList[2]");
        System.out.println(productList[2].getProductUPC());
        System.out.println(productList[2].getProductDescription());
        System.out.println(productList[2].getProductPrice());
        int matchUPC = 0;
        
        //Checks to see if item2 exists in Catalog
        if((matchUPC = verifyUPC(item2)) != -1) {
            System.out.println("Product UPC Matches Item number: " + matchUPC);
        } else {
            System.out.println("Invalid UPC");
        }
    }//end main
}
