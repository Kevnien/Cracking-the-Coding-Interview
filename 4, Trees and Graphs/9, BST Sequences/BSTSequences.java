// A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
// EXAMPLE
// Input:
//     head:2
//     2.left:1, 3.right:3
// Output:
//     {2,1,3},{2,3,1}

import java.util.ArrayList;
class BSTSequences{
    public static ArrayList<ArrayList<Integer>> bSTSequences(Node node){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        
        if(node == null){
            answer.add(new ArrayList<Integer>());
            return answer;
        }

        ArrayList<Integer> prefix = new ArrayList<Integer>();
        prefix.add(node.value);

        ArrayList<ArrayList<Integer>> left = bSTSequences(node.left);
        ArrayList<ArrayList<Integer>> right = bSTSequences(node.right);

        for(ArrayList<Integer> leftList: left){
            for(ArrayList<Integer> rightList: right){
                ArrayList<ArrayList<Integer>> weaved = new ArrayList<ArrayList<Integer>>();
                weave(leftList, rightList, weaved, prefix);
                answer.addAll(weaved);
            }
        }

        return answer;
    }

    public static void weave(ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> prefix){
        if(first.size()==0 || second.size()==0){
            ArrayList<Integer> result = (ArrayList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.remove(0);
        prefix.add(headFirst);
        weave(first, second, results, prefix);
        prefix.remove(prefix.size()-1);
        first.add(0, headFirst);
        
        int headSecond = second.remove(0);
        prefix.add(headSecond);
        weave(first, second, results, prefix);
        prefix.remove(prefix.size()-1);
        second.add(0, headFirst);
    }

    public static void main(String[] args){
        Node fifty = new Node(50);
        Node twenty = new Node(20);
        Node sixty = new Node(60);
        Node ten = new Node(10);
        Node twentyfive = new Node(25);
        Node seventy = new Node(70);
        Node five = new Node(5);
        Node fifteen = new Node(15);
        Node sixtyfive = new Node(65);
        Node eighty = new Node(80);
        fifty.left = twenty;
        fifty.right = sixty;
        twenty.left = ten;
        twenty.right = twentyfive;
        sixty.right = seventy;
        ten.left = five;
        ten.right = fifteen;
        seventy.left = sixtyfive;
        seventy.right = eighty;

        print(bSTSequences(fifty));
    }

    public static void print(ArrayList<ArrayList<Integer>> arrays){
        int index = 1;
        for(ArrayList<Integer> array : arrays){
            System.out.println("Array "+index++);
            for(Integer number : array){
                System.out.print(number+",");
            }
            System.out.println();
        }
    }

    public static class Node{
        int value;
        Node left=null, right=null;
        Node(int value){
            this.value = value;
        }
    }
}