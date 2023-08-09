import java.util.*;

public class MostSoldProducts {

    /*
    * As a startup, we want to analyze our customers' purchase history to identify the top k frequently used products.
    * We need you to write a function that takes in an integer array of sold product IDs and an integer k, and returns
    * the k most frequent products.
    *
    * Example 1:
    * int[] products = {1, 2, 3, 4, 5, 1, 2, 3, 1, 2, 1};
    * int k = 2;
    * List<Integer> result = topKFrequent(products, k);
    * System.out.println(result);
    * Output:[1, 2
    *
    * Example 2:
    * int[] products = {1, 2, 3, 4, 5, 1, 2, 3, 1, 2, 1};
    * int k = 3;
    * List<Integer> result = topKFrequent(products, k);
    * System.out.println(result);
    * Output:[1, 2, 3]
    *
    *
    * */



    public static List<Integer> topKFrequent(int[] products, int k){
        List<Integer> topFrequent = new ArrayList<>();
        if(products == null || k < 1 || k > products.length){
            return topFrequent;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int product : products) {
            int frequency = map.getOrDefault(product, 0);
            map.put(product, frequency + 1);
        }

        List<Map.Entry<Integer, Integer>> listOfEntries = getEntries(map);
        System.out.println(listOfEntries);

       for(Map.Entry<Integer, Integer> entry : listOfEntries){
           topFrequent.add(entry.getKey());
           k--;
           if(k < 1){
               break;
           }
       }


        return topFrequent;
    }

    private static List<Map.Entry<Integer, Integer>> getEntries(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        Comparator<Map.Entry<Integer, Integer>> valueComparator =
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        Integer v1 = o1.getValue();
                        Integer v2 = o2.getValue();
                        return v2.compareTo(v1);
                    }
                };

        List<Map.Entry<Integer,Integer>> listOfEntries =
                new ArrayList<>(entries);

        listOfEntries.sort(valueComparator );
        return listOfEntries;
    }

}
