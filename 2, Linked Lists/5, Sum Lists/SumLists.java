// You have two numbers represented by a linked list,
// where each node contains a single digit.
// The digits are stored in reverse order,
// such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list

// EXAMPLE
// Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
// Output: 2 -> 1 -> 9. That is, 912.

// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.

// EXAMPLE
// Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
// Output: 9 -> 1 -> 2. That is, 912.

import java.util.ArrayList;
class SumLists{
    public static LinkedList<Integer> sumLists(LinkedList<Integer> number1, LinkedList<Integer> number2){
        int carry = 0;
        Node<Integer> digit1 = number1.head;
        Node<Integer> digit2 = number2.head;
        LinkedList<Integer> answer = new LinkedList<Integer>();
        answer.head = new Node<Integer>();
        Node<Integer> answerNode = answer.head;
        Node<Integer> lagNode = answer.head;
        while(digit1!=null && digit2!=null){
            answerNode.next = new Node<Integer>();
            int current = digit1.value + digit2.value + carry;
            if(current > 9){
                carry = 1;
                current = current-10;
            }else{
                carry = 0;
            }
            answerNode.value = current;
            lagNode = answerNode;
            answerNode = answerNode.next;
            digit1 = digit1.next;
            digit2 = digit2.next;
        }
        Node<Integer> digit = digit1;
        if(digit2 != null){
            digit = digit2;
        }
        while(digit != null){
            answerNode.next = new Node<Integer>();
            answerNode.value = digit.value + carry;
            carry = 0;
            if(answerNode.value == 10){
                answerNode.value = 0;
                carry = 1;
                answerNode.next = new Node<Integer>(1);
                answerNode = answerNode.next;
                answerNode.next = new Node<Integer>();
            }
            lagNode = answerNode;
            answerNode = answerNode.next;
            digit = digit.next;
        }
        lagNode.next = null;
        return answer;
    }

    public static LinkedList<Integer> sumListsForward(LinkedList<Integer> number1, LinkedList<Integer> number2){
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        Node<Integer> current = number1.head;
        while(current != null){
            array1.add(current.value);
            current = current.next;
        }
        current = number2.head;
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        while(current != null){
            array2.add(current.value);
            current = current.next;
        }
        LinkedList<Integer> reverse1 = new LinkedList<Integer>();
        reverse1.head = new Node<Integer>(array1.get(array1.size()-1));
        current = reverse1.head;
        for(int i=array1.size()-2; i>-1; i--){
            current.next = new Node<Integer>(array1.get(i));
            current = current.next;
        }
        LinkedList<Integer> reverse2 = new LinkedList<Integer>();
        reverse2.head = new Node<Integer>(array2.get(array2.size()-1));
        current = reverse2.head;
        for(int i=array2.size()-2; i>-1; i--){
            current.next = new Node<Integer>(array2.get(i));
            current = current.next;
        }
        LinkedList<Integer> reverse = sumLists(reverse1, reverse2);
        ArrayList<Integer> array = new ArrayList<Integer>();
        current = reverse.head;
        while(current != null){
            array.add(current.value);
            current = current.next;
        }
        LinkedList<Integer> answer = new LinkedList<Integer>(array.get(array.size()-1));
        current = answer.head;
        for(int i=array.size()-2; i>-1; i--){
            current.next = new Node<Integer>(array.get(i));
            current = current.next;
        }
        return answer;
    }

    public static void main(String[] args){
        LinkedList<Integer> number1 = new LinkedList<Integer>(7);
        number1.head.next = new Node<Integer>(1);
        number1.head.next.next = new Node<Integer>(6);
        LinkedList<Integer> number2 = new LinkedList<Integer>(5);
        number2.head.next = new Node<Integer>(9);
        number2.head.next.next = new Node<Integer>(2);
        LinkedList<Integer> answer = sumLists(number1, number2);
        answer.print();
        number2.head.next.next = null;
        answer = sumLists(number1, number2);
        answer.print();
        number1.head.next = null;
        answer = sumLists(number1, number2);
        answer.print();
        number1 = new LinkedList<Integer>(6);
        number1.head.next = new Node<Integer>(1);
        number1.head.next.next = new Node<Integer>(7);
        number2 = new LinkedList<Integer>(2);
        number2.head.next = new Node<Integer>(9);
        number2.head.next.next = new Node<Integer>(5);
        answer = sumListsForward(number1, number2);
        answer.print();
    }

    public static class LinkedList<T>{
        public Node<T> head;
        LinkedList(){
            head = null;
        }
        LinkedList(T value){
            head = new Node<T>(value);
        }
        void print(){
            Node<T> current = head;
            while(current != null){
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static class Node<T>{
        public T value;
        public Node<T> next;
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