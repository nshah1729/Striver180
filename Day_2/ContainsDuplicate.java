package Day_2;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] a={1,2,3,1};
        System.out.println(findBF(a));
        System.out.println(find(a));
        System.out.println(findUsingSort(a));
    }
    public static int findBF(int[] a){   //T.C:O(n²)
                                        //S.C:O(1)
        int n=a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(a[i]==a[j])return a[i];
            }
        }
        return -Integer.MIN_VALUE;
    }
    public static int findUsingSort(int[] a){   //T.C:O(nlogn)
                                                //S.C:O(1)
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if(a[i]==a[i+1])return a[i];
        }
        return -1;
    }
    public static int find(int[] a) {   //T.C:O(n)
                                         //S.C:O(n)
        HashSet<Integer> set=new HashSet<>();
        int n = a.length;
        for(int x:a){
            if(!set.contains(x))set.add(x);
            else return x;
        }
        return -1;
    }
}
