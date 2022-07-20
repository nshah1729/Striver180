package Day_1;

import java.util.ArrayList;
import java.util.Arrays;

public class NonRepeatingCharactersInString {
    public static void main(String[] args) {
        String s="google";
        char[] ans=find(s);
        System.out.println(Arrays.toString(ans));
    }

    private static char[] find(String s) {
        int[] a=new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']+=1;
        }
        ArrayList<Character> ans=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i]==1)ans.add((char)(97+i));
        }
        char[] finalA=new char[ans.size()];

        for (int i = 0; i < ans.size(); i++)
            finalA[i]=ans.get(i);

        return finalA;
    }
}
