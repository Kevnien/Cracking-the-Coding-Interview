// Given a circular linked list, 
// implement an algorithm that returns the node at the beginning of the loop.
// DEFINITION
// Cicular linked list: A (correupt) linked list in which a node's next pointer points to an earlier node, 
// so as to make a loop in the linked list.
// EXAMPLE
// Input: A -> B -> C -> D -> E -> C
// Output: C

class LoopDetection{
    public static <E> Node<E> loopDetection(LinkedList<E> loopedList){
        Node<E> slow = loopedList.head;
        Node<E> fast = loopedList.head;
        while(slow!=null && fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast==null){
                return null;
            }
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }
        if(slow==null || fast==null){
            return null;
        }
        slow = loopedList.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        Node<Character> a = new Node<Character>('a');
        Node<Character> b = new Node<Character>('b');
        Node<Character> c = new Node<Character>('c');
        Node<Character> d = new Node<Character>('d');
        Node<Character> e = new Node<Character>('e');
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;
        LinkedList<Character> loopedList = new LinkedList<Character>(a);
        System.out.println(loopDetection(loopedList));
        System.out.println(c);
    }

    public static class LinkedList<E>{
        Node<E> head;
        LinkedList(Node<E> node){
            head = node;
        }
    }
    public static class Node<E>{
        E value;
        Node<E> next;
        Node(E value){
            this.value = value;
            next = null;
        }
    }
}