// Implement a function to check if a binary search tree is a binary search tree

import java.util.LinkedList;
class ValidateBST{
    public static <E extends Comparable<E>> boolean validateBST(Node<E> root){
        LinkedList<E> list = new LinkedList<E>();
        inOrderTraversal(root, list);
        if(isSorted(list)){
            return true;
        }
        return false;
    }

    public static <E extends Comparable<E>> boolean isSorted(LinkedList<E> list){
        E previous = list.removeFirst();
        E next=list.removeFirst();
        while(list.size() > 0){
            if(next.compareTo(previous) < 0){
                return false;
            }
            previous = next;
            next = list.removeFirst();
        }
        return true;
    }

    public static <E extends Comparable<E>> void inOrderTraversal(Node<E> node, LinkedList<E> list){
        if(node != null){
            inOrderTraversal(node.left, list);
            list.add(node.value);
            inOrderTraversal(node.right, list);
        }
    }

    public static void main(String[] args){
        Node<Integer> eight = new Node<Integer>(8);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> ten = new Node<Integer>(10);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> twenty = new Node<Integer>(20);
        Node<Integer> twelve = new Node<Integer>(12);
        eight.left = four;
        eight.right = ten;
        four.left = two;
        four.right = six;
        ten.right = twenty;
        System.out.println(validateBST(eight));
        four.right = twelve;
        System.out.println(validateBST(eight));
    }

    public static class Node<E extends Comparable<E>>{
        E value;
        Node left, right;
        Node(E value){
            this.value = value;
            left = null;
            right = null;
        }
        int compareTo(Node<E> node){
            return value.compareTo(node.value);
        }
    }
}