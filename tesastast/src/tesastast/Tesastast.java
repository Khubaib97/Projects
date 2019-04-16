/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesastast;
import java.io.*;
/**
 *
 * @author Khubaib
 */
public class Tesastast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f1 = new File("123.dat");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f1));
        
    }
    
}
