/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancedsearch;

/**
 *
 * @author Khubaib
 */
public class SearchList {
    WordNode[] head_list;
    public SearchList(){
        head_list = new WordNode[26];
    }
    public void search(String word){
        char c = word.charAt(0);
        int point;
        if(Character.isUpperCase(c)){
            point = ((int)c) - 65;
        }
        else{
            point = ((int)c) - 97;
        }
        WordNode temp = head_list[point];
        while(temp!=null){
            if(temp.data.equalsIgnoreCase(word)){
                URLNode tem = temp.url_head;
                System.out.print(word+": ");
                while(tem!=null){
                    System.out.print(tem.url+", ");
                    tem = tem.next;
                }
                break;
            }
            temp = temp.next;
        }
    }
    public void insert(String word, String url){
        char c = word.charAt(0);
        int point;
        if(Character.isUpperCase(c)){
            point = ((int)c) - 65;
        }
        else{
            point = ((int)c) - 97;
        }
        WordNode temp = head_list[point];
        boolean flag = false;
        if(head_list[point]==null){
            head_list[point] = new WordNode(word, url);
            return;
        }
        while(temp!=null){
            if(temp.data.equalsIgnoreCase(word)){
                URLNode tem = temp.url_head;
                while(tem.next!=null){
                    tem = tem.next;
                }
                tem.next = new URLNode(url);
                flag = true;
                break;
            }
            temp = temp.next;
        }
        temp = head_list[point];
        if(flag==false){
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new WordNode(word, url);
        }
    }
    public String toString(){
        String str = "";
        for(int i = 0; i<head_list.length; i++){
        WordNode temp = head_list[i];
        str = str+"*****"+(char)(i+65)+"*****\n";
        while(temp!=null){
            URLNode tem = temp.url_head;
            str = str+temp.data+": ";
            while(tem!=null){
                str = str+tem.url+", ";
                tem = tem.next;
            }
            temp = temp.next;
            str = str+"\n";
        }
        }
        return str;
    }
}
class WordNode{
    String data;
    URLNode url_head;
    WordNode next;
    public WordNode(String word, String url){
        this.data = word;
        url_head = new URLNode(url);
        next = null;
    }
}
class URLNode{
    String url;
    URLNode next;
    public URLNode(String url){
        this.url = url;
        next = null;
    }
}
