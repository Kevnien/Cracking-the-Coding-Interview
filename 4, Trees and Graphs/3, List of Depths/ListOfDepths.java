// Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
// (e.g., if you have a tree with depth D, you'll have D linked lists).

import java.util.LinkedList;
class ListOfDepths{
    public static <E> LinkedList<LinkedList<Node<E>>> listOfDepths(Node<E> root){
        int cap = 1;
        int count = 0;
        LinkedList<LinkedList<Node<E>>> list = new LinkedList<LinkedList<Node<E>>>();
        LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
        queue.add(root);
        list.add(new LinkedList<Node<E>>());
        while(queue.size() > 0){
            Node<E> current = queue.removeFirst();
            if(current != null){
                list.peekLast().add(current);
                queue.add(current.left);
                queue.add(current.right);
            }
            count++;
            if(count == cap){
                count = 0;
                cap *= 2;
                list.add(new LinkedList<Node<E>>());
            }
        }
        return list;
    }

    public static void main(String[] args){
        Node<Integer> eight = new Node(8);
        Node<Integer> four = new Node(4);
        Node<Integer> ten = new Node(10);
        Node<Integer> two = new Node(2);
        Node<Integer> six = new Node(6);
        Node<Integer> twenty = new Node(20);
        eight.left = four;
        eight.right = ten;
        four.left = two;
        four.right = six;
        ten.right = twenty;
        LinkedList<LinkedList<Node<Integer>>> list = listOfDepths(eight);
        print(list);
    }

    public static <E> void print(LinkedList<LinkedList<Node<E>>> list){
        LinkedList<Node<E>> currentDepth = list.removeFirst();
        int depth = 1;
        while(currentDepth != null){
            System.out.print("Depth "+depth+": ");
            Node<E> currentNode;
            if(currentDepth.size() > 0){
                currentNode = currentDepth.removeFirst();
            }else{
                return;
            }
            while(currentNode != null){
                System.out.print(currentNode.value+", ");
                if(currentDepth.size() > 0){
                    currentNode = currentDepth.removeFirst();
                }else{
                    currentNode = null;
                }
            }
            depth++;
            if(list.size() > 0){
                currentDepth = list.removeFirst();
                System.out.println();
            }else{
                currentDepth = null;
            }
        }
    }

    public static class Node<E>{
        E value;
        Node<E> left=null, right=null;
        Node(E value){
            this.value = value;
        }
    }
}