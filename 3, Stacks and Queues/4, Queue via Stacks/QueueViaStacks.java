// Implement a MyQueue class which implements a queue using two stacks.

import java.util.ArrayList;
class QueueViaStacks{
    public static class MyQueue<E>{
        Stack<E> left, right, current;
        boolean isQueue;
        MyQueue(){
            left = new Stack<E>();
            right = new Stack<E>();
            current = left;
            isQueue = false;
        }
        void push(E object){
            if(isQueue){
                Stack<E> other = left;
                if(current == left){
                    other = right;
                }
                E item = current.pop();
                while(item != null){
                    other.push(item);
                    item = current.pop();
                }
                isQueue = false;
                current = other;
            }
            current.push(object);
        }
        E pop(){
            if(isQueue){
                return current.pop();
            }
            Stack<E> other = right;
            if(current == right){
                other = left;
            }
            E item = current.pop();
            while(item != null){
                other.push(item);
                item = current.pop();
            }
            isQueue = true;
            current = other;
            return current.pop();
        }
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue<String>();
        queue.push("Chucky");
        queue.push("Kevin");
        queue.push("Eunji");
        System.out.println(queue.pop());
        queue.push("Hugh");
        queue.push("Emma");
        System.out.println(queue.pop()+" "+queue.pop()+" "+queue.pop()+" "+queue.pop()+" "+queue.pop());
    }

    public static class Stack<E>{
        int index;
        ArrayList<E> array;
        int max;
        Stack(){
            index = 0;
            max = 10;
            array = new ArrayList<E>(max);
        }
        void push(E object){
            if(index == max){
                max *= 2;
                array.ensureCapacity(max);
            }
            array.add(index++, object);
        }
        E pop(){
            if(index == 0){
                return null;
            }
            return array.get(--index);
        }
    }
}