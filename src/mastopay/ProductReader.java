package mastopay;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Synonic
 */
public class ProductReader {

    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    ProductSpec nextProduct = new ProductSpec();
    int productUPC = 0000;
    String productDescription = "";
    double productPrice = 0.0;
    int readLine = 0;

    ProductReader(String productFile) throws IOException {

        int bufferSizeUPC = 4;
        int bufferSizeDescription = 20;
        int bufferSizePrice = 7;

        // creates buffer
        char[] bufferUPC = new char[bufferSizeUPC];
        char[] bufferDescription = new char[bufferSizeDescription];
        char[] bufferPrice = new char[bufferSizePrice];

        try {
            // open input stream test.txt for reading purpose.
            is = new FileInputStream(productFile);
            // create new input stream reader
            isr = new InputStreamReader(is);
            // create new buffered reader
            br = new BufferedReader(isr);

            //Scans each character and saves UPC, Description, and Price to variables
            while (hasMoreProducts()) {
                
                /* 
                 *  UPC
                 *  reads characters to bufferUPC, offset 0, len 4
                 */
                br.read(bufferUPC, 0, bufferSizeUPC);
                String b = new String(bufferUPC);
                productUPC = Integer.parseInt(b);
                System.out.print(productUPC);
                br.skip(5);
                
                /*
                 *  DESCRIPTION
                 *  reads characters to bufferDescription, offset 0, len 20
                 */
                br.read(bufferDescription, 0, bufferSizeDescription);
                b = new String(bufferDescription);
                productDescription = b.replaceAll("\t", "");
                System.out.print("\t" + productDescription);
                br.skip(5);
                
                /*
                 *  PRICE
                 *  reads characters to bufferPrice, offset 0, len 7
                 */
                br.read(bufferPrice, 0, bufferSizePrice);
                b = new String(bufferPrice);
                productPrice = Double.parseDouble(b.replaceAll("\t", ""));
                System.out.println("\t" + productPrice);


                /*
                 * Not sure about this, but adds the new fields 
                 * to new ProductSpec Object called nextProduct
                 */
                nextProduct.setProductUPC(productUPC);
                nextProduct.setProductDescription(productDescription);
                nextProduct.setProductPrice(productPrice);

            }//end while

        } catch (Exception e) {
            System.out.println("\n**File Format Incorrect**");
            System.out.println("Please use:"
                    + "\nUPC(4) Space(5) Description(20) Space(5) Price(7)"
                    + "\n(x) is the number of character alloted"
                    + "\nUPC saved as int, Description saved as String, Price saved as Float");
            e.printStackTrace();
        } finally {
            // releases resources associated with the streams
            if (is != null) {
                is.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (br != null) {
                br.close();
            }
        }//end try-catch-finally
    }//end ProductReader

    
    public final boolean hasMoreProducts() throws IOException {
        br.mark(41);
        if (br.readLine() != null) {
            if (readLine == 0) {
                br.reset();
                readLine = 1;
            }
            return true;
        }
        return false;
    }

    
    ProductSpec getNextProduct() {
        return nextProduct;
    }
    
    //Main method for testing individual file       **REMOVABLE**
    public static void main(String[] args) throws IOException {
        ProductReader pr = new ProductReader("products.txt");
        //ProductSpec item1 = new ProductSpec();
    }//end main
}
