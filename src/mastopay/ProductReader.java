/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastopay;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Synonic
 */
public class ProductReader {
    ProductSpec nextProduct;
    FileReader in = null;
    
    ProductReader(String productFile) throws IOException{
        
    }
    boolean hasMoreProducts() {
        return true;
    }
    
    ProductSpec getNextProduct() {
        return nextProduct;
    }
}
