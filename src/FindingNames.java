
import java.util.ArrayList;
import java.util.List;

public class FindingNames {

    /*
    * We need to generate all possible variations of product names that we can use for marketing purposes. To this end,
    * our startup needs a function that takes in an array of distinct characters and returns all
    * the possible permutations of the characters.
    *
    * Example 1:
    * char[] chars = {'a', 'b', 'c'};
    * List<String> result = generateProductNames(chars);
    * Output: [abc, acb, bac, bca, cab, cba]
    *
    * Example 2:
    * char[] chars = {'1', '2', '3', '4'};
    * List<String> result = generateProductNames(chars);
    * Output:[1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142,
    *  3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321]
    *
    * */

    public static List<String> generateProductNames(char[] chars){

        List<String> result = new ArrayList<>();
        if(chars == null || chars.length < 1){
            return result;
        }
        boolean[] used = new boolean[chars.length];
        String permutation = "";
        result = backtrack(result, chars,permutation , used);

        return result;
    }

    private static List<String> backtrack(List<String> result,char[] elements,
                                          String permutation, boolean[] used){

        if(permutation.length() == elements.length){
            result.add(permutation);
        }

        for(int i = 0; i < elements.length; i++){
            if(!used[i]){   // Valid choice
                //Make a choice
                used[i] = true;
                permutation+=elements[i];
                backtrack(result, elements, permutation, used);
                //undo the choice
                used[i] = false;
                permutation = permutation.substring(0, permutation.length()-1);

            }
        }

        return result;
    }

}
