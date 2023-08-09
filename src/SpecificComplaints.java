import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SpecificComplaints {

    /*
    * We have a large database of customer feedback, and we want to analyze the most common complaints. We need a
    * function that takes an integer array representing how often each unique complaint was made and an integer k,
    * the rank of the element we want to find in the array, and returns the complaint with the k largest frequency.
    *
    * Example 1:
    * int[] complaints = {2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6};
    * int k = 2;
    * int result = kthLargestFrequency(complaints, k);
    * // result should be 4
    *
    * Example 2:
    * int[] complaints = {1, 1, 1, 2, 2, 3};
    * int k = 1;
    * int result = kthLargestFrequency(complaints, k);
    * // result should be 1
    * */

    public static void main(String[] args){
        int[] complaints = {2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6};
        int k = 2;
        int result = kthLargestFrequency(complaints, k);
        System.out.println(result);


        complaints =new int[]{1, 1, 1, 2, 2, 3};
        k = 1;
        result = kthLargestFrequency(complaints, k);
        System.out.println(result);
    }
    public static int kthLargestFrequency(int[] numbers, int k){

        if(numbers == null || numbers.length < 1 || k < 1 || k > numbers.length){
            return -1;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i : numbers){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(b).compareTo(freqMap.get(a)));
        pq.addAll(freqMap.keySet());

        int result = 0;
        while(k > 0){
            result = pq.poll();
            k--;
        }

        return result;
    }

}
