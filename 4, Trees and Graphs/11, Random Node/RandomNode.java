// You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, has a method getRandomNode() which returns a random node from the tree.
// All nodes should be equally likely to be chosen. 
// Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.

import java.util.LinkedList;
import java.util.Random;

class RandomNode{
    public static class BT<E>{
        Node<E> root;
        int count;
        BT(E value){
            root = new Node(value);
            count = 1;
        }

        Node<E> getRandomNode(){
            Random random = new Random();
            int target = random.nextInt(target);
            LinkedList<Node<E>> queue = createQueue();
            Node<E> current;
            int index = 0;
            while(queue.size() > 0){
                current = queue.pop();
                if(index++ == target){
                    return current;
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            return null;
        }

        void insert(E value){
            LinkedList<Node<E>> queue = createQueue();
            Node<E> current;
            while(true){
                current = queue.pop();
                if(current.left == null){
                    current.addLeft(value);
                    return;
                }else if(current.right == null){
                    current.addRight(value);
                    return;
                }
                queue.add(current.left);
                queue.add(current.right);
            }
            count++;
        }

        <E extends Comparable<E>> Node<E> find(E value){
            LinkedList<Node<E>> queue = createQueue();
            Node<E> current;
            while(queue.size() > 0){
                current = queue.pop();
                // compareTo method described in Comparable interface specifies that it will return 0 if the two values are equal
                if(current.value.compareTo(value)==0){
                    return current;
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            return null;
        }

        <E extends Comparable<E>> Node<E> delete(E value){
            LinkedList<Node<E>> queue = createQueue();
            Node<E> current, lag;
            lag = null;
            while(queue.size() > 0){
                current = queue.pop();
                // compareTo method described in Comparable interface specifies that it will return 0 if the two values are equal
                if(current.value.compareTo(value) == 0){
                    if(lag == null){
                        root = current.left;
                    }else{
                        if(lag.left = current){
                            lag.left = current.left;
                        }else{
                            lag.right = current.left;
                        }
                    }
                    LinkedList<Node<E>> queue2 = new LinkedList<Node<E>>();
                    queue2.push(current);
                    Node<E> current2;
                    while(true){
                        current2 = queue2.pop();
                        if(current2.left == null){
                            current2.left = current.right;
                            break;
                        }else if(current2.right == null){
                            current2.right = current.right;
                        }
                        queue2.add(current2.left);
                        queue2.add(current2.right);
                    }
                    return current;
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
                lag = current;
            }
            count--;
        }

        private static <E> LinkedList<Node<E>> createQueue(){
            LinkedList<Node <E>> queue = new LinkedList<Node <E>>();
            queue.push(root);
            return queue;
        }

        public static class Node<E extends Comparable<E>>{
            E value;
            Node left, right;
            Node(E value){
                this.value = value;
            }
            void addLeft(E value){
                this.left = new Node(value);
            }
            void addRight(E value){
                this.right = new Node(value);
            }
        }
    }

}