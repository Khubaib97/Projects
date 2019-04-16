/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixtopostfix;

/**
 *
 * @author Khubaib
 */
public class InfixToPostfix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(infixtoPostfix("[ (A + B ) / B + A - C + ( B - C ) ]"));
    }
    static Stack<Character> MyStk = new Stack<Character>();   
    static String Postfix ="";   
    public static String infixtoPostfix(String expr) {
        int i = 0;
        char ch;
        while (i < expr.length()) {    
            ch = expr.charAt(i++);
            switch (ch) {    
                case '(':    
                case '{':    
                case '[':     
                    MyStk.push(ch);
                    break;    
                case '+':   
                case '-':    
                    Setpriority(ch, 1); 
                    break;   // set priority 1 to ch   
                case '*':   
                case '/':    
                    Setpriority(ch, 2);  
                    break;   // set priority 2 to ch   
                case ')':   
                case '}':   
                case ']':    
                    SetAtClose(ch);    
                    break;   
                default:    
                    Postfix = Postfix + ch; // if operand add to postfix string    
            }   
        } // in the end whatever left in stack add in postfix string 
        while(!MyStk.isEmpty())                               
            Postfix=Postfix+MyStk.pop();            
        return Postfix;
    }    
    public static void Setpriority(char c, int priority) {
        int p = 5;
        if(MyStk.peek()=='+' || MyStk.peek()=='-')
            p = 1;
        else if(MyStk.peek()=='*' || MyStk.peek()=='/')
            p = 2;
        if(p > priority){
            MyStk.push(c);
        }
        else if(p < priority){
            Postfix = Postfix + MyStk.pop();
        }
        else if(p==priority){
            Postfix = Postfix + MyStk.pop();
            MyStk.push(c);
        }
    }  
    public static void SetAtClose(char c) {
        char token = MyStk.pop();
        while(token!='(' && token!='{' && token!='['){
            Postfix = Postfix + token;
            token = MyStk.pop();
        }
    } 
}
