/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rehash;

/**
 *
 * @author Khubaib
 */
public class HashTable {
    String[] table;
    public HashTable(int size){
        table = new String[size+(size/3)];
    }
    public int strToint(String str){
        int faizan = 0;
        for(int i = 0; i<str.length(); i++){
            faizan += str.charAt(i);
        }
        return faizan;
    }
    public int Hash(String str){
        return strToint(str)%table.length;
    }
    public int LHash(String str, int val){
        return (val+1)%table.length;
    }
    public int QHash(String str, int val, int i){
        return (val+(i*i))%table.length;
    }
    public void insert(String str, int sc){
        long start = 0;
        long finalu = 0;
        int faizan = Hash(str);
        if(table[faizan]==null){
            table[faizan] = str;
        }
        else{
            switch(sc){
                case 0:
                    start = System.currentTimeMillis();
                    faizan = Hash(str);
                    for(int i = 0; i<table.length; i++){
                        faizan = LHash(str, faizan);
                        if(table[faizan]==null){
                            table[faizan] = str;
                            finalu = System.currentTimeMillis();
                            System.out.println("Timez taken: "+(finalu-start));
                            return;
                        }
                    }
                    break;
                case 1:
                    start = System.currentTimeMillis();
                    faizan = Hash(str);
                    for(int i = 0; i<table.length; i++){
                        faizan = QHash(str, faizan, i);
                        if(table[faizan]==null){
                            table[faizan] = str;
                            finalu = System.currentTimeMillis();
                            System.out.println("Time taken: "+(finalu-start));
                            return;
                        }
                    }
                    break;
            }
        }    
    }
    public void displayTable(){
        for(int i = 0; i<table.length; i++){
            System.out.println(table[i]);
        }
    }
}
