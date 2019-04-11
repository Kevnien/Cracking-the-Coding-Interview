// Given a sorted (increasing order) array with unique integer elements, 
// write an algorithm to create a binary search tree with minimal height.

import java.util.LinkedList;
class MinimalTree{
    public static Node minimalTree(int[] array){
        if(array.length == 0){
            return null;
        }
        return minimalTree(array, 0, array.length-1);
    }

    public static Node minimalTree(int[] array, int beg, int end){
        if(end < beg){
            return null;
        }
        int mid = (beg+end)/2;
        Node node = new Node(array[mid]);
        node.left = minimalTree(array, beg, mid-1);
        node.right = minimalTree(array, mid+1, end);
        return node;
    }

    public static void main(String[] args){
        int[] array = {2,4,6,8,10,20};
        Node minimalBST = minimalTree(array);
        minimalBST.print();
    }

    public static class Node{
        int value;
        Node left=null, right=null;
        boolean visited = false;
        Node(int value){
            this.value = value;
        }
        void print(){
            LinkedList<Node> queue = new LinkedList<Node>();
            int levels = 0;
            Node current = this;
            while(current != null){
                levels++;
                current = current.left;
            }
            LinkedList<Integer> tabs = getTabs(levels);
            String[] strings = new String[levels];
            for(int j=0; j<levels; j++){
                strings[j] = "";
                for(int i=0; i<tabs.size(); i++){
                    strings[j] += "   ";
                }
            }
            current = this;
            queue.add(current);
            int count = 0;
            int cap = 1;
            int stringsIndex = 0;
            while(queue.size() > 0){
                current = queue.remove();
                queue.add(current.left);
                queue.add(current.right);
                String toAdd = Integer.toString(current.value);
                int index = 3*tabs.removeFirst();
                int stop = index+toAdd.length();
                int toAddIndex = 0;
                char[] charArray = strings[stringsIndex].toCharArray();
                for(; index<stop; index++){
                    charArray[index] = toAdd.charAt(toAddIndex++);
                }
                strings[stringsIndex] = new String(charArray);
                count++;
                if(count == cap){
                    count = 0;
                    cap *= 2;
                    System.out.println(strings[stringsIndex++]);
                }
            }
        }
        LinkedList<Integer> getTabs(int levels){
            LinkedList<Integer> answer = new LinkedList<Integer>();
            int amount = 0;
            int rowAmount = 1;
            int level = 1;
            while(level <= levels){
                amount += rowAmount;
                level++;
                rowAmount *= 2;
            }
            getTabs(answer, 0, amount);
            return answer;
        }
        void getTabs(LinkedList<Integer> list, int beg, int end){
            if(end < beg){
                return;
            }
            int mid = (beg+end)/2;
            list.add(mid);
            getTabs(list, beg, mid-1);
            getTabs(list, mid+1, end);
        }
    }
}