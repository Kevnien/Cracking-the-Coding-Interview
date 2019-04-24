// Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
// Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.

class FirstCommonAncestor{
    public static <E> Node<E> firstCommonAncestor(Node<E> one, Node<E> two){
        Node<E> traverser = one;
        while(traverser != null){
            traverser.visited = true;
            traverser = traverser.parent;
        }
        traverser = two;
        while(traverser != null){
            if(traverser.visited == true){
                return traverser;
            }
            traverser = traverser.parent;
        }
        return null;
    }

    public static void main(String[] args){
        Node<Integer> ten = new Node<Integer>(10, null);
        Node<Integer> five = new Node<Integer>(5, ten);
        Node<Integer> twelve = new Node<Integer>(12, five);
        Node<Integer> twenty = new Node<Integer>(20, ten);
        Node<Integer> seven = new Node<Integer>(7, twenty);
        Node<Integer> three = new Node<Integer>(3, twenty);
        Node<Integer> nine = new Node<Integer>(9, three);
        Node<Integer> eighteen = new Node<Integer>(18, three);
        System.out.println(firstCommonAncestor(eighteen, seven).value);
    }

    public static class Node<E>{
        E value;
        Node<E> parent;
        Node<E> left=null, right=null;
        boolean visited = false;
        Node(E value, Node<E> parent){
            this.value = value;
            this.parent = parent;
        }
    }
}