// Imagine a (literal) stack of plates.
// If the stack gets too high, it might topple.
// Therefore, in real life, 
// we would likely start a new stack when the previous stack exceeds some threshold.
// Implement a data structure SetOfStacks that mimics this.
// SetOfStacks should be composed of several stacks and should create a new stack once the previous on exceeds capacity.
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
// (that is, pop() should return the same values as it would if there were just a single stack).
// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

import java.util.ArrayList;
class StackOfPlates{
    public static class SetOfStacks<E>{
        Stack<E> head;
        Stack<E> tail;
        int threshold;
        int amountOfStacks;
        SetOfStacks(int threshold){
            head = new Stack<E>(threshold);
            tail = head;
            this.threshold = threshold;
            amountOfStacks = 1;
        }
        void push(E object){
            if(!tail.push(object)){
                Stack<E> newStack = new Stack<E>(threshold);
                tail.next = newStack;
                newStack.previous = tail;
                tail = newStack;
                amountOfStacks++;
                push(object);
            }
        }
        E pop(){
            if(tail == null){
                return null;
            }
            E object = tail.pop();
            if(object == null){
                tail = tail.previous;
                amountOfStacks--;
                return pop();
            }
            return object;
        }
        E popAt(int index){
            if(index >= amountOfStacks || index<0){
                return null;
            }
            Stack<E> stack = head;
            for(int i=0; i<index; i++){
                stack = stack.next;
            }
            E object = stack.pop();
            if(object == null){
                if(stack.next != null){
                    stack.next.previous = stack.previous;
                }else{
                    tail = stack.previous;
                }
                if(stack.previous != null){
                    stack.previous.next = stack.next;
                }else{
                    head = stack.next;
                }
                amountOfStacks--;
            }
            return object;
        }
    }

    public static void main(String[] args){
        SetOfStacks<String> stackOfPlates = new SetOfStacks<>(2);
        stackOfPlates.push("Kevin");
        stackOfPlates.push("Eunji");
        stackOfPlates.push("Emma");
        stackOfPlates.push("Hugh");
        System.out.println(stackOfPlates.pop()+" "+stackOfPlates.pop()+" "+stackOfPlates.pop()+" "+stackOfPlates.pop());
        stackOfPlates.push("Kevin");
        stackOfPlates.push("Eunji");
        stackOfPlates.push("Emma");
        stackOfPlates.push("Hugh");
        System.out.println(stackOfPlates.popAt(0)+" "+stackOfPlates.popAt(0)+" "+stackOfPlates.popAt(0)+" "+stackOfPlates.popAt(0));
    }

    public static class Stack<E>{
        int index;
        int max;
        ArrayList<E> array;
        Stack<E> next;
        Stack<E> previous;
        Stack(int threshold){
            index = 0;
            max = threshold;
            array = new ArrayList<E>(threshold);
            next = null;
            previous = null;
        }
        boolean push(E object){
            if(index == max){
                return false;
            }
            array.add(index++, object);
            return true;
        }
        E pop(){
            if(index == 0){
                return null;
            }
            return array.get(--index);
        }
    }
}