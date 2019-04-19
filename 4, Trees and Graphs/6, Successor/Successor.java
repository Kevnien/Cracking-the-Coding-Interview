// Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in binary search tree.
// You may assume that each node has a link to its parent.

class Successor{
    public static <E> Node<E> successor(Node<E> node){
        Node<E> current;
        if(node.right != null){
            current = node.right;
            while(current.left != null){
                current = current.left;
            }
            return current;
        }
        current = node;
        if(current.parent == null){
            return null;
        }
        while(current == current.parent.right){
            current = current.parent;
            if(current.parent == null){
                return null;
            }
        }
        return current.parent;
    }

    public static void main(String[] args){
        Node<Integer> eight = new Node<Integer>(8, null);
        Node<Integer> four = new Node<Integer>(4, eight);
        Node<Integer> ten = new Node<Integer>(10, eight);
        Node<Integer> two = new Node<Integer>(2, four);
        Node<Integer> six = new Node<Integer>(6, four);
        Node<Integer> twenty = new Node<Integer>(20, ten);
        eight.left = four;
        eight.right = ten;
        four.left = two;
        four.right = six;
        ten.right = twenty;
        System.out.println(successor(four).value);
        System.out.println(successor(six).value);
        System.out.println(successor(twenty));
    }

    public static class Node<E>{
        Node<E> parent, left=null, right=null;
        E value;
        Node(E value, Node<E> parent){
            this.value = value;
            this.parent = parent;
        }
    }
}