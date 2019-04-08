// Write code to partition a linked list around a value x, 
// such that all nodes less than x come before all nodes greater than or equal to x.
// If x is contained within the list, the values of x only need to be after the elements less than x.
// The partition element x can appear anywhere in the "right partition";
// it does not need to appear between the left and right partitions.
// EXAMPLE
// Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
// Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

class Partition{
    public static void partition(LinkedList linkedlist, Integer target){
        LinkedList answer = new LinkedList();
        LinkedList right = new LinkedList();
        Node current = linkedlist.head;
        Node answerPointer = null;
        Node rightPointer = null;
        while(current != null){
            if(current.value < target){
                if(answerPointer == null){
                    answer.head = new Node(current.value);
                    answerPointer = answer.head;
                }else{
                    answerPointer.next = new Node(current.value);
                    answerPointer = answerPointer.next;
                }
            }else{
                if(rightPointer == null){
                    right.head = new Node(current.value);
                    rightPointer = right.head;
                }else{
                    rightPointer.next = new Node(current.value);
                    rightPointer = rightPointer.next;
                }
            }
            current = current.next;
        }
        answerPointer.next = right.head;
        linkedlist.head = answer.head;
    }

    public static void main(String[] args){
        LinkedList linkedlist = new LinkedList(3);
        Node current = linkedlist.head;
        current.next = new Node(5);
        current = current.next;
        current.next =  new Node(8);
        current = current.next;
        current.next =  new Node(5);
        current = current.next;
        current.next =  new Node(10);
        current = current.next;
        current.next =  new Node(2);
        current = current.next;
        current.next =  new Node(1);
        linkedlist.print();
        partition(linkedlist, 5);
        linkedlist.print();
    }

    public static class LinkedList{
        Node head;
        LinkedList(){
            head = null;
        }
        LinkedList(Integer value){
            head = new Node(value);
        }
        LinkedList(Node node){
            head = node;
        }
        void print(){
            Node current = head;
            while(current != null){
                System.out.print(current.value+" -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static class Node{
        Integer value;
        Node next;
        Node(){
            value = null;
            next = null;
        }
        Node(Integer value){
            this.value = value;
            next = null;
        }
        Node(Integer value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}