package Graphs_PepCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class fg {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.add(2);
        s.add(5);
        s.add(6);
        s.add(3);

//        middle(s,0,s.size());
//        System.out.println(s);
//        String str="[{()}]";
//        String str="[{()]";
//        bal(str);
//        insertAtBottom(s,3);
//        reverse(s);
//        System.out.println(s);
        String st="sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        System.out.println( areNumbersAscending(st));
    }

    private static void bal(String s) {
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='['||c=='{'||c=='('){
                st.add(c);
            }else if(c==')'){
                if(st.peek()=='(')st.pop();
            }else if(c=='}'){
                if(st.peek()=='{')st.pop();
            }else if(c==']'){
                if(st.peek()=='[')st.pop();
            }
        }
        if(st.size()==0) System.out.println("Balanced");
        else  System.out.println("Not Balanced");
    }

    private static void reverse(Stack<Integer> s){
        if(s.isEmpty())return;
        int num=s.pop();
        reverse(s);
        insertAtBottom(s,num);
    }

    static int numberToBeInserted=10;
    private static void insertAtBottom(Stack<Integer> s,int x) {
        if(s.isEmpty()){
            s.add(x);
            return;
        }
        int top=s.pop();
        insertAtBottom(s,x);
        s.add(top);
    }

    private static Stack<Integer> print(Stack<Integer> s) {
        if(s.size()==1)return s;
        int x=s.pop();
        Stack<Integer> ros=print(s);
        ArrayList<Integer> store=new ArrayList<>();
        while(s.peek()>x){
            store.add(s.pop());
        }
        s.add(x);
        while(store.size()>0){s.add(store.remove(store.size()-1));}
        return s;
    }

    private static void middle(Stack<Integer> s,int count,int n) {
        if(count==n/2){
            s.pop();
            return;
        }
        int temp=s.pop();
        middle(s,count+1,s.size());
        s.add(temp);
    }
    public static boolean areNumbersAscending(String st) {
        char[] s=st.toCharArray();
        int p=0;
        for(char c:s){
            if(Character.isDigit(c)){
                int num=c-'0';
                if(num<p)return false;
                p=num;
            }
        }
        return true;
    }
}
