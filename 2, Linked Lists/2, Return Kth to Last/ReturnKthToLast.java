// Implement an algorithm to find the kth to last element of a singly linked list

import node.Node;

class ReturnKthToLast{
    public static <E> E returnKthToLast(Node<E> linkedlist, int k){
        int length = 0;
        Node current = linkedlist;
        while(current != null){
            length++;
            current = current.next;
        }
        int index = 0;
        current = linkedlist;
        int target = length - k;
        while(index < target){
            current = current.next;
            index++;
        }
        return (E)current.value;
    }

    public static void main(String[] args){
        Node<String> linkedlist = new Node<String>("Kevin");
        Node<String> current = linkedlist;
        current.next = new Node<String>("Eunji");
        current = current.next;
        current.next = new Node<String>("Gayle");
        current = current.next;
        current.next = new Node<String>("Chucky");
        current = current.next;
        System.out.println(returnKthToLast(linkedlist, 3));
    }
}