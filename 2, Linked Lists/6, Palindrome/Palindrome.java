// Implement a function to check if a linked list is a palindrome.

class Palindrome{
    public static <E> boolean palindrome(LinkedList<E> linkedlist){
        int length = 0;
        Node<E> current = linkedlist.head;
        while(current != null){
            length++;
            current = current.next;
        }
        int point = length/2;
        if(length%2 == 1){
            point++;
        }
        current = linkedlist.head;
        int index = 0;
        while(index++ < point){
            current = current.next;
        }
        Node<E> reverser = new Node<E>(current.value);
        current = current.next;
        while(current != null){
            Node<E> next = new Node<E>(current.value);
            next.next = reverser;
            reverser = next;
            current = current.next;
        }
        LinkedList<E> secondHalf = new LinkedList(reverser);
        current = secondHalf.head;
        Node<E> pointer = linkedlist.head;
        while(current != null){
            if(current.value != pointer.value){
                return false;
            }
            current = current.next;
            pointer = pointer.next;
        }
        return true;
    }

    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<Integer>(0);
        list1.head.next = new Node<Integer>(1);
        list1.head.next.next = new Node<Integer>(2);
        list1.head.next.next.next = new Node<Integer>(2);
        list1.head.next.next.next.next = new Node<Integer>(1);
        list1.head.next.next.next.next.next = new Node<Integer>(0);
        list1.head.next.next.next.next.next.next = new Node<Integer>(0);
        System.out.println(palindrome(list1));
    }

    public static class LinkedList<T>{
        Node<T> head;
        LinkedList(){
            head = null;
        }
        LinkedList(Node<T> node){
            head = node;
        }
        LinkedList(T value){
            head = new Node<T>(value);
        }
    }

    public static class Node<T>{
        T value;
        Node<T> next;
        Node(){
            value = null;
            next = null;
        }
        Node(T value){
            this.value = value;
            next = null;
        }
    }
}