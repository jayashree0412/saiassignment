package saianjhuvin6;


import javax.swing.tree.TreeNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Huffman96 {
//    String filePath = "C:\\Users\\jayas\\Desktop\\CSCI 3901 Assignment6 -converted.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("C:\\Users\\jayas\\Desktop\\sHuffman6.txt");

        BufferedReader br = new BufferedReader(fr);
        int nextLetter;
        int[] count = new int[96];
        int total = 0;
        int other = 0;
        char current=' ';



        System.out.println("Letter           Frequency");
        while ((nextLetter = br.read()) != -1) {
            current = (char) nextLetter;
            current = Character.toLowerCase(current);
            if (current >= ' ' && current <= '~') {
                count[current - ' ']++;
                total++;
            }
            else {
                other++;
            }
        }
        HashMap ans = sorting(count,current);
        System.out.println("size "+ans.size());
        HashMap sorted=printMap(ans);
//        extractElementsFromMap(sorted);
        HashMap<String, Integer> hm1 = sortByValue((HashMap<String, Integer>) ans);
        extractElementsFromMap(hm1);
        passingMap(hm1);



    }

    public static void passingMap(HashMap<String, Integer> hm1 ){
        BinarySearchTree996 binarySearchTree996obj= new BinarySearchTree996();
        binarySearchTree996obj.gettingMap(hm1);
    }

    private static HashMap sorting(int[] count, char current) {
        HashMap m = new HashMap<String, Integer>() {
        };
        int k = 0;
        for (int i = 0; i < 96; i++) {
            int max = -1;
            for (int j = 0; j < 96; j++) {
                if (max < count[j]) {
                    max = count[j];
                    k = j;
                }
            }
            count[k] = -1;
            if (max != 0){
                if (current >= ' ' && current <= '~')
                    m.put(((char) (k + 32)) + "", max);
            }
            max = 0;
        }

        return m;
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        HashMap<String, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, Integer> en :
                temp.entrySet()) {
            System.out.println("Key = " + en.getKey()
                    + ", Value = "
                    + en.getValue());
        }
        return temp;
    }


    public  static void extractElementsFromMap(HashMap<String, Integer> hm1){
        int size= hm1.size();

        for (Map.Entry<String, Integer> en :
                hm1.entrySet()) {
//             System.out.println("Key = " + en.getKey()
//                     + ", Value = "
//                     + en.getValue());
            BinarySearchTree996 tree = new BinarySearchTree996();
            Obj obj;
            obj=new Obj(en.getKey(),en.getValue());
//            System.out.println("hi "+obj.key+" "+obj.value);
            tree.insert(obj);
//            tree.gettingMapSizeinTree(size);
//            tree.inorder();
        }
        System.out.println();


    }


    public static HashMap printMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> sorted=map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println("" + entry.getKey() + "     : " + entry.getValue());
        }
        return sorted;
    }

}
//class Obj{
//    String key;
//    Integer value;
//    Obj(String key,Integer value){
//        this.key=key;
//        this.value=value;
//    }

//    public String getKey() {
//        return key;
//    }

//    public void setKey(String key) {
//        this.key = key;
//    }
//}




