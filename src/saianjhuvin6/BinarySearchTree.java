//package saianjhuvin6;
//
//import javax.swing.tree.TreeNode;
//
//class BinarySearchTree {
//
//    private static String sumkey=" ";
//    private static int sumValue=0;
//    private static String combinedChar="";
//    private static int size=0;
//
//
//
//    public void inOrder() {
//        inorderRec(root);
//    }
//
//
//
//
//    /* Class containing left
//           and right child of current node
//         * and key value*/
//    class Node {
//        String key;
//        int value;
//        Node left, right;
//
//        public Node(String key, int value){
//            this.key=key;
//            this.value = value;
//            left = null;
//            right = null;
//        }
//    }
//
//    // Root of BST
//    Node root;
//
//    // Constructor
//    BinarySearchTree() {
//        root = null;
//    }
//
//    // This method mainly calls insertRec()
//    public void insert(String key,int value) {
//        root = insertRec(root, key, value);
//        combinedChar =addBT(root);
//        System.out.println(combinedChar);
//    }
//
//    /* A recursive function to
//       insert a new key in BST */
//    public Node insertRec(Node root, String key, int value) {
//        /* If the tree is empty,
//           return a new node */
//        if (root == null) {
//            root = new Node(key, value);
//        }
//        /* Otherwise, recur down the tree */
//        if (value <  root.value)
//            root.left = insertRec(root, key, value);
//        else if (value >  root.value)
//            root.right = insertRec(root, key, value);
//        /* return the (unchanged) node pointer */
//
//        return root;
//    }
//
//
//
//    private void inorderRec(Node root) {
//        if (root != null) {
//            inorderRec(root.left);
////            System.out.println(root.key+" "+root.value);
//            inorderRec(root.right);
//        }
//    }
//    static String addBT(Node root)
//    {
//        if (root != null) {
//            sumkey = sumkey + root.key;
//            sumValue = sumValue + root.value;
//        }
//
//        return(sumkey+" "+sumValue);
//    }
//
//    static void gettingMapSizeinTree(int Mapsize){
//       size=Mapsize;
//        System.out.println("from tree "+size);
//    }
//
//
//
//
//
//    }
