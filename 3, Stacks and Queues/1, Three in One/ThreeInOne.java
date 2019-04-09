// Implement 3 stacks using 1 array

import java.util.ArrayList;
class ThreeInOne{
    public static class Stack<E>{
        private int[] stackPointers = new int[3];
        private int[] maxes = new int[3];
        private int[] mins = new int[3];
        private ArrayList<E> array;
        Stack(int size){
            array = new ArrayList<E>(size*3);
            stackPointers[0] = 0;
            stackPointers[1] = size/3;
            stackPointers[2] = (size/3)*2;
            mins[0] = 0;
            mins[1] = size/3;
            mins[2] = (size/3)*2;
            maxes[0] = size/3;
            maxes[1] = (size/3)*2;
            maxes[2] = size;
        }
        boolean push(int stack, E value){
            if(stackPointers[stack] == maxes[stack]){
                System.out.println("Stack is full.");
                return false;
            }
            array.add(stackPointers[stack]++, value);
            return true;
        }
        E pop(int stack){
            if(stackPointers[stack] == mins[stack]){
                return null;
            }
            return array.get(--stackPointers[stack]);
        }
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack<String>(6);
        System.out.println(stack.push(0, "Kevin"));
        System.out.println(stack.push(0, "Eunji"));
        System.out.println(stack.push(1, "Andy"));
        System.out.println(stack.push(1, "Dom"));
        System.out.println(stack.push(2, "Hugh"));
        System.out.println(stack.push(2, "Emma"));
        System.out.println(stack.push(0, "Chucky"));
        System.out.println(stack.pop(0)+" "+stack.pop(0));
        System.out.println(stack.push(0, "Chucky"));
    }
}