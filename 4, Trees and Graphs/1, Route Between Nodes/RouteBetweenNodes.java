// Given a directed graph,
// design an algorithm to find out whether there is a route between two nodes.

import java.util.LinkedList;
class RouteBetweenNodes{
    public static <E> boolean routeBetweenNodes(Node<E> one, Node<E> two){
        if(dfs(one, two)){
            return true;
        }
        if(dfs(two, one)){
            return true;
        }
        return false;
    }
    
    public static <E> boolean dfs(Node<E> one, Node<E> two){
        LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
        queue.add(one);
        while(queue.size()>0){
            Node<E> node = queue.remove();
            if(visit(node, two)){return true;}
            node.visited = true;
            for(int i=0; i<node.adjacents.length; i++){
                Node<E> adjacent = (Node<E>)(node.adjacents[i]);
                if(adjacent.visited){
                    continue;
                }
                queue.add(adjacent);
            }
        }
        return false;
    }

    public static <E> boolean visit(Node<E> one, Node<E> two){
        if(one == two){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Node<Integer> zero = new Node<Integer>(0);
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> five = new Node<Integer>(5);
        zero.addAdjacentNode(one);
        zero.addAdjacentNode(four);
        zero.addAdjacentNode(five);
        one.addAdjacentNode(three);
        one.addAdjacentNode(four);
        three.addAdjacentNode(two);
        three.addAdjacentNode(four);
        two.addAdjacentNode(one);
        System.out.println(routeBetweenNodes(zero, two));
        System.out.println(routeBetweenNodes(three, five));
    }
    public static class Node<E>{
        E value;
        Object[] adjacents = new Object[0];
        boolean visited = false;
        Node(E value){
            this.value = value;
        }
        void addAdjacentNode(Node<E> node){
            Object[] newArray = new Object[adjacents.length+1];
            int index;
            for(index=0; index<adjacents.length; index++){
                newArray[index] = adjacents[index];
            }
            newArray[index] = node;
            adjacents = newArray;
        }
    }
}