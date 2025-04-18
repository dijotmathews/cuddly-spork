package dsa.tree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(7);
        tree.insert(5);
        tree.insert(11);
        tree.insert(2);
        tree.insert(1);

        tree.inorder();

        tree.preorder();

    }
}
