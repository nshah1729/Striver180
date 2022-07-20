package Day_1;

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] m= {{1,1,1},
                    {1,0,1},
                    {1,1,1}};
        int n=m.length;
        int[][] mCopy=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mCopy[i][j]= m[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mCopy[i][j]==0&&m[i][j]==0){
                    //Setting that particular column element to 0
                    for (int row = 0; row < n; row++)
                        m[row][j]=0;
                    //Setting that particular row element to 0
                    for (int col = 0; col < n; col++) {
                        m[i][col]=0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}
