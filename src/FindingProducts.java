import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class FindingProducts {

    /*
    * As a startup with a unique product line, we want to generate all possible combinations of our products so that
    * we can target specific customer segments. Write a function that takes in an integer array of unique product
    * identifiers and returns all possible subsets (power set) of the products. Ensure that the solution set
    * does not contain duplicate subsets.
    *
    * Example 1:
    * int[] products = {1, 2, 3};
    * List<List<Integer>> subsets = generateSubsets(products);
    * System.out.println(subsets);
    * Output:[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
    *
    * Example 2:
    * int[] products = {4, 5, 6, 7};
    * List<List<Integer>> subsets = generateSubsets(products);
    * System.out.println(subsets);
    * Output:[[], [4], [5], [6], [7], [4, 5], [4, 6], [4, 7], [5, 6], [5, 7], [6, 7], [4, 5, 6], [4, 5, 7],
    *         [4, 6, 7], [5, 6, 7], [4, 5, 6, 7]]
    *
    * */

    public static void main(String[] args){

        int[] products = {1,2,3};
        List<List<Integer>> subsets = generateSubsets(products);
        System.out.println(subsets);


        products = new int[]{4, 5, 6, 7};
        subsets = generateSubsets(products);
        System.out.println(subsets);
    }

    public static List<List<Integer>> generateSubsets(int[] products){
        int n = products.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int k = 0; k <= n; k++){
            backtrack(0,new ArrayList<>(),products, n, k, result);
        }

        return result;
    }

    private static void backtrack(int first, List<Integer> current,int[] nums,
                                  int n, int k, List<List<Integer>> answer){

        if(current.size() == k){
            answer.add(new ArrayList<>(current));
            return;
        }

        for(int i = first; i < n; i++){
            current.add(nums[i]);
            backtrack(i+1, current,nums,n, k, answer);
            current.remove(current.size()-1);
        }
    }

}
