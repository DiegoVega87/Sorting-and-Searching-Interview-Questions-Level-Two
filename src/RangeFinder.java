import java.util.Arrays;

public class RangeFinder {

    /*
    * Your startup has a database of customer purchase histories. You need to create a function that takes an array
    * of integers representing the purchase amounts sorted in non-decreasing order and an integer representing the exact
    * amount sold. The function should return an array of two integers representing the starting and ending positions
    * of the target purchase amount.
    *
    * Example 1:
    * int[] purchases = {10, 20, 35, 40, 50};
    * int targetAmount = 30;
    * int[] expectedOutput = {0, 1};
    *
    * Example 2:
    * int[] purchases = {5, 10, 15, 22, 25, 30, 35};
    * int targetAmount = 25;
    * int[] expectedOutput = {1, 2};
    *
    *
    * */



    public static int[] findPurchaseAmount(int[] purchases, int targetAmount){

        int[] indexes = {-1,-1};

        if(purchases == null || purchases.length < 1){
            return indexes;
        }

        int start = 0;
        int end = purchases.length -1;

        while(start < end){

            int sum = purchases[start] + purchases[end];

            if(sum == targetAmount){
                indexes[0] = start;
                indexes[1] = end;
                return indexes;
            }else if(sum < targetAmount){
                start++;
            }else{
                end--;
            }
        }

        return indexes;
    }
}
