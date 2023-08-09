import java.util.ArrayList;
import java.util.List;

public class FindingBestSalesDays {

    /*
    * As a data analyst at a fast-growing startup, you have been tasked with identifying the peak sales periods for
    * the company. You have been provided with an integer array 'sales_data' which represents the daily sales figures
    * for the past month. Your task is to write a function that can find a peak element in the 'sales_data' array.
    * A peak element is defined as an element that is strictly greater than its neighbors, thus a better result was
    * achieved for this day. Identify the indices of all peak elements in sales_data.
    *
    * Example 1:
    *
    * int[] sales_data = {1, 2, 3, 4, 5, 4, 3, 2, 1};
    * List<Integer> expectedOutput = Arrays.asList(4);
    * List<Integer> actualOutput = findPeakElements(sales_data);
    * assert expectedOutput.equals(actualOutput);
    *
    * Example 2:
    * int[] sales_data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    * List<Integer> expectedOutput = Arrays.asList();
    * List<Integer> actualOutput = findPeakElements(sales_data);
    * assert expectedOutput.equals(actualOutput);
    *
    *
    * */
    public static void main(String[] args){
        int[] sales_data = {1, 2, 3, 4, 5, 4, 6, 2, 1};
        List<Integer> actualOutput = findPeakElements(sales_data);
        System.out.println(actualOutput);

        sales_data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        actualOutput = findPeakElements(sales_data);
        System.out.println(actualOutput);

        sales_data = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1};
        actualOutput = findPeakElements(sales_data);
        System.out.println(actualOutput);
        sales_data = new int[]{};
        actualOutput = findPeakElements(sales_data);
        System.out.println(actualOutput);

    }

    public static List<Integer> findPeakElements(int[] sales_data){

        List<Integer> peakElements = new ArrayList<>();
        if(sales_data == null || sales_data.length < 3){
            return peakElements;
        }

        int a = 0;
        int b = 1;
        int c = 2;

        while(c < sales_data.length){

            if(sales_data[b] > sales_data[a] && sales_data[b] > sales_data[c]){
                peakElements.add(b);
                a = c;
                b = a+1;
                c = b+1;
            }else {
                a++;
                b++;
                c++;
            }

        }

        return peakElements;
    }
}
