import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TreeExample {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static class Tree{
        Node root;
        ArrayList<Integer> values;

        public Tree(){
            this.values = new ArrayList<>();
        }

        public void insertNode(int targetValue) {
            if (root == null) {
                root = new Node(targetValue);
                return;
            }
            Node curr = root;
            while (true){
                if (targetValue > curr.value){
                    if (curr.right == null){
                        curr.right = new Node(targetValue);
                        return;
                    } else {
                        curr = curr.right;
                    }
                } else if (targetValue < root.value){
                    if (curr.left == null){
                        curr.left = new Node(targetValue);
                        return;
                    } else {
                        curr = curr.left;
                    }
                }
            }
        }

        public void printBinaryTree(Node node, int level) {
            if (node != null) {
                printBinaryTree(node.left, level + 1);
                for (int i = 0; i < level; i++)
                    System.out.print("   ");
                System.out.println(node.value);
                printBinaryTree(node.right, level + 1);
            }
        }

        public int getHeight(Node node){
            if (node == null){
                return 0;
            } else {
                return 1 + Math.max(getHeight(node.left), getHeight(node.right));
            }
        }

        public boolean isBalanced(Node node){
            if (node == null){
                return true;
            }
            return (Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1
                    && isBalanced(node.left) && isBalanced(node.right));
        }

        public void preorder(Node node){
            if (node == null){
                return;
            }
            this.values.add(node.value);
            preorder(node.left);
            preorder(node.right);
        }

        public void rebuildTree(){
            if (!isBalanced(this.root)){
                preorder(this.root);
                Collections.sort(this.values);
                this.root = findNewRoot(0, values.size()-1);
            }
        }

        public Node findNewRoot(int start, int end){
            if (start > end){
                return null;
            }
            int mid = (start + end) / 2;
            Node node = new Node(values.get(mid));
            node.left = findNewRoot(start, mid - 1);
            node.right = findNewRoot(mid + 1, end);

            return node;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int buff = in.nextInt();
        Tree tree = new Tree();
        tree.insertNode(buff);
        while (true){
            buff = in.nextInt();
            if (buff == 0)
                break;
            tree.insertNode(buff);
        }
        tree.printBinaryTree(tree.root, 0);
        System.out.println(tree.isBalanced(tree.root) ? "balanced" : "unbalanced");
        tree.rebuildTree();
        tree.printBinaryTree(tree.root, 0);
        System.out.println(tree.isBalanced(tree.root) ? "balanced" : "unbalanced");
    }
}