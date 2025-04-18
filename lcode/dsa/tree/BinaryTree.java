package dsa.tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}


public class BinaryTree {

    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node subTreeRoot, int data) {
        if(subTreeRoot == null) 
            subTreeRoot = new Node(data);
        else if(data < subTreeRoot.data) {
            subTreeRoot.left = insertRec(subTreeRoot.left, data);
        }else if(data > subTreeRoot.data) {
            subTreeRoot.right = insertRec(subTreeRoot.right, data);
        }

        return subTreeRoot; 
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    public void inorderRec(Node root){
        if(root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    public void preorderRec(Node root){
        if(root != null) {
            System.out.print(root.data + " ");
            inorderRec(root.left);
            inorderRec(root.right);
        }
    }

}
