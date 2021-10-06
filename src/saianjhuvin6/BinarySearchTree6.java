package saianjhuvin6;

import java.util.Objects;

public class BinarySearchTree6 {
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
    BinarySearchTree6()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(Obj key)
    {
        root = insertRec(root, key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree6 that = (BinarySearchTree6) o;
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


    // This method mainly calls InorderRec()
    public void inorder()
    {
        inorderRec(root);
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



    // Driver Code
//    public static void main(String[] args)
//    {
//        BinarySearchTree6 tree = new BinarySearchTree6();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//
//        // print inorder traversal of the BST
//        tree.inorder();
//    }
}
