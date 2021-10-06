package saianjhuvin6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Huffman6 {
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
//From the map, put the values in a node of a binary search tree
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

            Map.Entry mp = (Map.Entry)i.next();
            System.out.print("hi "+mp.getKey() + ": ");
            System.out.println(mp.getValue());

        }

    }

    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    }
// class to create nodes
//class Node {
//    int key;
//    Node left, right;
//
//    public Node(int item) {
//        key = item;
//        left = right = null;
//    }
//}

//class BinarySearchTree {
//
//    /* Class containing left
//       and right child of current node
//     * and key value*/
//    class Node
//    {
//        int key;
//        Node left, right;
//
//        public Node(int item)
//        {
//            key = item;
//            left = right = null;
//        }
//    }
//
//    // Root of BST
//    Node root;
//
//    // Constructor
//    BinarySearchTree()
//    {
//        root = null;
//    }
//
//    // This method mainly calls insertRec()
//    void insert(int key)
//    {
//        root = insertRec(root, key);
//    }
//
//    /* A recursive function to
//       insert a new key in BST */
//    Node insertRec(Node root, int key)
//    {
//
//        /* If the tree is empty,
//           return a new node */
//        if (root == null)
//        {
//            root = new Node(key);
//            return root;
//        }
//
//        /* Otherwise, recur down the tree */
//        if (key < root.key)
//            root.left = insertRec(root.left, key);
//        else if (key > root.key)
//            root.right = insertRec(root.right, key);
//
//        /* return the (unchanged) node pointer */
//        return root;
//    }
//
//    // This method mainly calls InorderRec()
//    void inorder()
//    {
//        inorderRec(root);
//    }
//
//    // A utility function to
//    // do inorder traversal of BST
//    void inorderRec(Node root)
//    {
//        if (root != null) {
//            inorderRec(root.left);
//            System.out.println(root.key);
//            inorderRec(root.right);
//        }
//    }
//
//}
//
