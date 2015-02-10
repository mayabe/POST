/*
 * Manager will open the store, set up Post, put together product catalog
 *
 */
package mastopay;
import post.*;
import simClasses.*;
/**
 *
 * @author Maya
 */
public class Manager {
    
    public static void main(String[] args) {
        Store testStore = new Store();
        testStore.initCatalog("products.txt");
        Post post = new Post();
        if(testStore.openStore()){
            Customer customer = new Customer("transaction.txt");
            customer.performTransaction(post);
            while(customer.getTransaction()){
                customer.performTransaction(post);
            }
            customer.leaveStore();
        }
        testStore.closeStore();;
    }
    
}
