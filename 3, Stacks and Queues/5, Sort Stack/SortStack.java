// Write a program to sort a stack such that the smallest items are on the top.
// You can use an additional temporary stack,
// but you may not copy the elements into any other data structure (such as an array).
// The stack supports the following operation: push, pop, peek, isEmpty.

import java.util.ArrayList;
class SortStack{
    public static <E extends Comparable<E>> void sortStack(Stack<E> stack){
        if(stack.isEmpty()){
            return;
        }
        Stack<E> sortingStack = new Stack<E>();
        sortingStack.push(stack.pop());
        while(!stack.isEmpty()){
            E item = stack.pop();
            if(item.compareTo(sortingStack.peek()) < 0){
                while(!sortingStack.isEmpty()){
                    if(item.compareTo(sortingStack.peek()) > 0){
                        break;
                    }
                    stack.push(sortingStack.pop());
                }
                stack.push(item);
                while(!sortingStack.isEmpty()){
                    stack.push(sortingStack.pop());
                }
                sortStack(stack);
                return;
            }
            sortingStack.push(item);
        }
        while(!sortingStack.isEmpty()){
            stack.push(sortingStack.pop());
        }
    }

    public static void main(String[] args){
        Stack<String> stack0 = new Stack<String>();
        stack0.push("Kevin");
        stack0.push("Eunji");
        stack0.push("Hugh");
        stack0.push("Emma");
        sortStack(stack0);
        System.out.println(stack0.pop()+" "+stack0.pop()+" "+stack0.pop()+" "+stack0.pop());
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(22);
        stack.push(9);
        stack.push(80);
        sortStack(stack);
        System.out.println(stack.pop()+" "+stack.pop()+" "+stack.pop()+" "+stack.pop());
    }

    public static class Stack<E extends Comparable<E>>{
        private LinkedList<E> list = new LinkedList<E>();
        Stack(){}
        void push(E object){
            list.add(object);
        }
        E pop(){
            return list.removeTail().value;
        }
        E peek(){
            return list.tail.value;
        }
        boolean isEmpty(){
            if(list.head == null){
                return true;
            }
            return false;
        }
    }
    public static class LinkedList<E extends Comparable<E>>{
        Node<E> head, tail;
        LinkedList(){
            head = null;
            tail = null;
        }
        void add(E value){
            Node<E> newNode = new Node<E>(value, null, tail);
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        Node<E> removeTail(){
            if(tail == null){
                return null;
            }
            Node<E> cutTail = tail;
            tail = tail.prev;
            if(head == cutTail){
                head = null;
            }
            return cutTail;
        }
    }
    public static class Node<E extends Comparable<E>>{
        E value;
        Node<E> next, prev;
        Node(){
            value = null;
            next = null;
            prev = null;
        }
        Node(E value){
            this.value = value;
            next = null;
            prev = null;
        }
        Node(E value, Node<E> next, Node<E> prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}