// How would you design a stack which, 
// in addition to push and pop, 
// has a function min which returns the minimum element?
// Push, pop, and min should all operate in O(1) time.

import java.util.ArrayList;
class StackMin{
    public static class MinStack{
        int index;
        int size;
        ArrayList<Integer> array;
        Stack minimums;
        MinStack(){
            index = 0;
            array = new ArrayList<Integer>();
            size = 10;
            minimums = new Stack();
        }
        void push(Integer number){
            if(index == size){
                size = size*2;
                array.ensureCapacity(size);
            }
            if(index == 0){
                minimums.push(number);
            }else if(minimums.peek() >= number){
                minimums.push(number);
            }
            array.add(index++, number);
        }
        Integer pop(){
            if(index == 0){
                return null;
            }
            if(array.get(index-1) == minimums.peek()){
                minimums.pop();
            }
            return array.remove(--index);
        }
        Integer min(){
            return minimums.peek();
        }
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(10);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    public static class Stack{
        int index = 0;
        int size = 10;
        ArrayList<Integer> array;
        Stack(){
            array = new ArrayList<Integer>();
        }
        void push(Integer number){
            if(index == size){
                size *= 2;
                array.ensureCapacity(size);
            }
            array.add(index++, number);
        }
        Integer pop(){
            if(index == 0){
                return null;
            }
            return array.get(--index);
        }
        Integer peek(){
            if(index==0){
                return null;
            }
            return array.get(index-1);
        }
    }
}