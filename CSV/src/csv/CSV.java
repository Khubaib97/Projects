/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.*;
import java.util.*;

/**
 *
 * @author Khubaib
 */
public class CSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner inp = new Scanner(System.in);
        File f1 = new File("F:\\hue.txt");
        PrintWriter pw1 = new PrintWriter(new FileOutputStream(f1, true));
        while(true){
            int lel = 0;
            System.out.println("0 to keep entering, 1 to exit.");
            lel = inp.nextInt();
            inp.nextLine();
            if(lel==0){
                pw1.println();
                System.out.println("Enter SKU:");
                pw1.print(inp.nextLine()+",");
                System.out.println("Enter Quantity:");
                pw1.print(inp.nextLine()+",");
                System.out.println("Enter price:");
                pw1.print(inp.nextLine()+",");
                System.out.println("Enter description:");
                pw1.print(inp.nextLine());
            }
            else{
                break;
            }
        }
        pw1.close();
        inp.close();
        /*BufferedReader br = new BufferedReader(new FileReader("F:\\hue.txt"));
        String line = null;
        while((line = br.readLine())!= null){
            System.out.println(line);
        }
        br.close();*/
        Scanner sc1 = new Scanner(f1);
        sc1.nextLine();
        sc1.useDelimiter(",");
        while(sc1.hasNext()){
            double total;
            sc1.next();
            int quantity = Integer.parseInt(sc1.next());
            double price = Double.parseDouble(sc1.next());
            total = price*quantity;
            System.out.println(sc1.next()+"'s price is:"+total);
        }
        sc1.close();
    }
    
}
