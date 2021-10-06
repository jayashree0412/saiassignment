package saianjhuvin6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Huffman66 {
    String filePath = "C:\\Users\\jayas\\Desktop\\CSCI 3901 Assignment6 -converted.docx";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("C:\\Users\\jayas\\Desktop\\CSCI 3901 Assignment6 -converted.docx");

        BufferedReader br = new BufferedReader(fr);
        int nextLetter;
        int[] count = new int[26];
        int total = 0;
        int other = 0;


        System.out.println("Letter           Frequency");
        while ((nextLetter = br.read()) != -1) {
            char current = (char) nextLetter;
            current = Character.toLowerCase(current);
            if (current >= 'a' && current <= 'z') {
                count[current - 'a']++;
                total++;
            } else {
                other++;
            }
        }
        Map ans = sorting(count);
        printMap(ans);
        convertToTreeMap(ans);
//        Map min= getMinimumValue(ans);
//        removeMinimumValue(min);
    }

    private static Map sorting(int[] count) {
        Map m = new LinkedHashMap<String, Integer>() {
        };
        int k = 0;
        for (int i = 0; i < 26; i++) {
            int max = -1;
            for (int j = 0; j < 26; j++) {
                if (max < count[j]) {
                    max = count[j];
                    k = j;
                }
            }
            count[k] = -1;
            if (max != 0)
                m.put(((char) (k + 97)) + "", max);
            max = 0;
        }
        return m;

    }


    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("" + entry.getKey() + "     : " + entry.getValue());
        }
    }

    public static void convertToTreeMap(Map<String, Integer> map) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.putAll(map);
        Map sortedMap = valueSort(treeMap);
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {

            Map.Entry mp = (Map.Entry) i.next();
            System.out.print("hi " + mp.getKey() + ": ");
            System.out.println(mp.getValue());

        }
//       for (Map.Entry<String, Integer> entry : treeMap.entrySet())
//            System.out.println("remove min value " + entry.getKey() + "     : " + entry.getValue());

    }

    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}
