// Given a sorted (increasing order) array with unique integer elements, 
// write an algorithm to create a binary search tree with minimal height.

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
    }

    public static class Node{
        int value;
        Node left=null, right=null;
        boolean visited = false;
        Node(int value){
            this.value = value;
        }
        void print(){
            int levels = 0;
            Node current = this;
            while(current != null){
                levels++;
                current = current.left;
            }
            int level = 0;
            current = this;
        }
    }
}