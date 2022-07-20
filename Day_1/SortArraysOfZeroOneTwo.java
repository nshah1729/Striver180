package Day_1;

import java.util.Arrays;

public class SortArraysOfZeroOneTwo {
    public static void main(String[] args) {
        int[] a={1,0,1,0,2,1,2,0,1};
        int[] b={-4,-1,0,3,10};
        System.out.println(Arrays.toString(ansAliter(b)));
//        bruteForce(a);
//        DNF(a);
//        System.out.println(Arrays.toString(a));
    }

    private static int[] ans(int[] a) {
        int[] res=new int[a.length];
        int i=0,j=a.length-1;
        for (int k = res.length-1; k >=0; k--) {
            if(Math.abs(a[i])>Math.abs(a[j])){
                res[k]=a[i]*a[i];
                i++;
            }else{
                res[k]=a[j]*a[j];
                j--;
            }
        }
        return res;
    }
    private static int[] ansAliter(int[] a) {
        int[] res=new int[a.length];
        int i=0,j=a.length-1;
        int k=a.length-1;
        while(i<=j){
            if(Math.abs(a[i])>Math.abs(a[j])){
                res[k--]=a[i]*a[i];
                i++;
            }else{
                res[k--]=a[j]*a[j];
                j--;
            }
        }
        return res;
    }

    public static void bruteForce(int[] a){
        int count1,count2,count0;
        count2=count0=count1=0;

        for(int x:a){
            if(x==0)count0++;
            else if(x==1)count1++;
            else count2++;
        }
        int idx=0;
        while (count0>0){
            a[idx++]=0;
            count0--;
        }while (count1>0){
            a[idx++]=1;
            count1--;
        }while (count2>0){
            a[idx++]=2;
            count2--;
        }
    }

    public static void DNF(int[] a){
        int i,j,k;
        i=j=0;
        k=a.length-1;
        while(i<=k){
            if(a[i]==1){
                i++;
            }else if(a[i]==0){
                swap(a,j,i);
                j++;
                i++;
            }else{
                swap(a,k,i);
                k--;
            }
        }
    }
    public static void swap(int[] a,int x,int y){
        int t=a[x];
        a[x]=a[y];
        a[y]=t;
    }
}
