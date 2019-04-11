// Given a sorted (increasing order) array with unique integer elements, 
// write an algorithm to create a binary search tree with minimal height.

import java.util.LinkedList;
class MinimalTree{
    public static int count = 0;
    public static Node minimalTree(int[] array){
        if(array.length == 0){
            return null;
        }
        return minimalTree(array, 0, array.length-1);
    }

    public static Node minimalTree(int[] array, int beg, int end){
        count++;
        if(end < beg){
            return null;
        }
        int mid = (beg+end)/2;
        Node node = new Node(array[mid]);
        node.left = minimalTree(array, beg, mid-1);
        node.right = minimalTree(array, mid+1, end);
        return node;
    }

    public static void main(String[] args){
        int[] array = {2,4,6,8,10,20};
        Node minimalBST = minimalTree(array);
        minimalBST.print();
    }

    public static class Node{
        int value;
        Node left=null, right=null;
        Node(int value){
            this.value = value;
        }
        void print(){
            Node current = this;
            LinkedList<Node> rights = new LinkedList<Node>();
            while(current != null){
                rights.add(current);
                current = current.right;
            }
            current = this;
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(current);
            while(queue.size() > 0){
                current = queue.removeFirst();
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
                System.out.print(current.value+", ");
                if(current == rights.peek()){
                    System.out.println();
                    rights.removeFirst();
                }
            }
        }
    }
}