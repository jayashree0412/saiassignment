package saianjhuvin6;


import java.awt.print.Book;
import java.util.*;

public class BinarySearchTree996 {
    private static String sumkey=" ";
    private static int sumValue=0;
    private static String combinedChar="";
    static int count=1;
    private  int size=0, code=0,numberOfDigits;
    private String mapkey;

    Set<HuffmanCode> set=new TreeSet<HuffmanCode>();
    Set<HuffmanCode> set6;
    HuffmanCode huffmanCodeObj;
    Map<String, Integer> nodeMap=new HashMap<>();
    HashMap<String, Integer> hm9;

    // This method mainly calls InorderRec()
    public void inorder()
    {
        inorderRec(root);
    }

    public void gettingMap(HashMap<String, Integer> hm1) {
        hm9=hm1;
        for (Map.Entry<String, Integer> en :
                hm1.entrySet()) {
             System.out.println("getting Key = " + en.getKey()
                     + ", getting Value = "
                     + en.getValue());
        }

    }


    class Node {
        String key;
        int value;
        Node left, right;
        Obj obj;

        public Node(Obj item){
            this.key=item.key;
            this.value = item.value;
            left = null;
            right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree996()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(Obj key)
    {
        root = insertRec(root, key);
        combinedChar =addBT(root);
        System.out.println(combinedChar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree996 that = (BinarySearchTree996) o;
        if(root.equals(that.root))
            return true;
        else
            return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    /* A recursive function to
           insert a new key in BST */
    Node insertRec(Node root, Obj object)
    {

        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(object);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (root.obj.value <= object.value)
            root.left = insertRec(root.left, object);
        else if (root.obj.value > object.value)
            root.right = insertRec(root.right, object);

        /* return the (unchanged) node pointer */
        return root;
    }


    // A utility function to
    // do inorder traversal of BST
    public void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    public String addBT(Node root)
    {
        int oddInd=1;
        int evenInd=0;
        if (root != null) {
            sumkey = sumkey + root.key;
            sumValue = sumValue + root.value;
            huffmanCodeObj=new HuffmanCode(count++, sumkey, sumValue);
            set.add(huffmanCodeObj);
        }
//        size=nodeMap.size();

//        for(HuffmanCode h:set){
//            System.out.println(h.count+" "+h.sumkey+" "+h.sumValue);
//        }
        addCode(set);
        return(sumkey+" "+sumValue);
//        return set;
    }


     public void addCode( Set<HuffmanCode> set){
        set6=set;
         for(HuffmanCode h:set6){

             if(count%2!=0){
                 numberOfDigits=count;
                 code=1;
                 System.out.println("sai "+h.count+" "+h.sumkey+" "+h.sumValue+ " code="+code+" numberOfDigits= "+numberOfDigits);
             }
             else{
                 code=0;
                 System.out.println("sai "+h.count+" "+h.sumkey+" "+h.sumValue+ " code="+code+" numberOfDigits= "+numberOfDigits);
             }
         }

     }



    class HuffmanCode implements Comparable<HuffmanCode>{
//        Obj value,key;

        Integer count, sumValue;
        String sumkey;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getSumValue() {
            return sumValue;
        }

        public void setSumValue(Integer sumValue) {
            this.sumValue = sumValue;
        }

        public String getSumkey() {
            return sumkey;
        }

        public void setSumkey(String sumkey) {
            this.sumkey = sumkey;
        }

        public HuffmanCode( Integer count, String sumkey, Integer sumValue) {
            this.count=count;
            this.sumkey=sumkey;
            this.sumValue=sumValue;
        }
         public int compareTo(HuffmanCode h){
            if(sumValue>h.sumValue){
                return 1;
            }
            else if(sumValue<h.sumValue){
                return -1;
            }
            else{
                return 0;
            }
         }

        @Override
        public String toString() {
            return "HuffmanCode{" +
                    "count=" + count +
                    ", sumValue=" + sumValue +
                    ", sumkey='" + sumkey + '\'' +
                    '}';
        }
    }
}

