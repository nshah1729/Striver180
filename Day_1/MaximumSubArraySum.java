package Day_1;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(max(a));
    }

    private static int max(int[] a) {
        int maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a.length ; j++) {
                int sum=0;
                for (int k = i; k <= j; k++) {
                    sum+=a[j];
                }
                maxSum=Math.max(maxSum,sum);
//                sum=0;
            }
        }
        return maxSum;
    }
}
