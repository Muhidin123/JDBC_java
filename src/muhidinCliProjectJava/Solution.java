package muhidinCliProjectJava;

import java.util.Arrays;

//Input: n = 5
//Output: [-7,-1,1,3,4]
//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(Arrays.toString(solution.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}))
        );
    }

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int t = n/2;
        if(n%2 != 0){
            arr[0] = 0;
            for(int j=1;j<n-1;j=j+2){
                arr[j] = -1 * t;
                arr[j+1] = t--;
            }
        } else {
            for(int i=0; i<n;i=i+2){
                arr[i] = -1 * t;
                arr[i+1] = t--;
            }
        }
        return arr;
    }


        public int minSteps(int n) {
            int ans = 0, d = 2;
            while (n > 1) {
                while (n % d == 0) {
                    ans += d;
                    n /= d;
                }
                d++;
            }
            return ans;
        }


//    Loop through the array starting from the end.
//    Keep the maximum value seen so far.


    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
                int current = arr[i];

                arr[i] = max;

                if(current > max) {
                    max = current;
                }
            }
        return arr;
    }


//    Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//    Output: [8,6,2,4]
//    Explanation:
//    At the beginning, the array is [1,2,3,4].
//    After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
//    After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
//    After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
//    After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

//    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
//        int[] solution = new int[A.length];
//
//        for (int i = 0; i < A.length; i++) {
//            A[queries[i][1]] += queries[i][0];
//            solution[i] = helperSum(A);
//        }
//        return solution;
//    }
//
//    public int helperSum(int[] arr) {
//        int sum = 0;
//        for (int num: arr) {
//            if (num % 2 == 0) {
//                sum+= num;
//            }
//        }
//        return sum;
//    }


    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        //optimized solution
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }

}