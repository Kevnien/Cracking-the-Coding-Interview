import java.util.HashMap;

class RemoveDups{
    public static void removeDups(LinkedList linkedlist){
        HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
        Node current = linkedlist.head;
        while(current != null){
            if(hashmap.get(current.value) == null){
                hashmap.put(current.value, true);
            }else{
                current.previous.next = current.next;
            }
            current = current.next;
        }
        System.out.println("Removed all duplicates in Linked List.");
    }

    public static void main(String[] args){
        LinkedList linkedlist = new LinkedList(0);
        linkedlist.add(1);
        linkedlist.add(1);
        linkedlist.print();
        removeDups(linkedlist);
        linkedlist.print();
    }
    
    public static class LinkedList{
        public Node head;
        public Node tail;
        
        public LinkedList(int number){
            head = new Node(number);
            tail = head;
        }
        
        public void print(){
            Node current = this.head;
            while(current != null){
                System.out.println(current.value);
                current = current.next;
            }
        }

        public void add(int number){
            Node newNode = new Node(number);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
    }

    public static class Node{
        int value;
        Node next;
        Node previous;
        public Node(int value){
            this.value = value;
            next = null;
            previous = null;
        }
    }
}