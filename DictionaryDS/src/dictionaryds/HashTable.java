/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryds;

/**
 *
 * @author Khubaib
 */
public class HashTable {
    dictionary_ht[] table;
    public HashTable(int size){
        table = new dictionary_ht[size+(size/3)];
        for(int i = 0; i<table.length; i++){
            table[i] = new dictionary_ht("", "");
        }
    }
    public int Hash(String str){
        return Math.abs(DictionaryDS.GetASCII(str)%table.length);
    }
    public int QHash(int val, int i){
        return Math.abs((val+(i*i))%table.length);
    }
    public void insert(String n, String m){
        int key = Hash(n);
        if(table[key].word.equals("")){
            table[key] = new dictionary_ht(n, m);
        }
        else{
            for(int i = 0; i<table.length; i++){
                key = QHash(key, i);
                if(table[key].word.equals("")){
                    table[key] = new dictionary_ht(n, m);
                    break;
                }
            }
        }
    }
    public void find(String n){
        int key = Hash(n);
        if(table[key].word.equalsIgnoreCase(n)){
            System.out.println(table[key].toString());
            return;
        }
        else{
            for(int i = 0; i<table.length; i++){
                key = QHash(key, i);
                if(table[key].word.equalsIgnoreCase(n)){
                    System.out.println(table[key].toString());
                    return;
                }
            }
        }
        System.out.println("Word not found");
    }
    public void delete(String n){
        int key = Hash(n);
        if(table[key].word.equalsIgnoreCase(n)){
            table[key] = new dictionary_ht("", "");
            return;
        }
        else{
            for(int i = 0; i<table.length; i++){
                key = QHash(key, i);
                if(table[key].word.equalsIgnoreCase(n)){
                    table[key] = new dictionary_ht("", "");
                    return;
                }
            }
        }
        System.out.println("Word not found");
    }
    public void display(){
        for(int i = 0; i<table.length; i++){
            if(!table[i].word.equals("")){
                System.out.println(table[i].toString());
            }
        }
    }
}
class dictionary_ht{
    String word;
    String meaning;
    public dictionary_ht(String w, String m){
        word = w;
        meaning = m;
    }
    public String toString(){
        return word+"  "+meaning;
    }
}
