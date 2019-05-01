// T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a subtree of T1. A Tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

class CheckSubtree{
    public static <E extends Comparable<E>> boolean checkSubtree(Node<E> tree, Node<E> subtree){
        if(tree == null){
            return false;
        }
        if(tree.value.compareTo(subtree.value)==0){
            if(check(tree, subtree)){
                return true;
            }
        }
        if(checkSubtree(tree.left, subtree)){
            return true;
        }
        if(checkSubtree(tree.right, subtree)){
            return true;
        }
        return false;
    }

    public static <E extends Comparable<E>> boolean check(Node<E> tree, Node<E> subtree){
        Node<E> lNode = tree;
        Node<E> rNode = subtree;
        if(lNode == null){
            if(rNode == null){
                return true;
            }else{
                return false;
            }
        }
        if(rNode == null){
            return false;
        }
        if(lNode.value.compareTo(rNode.value)!=0){
            return false;
        }
        if(!check(lNode.left, rNode.left)){
            return false;
        }
        if(!check(lNode.right, rNode.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Node<Integer> fifty = new Node(50);
        Node<Integer> twenty = new Node(20);
        Node<Integer> sixty = new Node(60);
        Node<Integer> ten = new Node(10);
        Node<Integer> twentyfive = new Node(25);
        Node<Integer> seventy = new Node(70);
        Node<Integer> five = new Node(5);
        Node<Integer> fifteen = new Node(15);
        Node<Integer> sixtyfive = new Node(65);
        Node<Integer> eighty = new Node(80);
        fifty.left = twenty;
        fifty.right = sixty;
        twenty.left = ten;
        twenty.right = twentyfive;
        sixty.right = seventy;
        ten.left = five;
        ten.right = fifteen;
        seventy.left = sixtyfive;
        seventy.right = eighty;
        
        Node<Integer> tenS = new Node(10);
        Node<Integer> fiveS = new Node(5);
        Node<Integer> fifteenS = new Node(15);
        tenS.left = fiveS;
        // tenS.right = fifteenS;

        System.out.println(checkSubtree(fifty, tenS));
    }

    public static class Node<E extends Comparable<E>>{
        E value;
        Node left=null, right=null;
        Node(E value){
            this.value = value;
        }
    }
}