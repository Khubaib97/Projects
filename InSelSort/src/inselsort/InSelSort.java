/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inselsort;

/**
 *
 * @author Khubaib
 */
public class InSelSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sorting s = new Sorting();
        String str = "Take a Paragraph as a String. Create a String Array equal to the number of words in the Paragraph. Fill the Array with the words and sort them in Ascending Order by using both insertion and selection sort. The program must be dynamic i.e. change in the Paragraph will not affect the Program.";
        String[] arr = str.split(" ");
        s.selection_sort(arr);
        s.insertion_sort(arr);
    }
    
}
