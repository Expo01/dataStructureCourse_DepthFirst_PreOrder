
package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>(); //empty arrayList created to hold values of traversed Nodes

        class Traverse { //class has not been called at this point. just exists.
            Traverse(Node currentNode) {
                results.add(currentNode.value); // value of node addeed to ArrayList
                if (currentNode.left != null) { // recursively checks for left value and adds value until leaf is found
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {  //items from left search have been popped off to preceding node and
                    // check for right  recursively
                    new Traverse(currentNode.right);

                    //makes the way back up the tree
                }
            }
        }

        new Traverse(root); //new keyword must be used since we are creating an instance of Traverse class through
         // the Traverse constructor. this is the first time the Traverse class has actually been called and passed the
        // root node.
        return results;
        // once all items have been added, the ArrayList of values is returnedd

}

