// Implement an algorithm to delete a node in the middle
// (i.e. any node but the first and last node, not necesarily the exact middle)
// of a singly linked list, given only access to that node.
// EXAMPLE
// Input: the node c from the linked list a -> b -> c -> d -> e -> f
// Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f

class DeleteMiddleNode{
    public static <E> void deleteMiddleNode(SinglyLinkedList<E> linkedlist, Node<E> target){
        Node<E> current = linkedlist.head;
        while(current != null){
            if(current.next.next == null){
                return;
            }
            if(current.next == target){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args){
        SinglyLinkedList<String> linkedlist = new SinglyLinkedList<String>();
        linkedlist.head = new Node<String>("Kevin");
        Node<String> eunji = new Node<String>("Eunji");
        Node<String> chucky = new Node<String>("Chucky");
        Node<String> gayle = new Node<String>("Gayle");
        linkedlist.head.next = eunji;
        eunji.next = chucky;
        chucky.next = gayle;
        linkedlist.print();
        deleteMiddleNode(linkedlist, chucky);
        linkedlist.print();
    }

    public static class SinglyLinkedList<E>{
        Node<E> head;
        public SinglyLinkedList(E value){
            head = new Node(value);
        }
        public SinglyLinkedList(){
            head = null;
        }
        public void print(){
            Node<E> current = head;
            while(current != null){
                System.out.print(current.value+" ");
                current = current.next;
            }
            System.out.println();
        }

    }
    
    public static class Node<E>{
        public E value;
        public Node next;
        Node(E value){
            this.value = value;
            next = null;
        }
    }
}