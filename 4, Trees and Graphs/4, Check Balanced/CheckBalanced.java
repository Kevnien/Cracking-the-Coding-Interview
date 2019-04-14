// Implement a function to check if a binary tree is balanced.
// For the purposes of this question, 
// a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

class CheckBalanced{
    public static <E> boolean checkBalanced(Node<E> root){
        if(root == null){
            return true;
        }
        if(checkHeight(root) == Integer.MIN_VALUE){
            return false;
        }
        return true;
    }
    
    public static <E> int checkHeight(Node<E> node){
        if(node == null){
            return -1;
        }
        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if(Math.abs(left - right) > 1){
            return Integer.MIN_VALUE;
        }
        if(left==Integer.MIN_VALUE || right==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(left > right){
            return left + 1;
        }
        return right + 1;
    }

    public static void main(String[] args){
        Node<Integer> nine = new Node<Integer>(9);
        Node<Integer> eight = new Node<Integer>(8);
        Node<Integer> seven = new Node<Integer>(7);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> five = new Node<Integer>(5);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> two = new Node<Integer>(2);
        eight.right = seven;
        eight.left = nine;
        seven.right = three;
        three.right = two;
        // seven.left = four;
        // nine.right = five;
        // nine.left = six;
        System.out.println(checkBalanced(eight));
    }

    public static class Node<E>{
        E value;
        Node<E> left=null, right=null;
        Node(E value){
            this.value = value;
        }
    }
}