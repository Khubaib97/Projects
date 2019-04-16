/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saddlepoint;

/**
 *
 * @author Khubaib
 */
public class SaddlePoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                arr[i][j] = (int)(Math.random()*100);
                if(arr[i][j]>9){
                    System.out.print(arr[i][j]+" ");
                }
                else{
                    System.out.print(arr[i][j]+"  ");
                }
            }
            System.out.println("");
        }
        sdlchk(arr);
    }
    public static void sdlchk(int[][] arr){
        boolean rowchk = false, colchk = false; int count=0;
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                rowchk = false; colchk = false;
                for(int a = 0; a<arr.length; a++){
                    if(a==i){
                        continue;
                    }
                    if(arr[i][j]>=arr[a][j]){
                        rowchk = true;
                    }
                    else{
                        rowchk = false;
                        break;
                    }
                }
                for(int b = 0; b<arr[i].length; b++){
                    if(b==j){
                        continue;
                    }
                    if(arr[i][j]<=arr[i][b]){
                        colchk = true;
                    }
                    else{
                        colchk = false;
                        break;
                    }
                }
                if(rowchk==true && colchk==true){
                    System.out.println("Saddle point is "+arr[i][j]+" and its position is row"+i+", column"+j);
                    count += 1;
                }
            }
        }
        if(count==0){
            System.out.println("No saddle points.");
        }
    }
}
