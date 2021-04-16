package muhidinCliProjectJava;

import java.util.*;

//Input: n = 5
//Output: [-7,-1,1,3,4]
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//
        System.out.println(Arrays.toString(solution.bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3})));


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


    public int uniquePaths(int m, int n) {
        int[][] solution = new int[m][n];
        for (int i = 0; i < m; i++) {
            solution[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            solution[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                solution[i][j] = solution[i - 1][j] + solution[i][j - 1];
            }
        }
        return solution[m - 1][n - 1];
    }


    public boolean isPalindrome(int x) {
        int remainder, sum = 0, temp;
        temp = x;
        while (x > 0) {
            remainder = x % 10;
            sum = (sum*10)+remainder;
            x = x / 10;
        }
        return temp == sum;
    }



    //Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
//    Input: num = 38
//    Output: 2
//    Explanation: The process is
//    38 --> 3 + 8 --> 11
//    11 --> 1 + 1 --> 2
//    Since 2 has only one digit, return it.

    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }


//    Given a string s, reverse the order of characters in
//    each word within a sentence while still preserving whitespace and initial word order
//    Input: s = "Let's take LeetCode contest"
//    Output: "s'teL ekat edoCteeL tsetnoc"



    public String reverseWords(String s) {
        String reverseDString;
        StringBuilder stringSolution  = new StringBuilder();
        String[] stringArr = s.split(" ");


        for (String word: stringArr) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            stringSolution.append(reverseWord).append(" ");
        }
        return stringSolution.toString();
    }


    public int solutionTest(int[] A) {
        int i = 0;
        Set<Integer> setNums = new HashSet<Integer>();

        for (int num: A){
            setNums.add(num);
        }

        while (setNums.contains(i)) {
            i++;
        }
        return  i;
    }


    public int searchInsert(int[] nums, int target) {
        if(target == 0 || nums.length < 1) {
            return 0;
        } else if (nums.length == 1 && target > nums[0]) {
            return 1;
        } else if (nums.length == 1 && target < nums[0]){
            return 0;
        } else {
            return target;
        }
    }


    public String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < c1.length && j < c2.length) {
            sb.append(c1[i++]);
            sb.append(c2[j++]);

        }
        sb.append(word1.substring(i));
        sb.append(word2.substring(j));
        return sb.toString();
    }


    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer, String> difference = new HashMap<Integer, String>();
        for (int num: array){
            int diff = targetSum - num;
            if (difference.containsKey(diff)) {
                return new int[]{diff, num};
            } else {
                difference.put(num, "Whatever");
            }
        }
        return new int[0];
    }



    public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int j = 0;
        boolean returnState = false;
        int size = sequence.size();
        if (array.size() <= 1 || sequence.size() == 0) {
            return true;
        } else {
            for (Integer integer : array) {
                if (integer.equals(sequence.get(j))) {
                    j++;
                    if(j == size){
                        returnState = true;
                    }
                }
            }
        }
        return returnState;
    }


    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        int i = 0;
        for (int num: array) {
            squared[i] += num * num;
            i++;
        }
        Arrays.sort(squared);
        return squared;
    }


//    "competitions": [
//            ["HTML", "Java"],
//            ["Java", "Python"],
//            ["Python", "HTML"],
//            ["C#", "Python"],
//            ["Java", "C#"],
//            ["C#", "HTML"],
//            ["SQL", "C#"],
//            ["HTML", "SQL"],
//            ["SQL", "Python"],
//            ["SQL", "Java"]
//            ],
//            "results": [0, 1, 1, 1, 0, 1, 0, 1, 1, 0]



    public void primes2(long number){
        for(int i = 2; i< number; i++) {
            while(number%i == 0) {
                System.out.println(i+" ");
                number = number/i;
            }
        }
        if(number >2) {
            System.out.println(number);
        }
    }
    public long primes(long n)
    {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }


    public  int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        Solution solution = new Solution();

        for(int num: array) {
            solution.updateLargest(threeLargest, num);
        }
        return threeLargest;
    }

    public void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if(num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }

    public void shiftAndUpdate(int[] arr, int num, int idx) {

        for (int i = 0; i <= idx; i++) {
            if(i == idx) {
                arr[i] = num;
            } else {
                arr[i] = arr[i + 1];
            }
        }
    }



    public  int[] bubbleSort(int[] array) {
        int n = array.length;

        int temp = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i -1) ; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    public static int[] insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int j = i;
            while(j > 0 && array[j] < array[j -1]){
                swap(j, j-1, array);
                j--;
            }
        }
        return array;
    }

    private static void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

    }
}
}

//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
