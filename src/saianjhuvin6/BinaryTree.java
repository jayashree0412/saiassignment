//package saianjhuvin6;
//
//
//public class BinaryTree {
//    // first node
//     Node root;
//    BinaryTree(){
//        root = null;
//    }
//    // Class representing tree nodes
//    static class Node{
//        int value;
//        String key;
//        Node left;
//        Node right;
//        Node(int value,String key){
//            this.value = value;
//            this.key=key;
//            left = null;
//            right = null;
//        }
//        public void displayData(){
//            System.out.print(value + " ");
//        }
//    }
//
//    public void insert(int value,String key){
//        Node newNode = new Node(value,key);
//        if(root == null){
//            root = newNode;
//        }else{
//            Node current = root;
//            Node parent;
//            while(true){
//                parent = current;
//                if(value < current.value){
//                    current = current.left;
//                    if(current == null){
//                        parent.left = newNode;
//                        return;
//                    }
//                }else{
//                    current = current.right;
//                    if(current == null){
//                        parent.right = newNode;
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//
//    // For traversing in order
//    public void inOrder(Node node){
//        if(node != null){
//            inOrder(node.left);
//            node.displayData();
//            inOrder(node.right);
//        }
//    }
//    // Preorder traversal
//    public void preOrder(Node node){
//        if(node != null){
//            node.displayData();
//            preOrder(node.left);
//            preOrder(node.right);
//        }
//    }
//    // Postorder traversal
//    public void postOrder(Node node){
//        if(node != null){
//            postOrder(node.left);
//            postOrder(node.right);
//            node.displayData();
//        }
//    }
//
////    public static void main(String[] args) {
//////        BinaryTree bst = new BinaryTree();
//////        bst.insert(50);
//////        bst.insert(70);
//////        bst.insert(15);
//////        bst.insert(35);
//////        bst.insert(30);
//////        bst.insert(31);
////        System.out.println("Inorder traversal of binary tree");
////        bst.inOrder(bst.root);
////        System.out.println();
//////        Node node = bst.find(16);
//////        System.out.println((node == null)? "Node not found" : String.valueOf(node.value));
////        System.out.println("Preorder traversal of binary tree");
////        bst.preOrder(bst.root);
////        System.out.println();
////        System.out.println("Postorder traversal of binary tree");
////        bst.postOrder(bst.root);
////        System.out.println();
////    }
//}