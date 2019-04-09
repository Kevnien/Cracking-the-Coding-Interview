// Given two (singly) linked lists, 
// determine if the two lists intersect. 
// Return the intersecting node. 
// Note that the intersection is defined based on reference, not value.
// That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second list, 
// then they are intersecting.

class Intersection{
    public static <E> Node<E> intersection(LinkedList<E> list1, LinkedList<E> list2){
        int length1=0, length2=0;
        Node<E> last1, last2, current=list1.head;
        if(current != null){
            length1++;
            while(current.next != null){
                length1++;
                current = current.next;
            }
        }
        last1 = current;
        current = list2.head;
        if(current != null){
            length2++;
            while(current.next != null){
                length2++;
                current = current.next;
            }
        }
        last2 = current;
        if(last1 != last2){
            return null;
        }
        if(length1 > length2){
            length1 -= length2;
            current = list1.head;
        }else{
            length1 = length2 - length1;
            current = list2.head;
        }
        for(int i=0; i<length1; i++){
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args){
        Node<Integer> a = new Node<Integer>(0);
        Node<Integer> b = new Node<Integer>(0);
        Node<Integer> c = new Node<Integer>(0);
        Node<Integer> d = new Node<Integer>(0);
        Node<Integer> e = new Node<Integer>(0);
        Node<Integer> f = new Node<Integer>(0);
        LinkedList<Integer> list1 = new LinkedList<Integer>(a);
        LinkedList<Integer> list2 = new LinkedList<Integer>(d);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(intersection(list1, list2));
        System.out.println(d);
    }

    public static class LinkedList<E>{
        Node<E> head;
        LinkedList(){
            head = null;
        }
        LinkedList(Node<E> node){
            head = node;
        }
    }

    public static class Node<E>{
        E value;
        Node<E> next;
        Node(){
            value = null;
            next = null;
        }
        Node(E value){
            this.value = value;
            next = null;
        }
    }
}