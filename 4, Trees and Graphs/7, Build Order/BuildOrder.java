// You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the first project is dependent on the second project).
// All of a project's dependencies must be built before the project is.
// Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
// EXAMPLE
// Input:
//     projects: a,b,c,d,e,f
//     dependencies: (d,a), (b,f), (d,b), (a,f), (c,d)
// Output:
//     f,e,a,b,d,c

import java.util.ArrayList;
class BuildOrder{
    public static ArrayList<Character> buildOrder(ArrayList<Character> projects, ArrayList<ArrayList<Character>> dependencies){
        Graph graph = new Graph();
        for(int i=0; i<projects.size(); i++){
            graph.nodes.add(new Node(projects.get(i)));
        }
        for(int i=0; i<dependencies.size(); i++){
            ArrayList<Character> list = dependencies.get(i);
            graph.addChild(list.get(0), list.get(1));
            graph.get(list.get(0)).parents++;
        }
        ArrayList<Character> buildOrder = new ArrayList<Character>();
        int currentSize = 0;
        for(;;){
            for(int i=0; i<graph.nodes.size(); i++){
                if(graph.nodes.get(i).parents == 0){
                    buildOrder.add(graph.nodes.get(i).project);
                    for(int j=0; j<graph.nodes.get(i).children.size(); j++){
                        graph.nodes.get(i).children.get(j).parents--;
                    }
                    graph.nodes.remove(i);
                }
            }
            if(currentSize == buildOrder.size()){
                break;
            }
            currentSize = buildOrder.size();
        }
        if(buildOrder.size() != projects.size()){
            return null;
        }
        return buildOrder;
    }

    public static void main(String[] args){
        ArrayList<Character> projects = new ArrayList<Character>();
        Character[] projectsArray = {'a','b','c','d','e','f'};
        for(Character character : projectsArray){
            projects.add(character);
        }
        ArrayList<ArrayList<Character>> dependencies = new ArrayList<ArrayList<Character>>();
        Character[][] dependenciesArray = {{'d','a'},{'b','f'},{'d','b'},{'a','f'},{'c','d'}};
        for(int i=0; i<dependenciesArray.length; i++){
            ArrayList<Character> dependency = new ArrayList<Character>();
            for(Character character : dependenciesArray[i]){
                dependency.add(character);
            }
            dependencies.add(dependency);
        }
        ArrayList<Character> buildOrder = buildOrder(projects, dependencies);
        for(int i=0; i<buildOrder.size(); i++){
            System.out.print(buildOrder.get(i));
        }
        System.out.println();
        projects = new ArrayList<Character>();
        Character[] projectsArray2 = {'a','b','c','d','e','f','g'};
        for(Character character : projectsArray2){
            projects.add(character);
        }
        dependencies = new ArrayList<ArrayList<Character>>();
        Character[][] dependenciesArray2 = {{'g','d'},{'e','a'},{'a','f'},{'a','c'},{'a','b'},{'c','f'},{'b','f'},{'e','b'}};
        for(int i=0; i<dependenciesArray2.length; i++){
            ArrayList<Character> dependency = new ArrayList<Character>();
            for(Character character : dependenciesArray2[i]){
                dependency.add(character);
            }
            dependencies.add(dependency);
        }
        buildOrder = buildOrder(projects, dependencies);
        for(int i=0; i<buildOrder.size(); i++){
            System.out.print(buildOrder.get(i));
        }
        System.out.println();
    }

    public static class Graph{
        ArrayList<Node> nodes;
        Graph(){
            nodes = new ArrayList<Node>();
        }
        Node get(Character character){
            for(int i=0; i<nodes.size(); i++){
                if(nodes.get(i).project == character){
                    return nodes.get(i);
                }
            }
            return null;
        }
        boolean addChild(Character child, Character parent){
            if(get(child)==null || get(parent)==null){
                return false;
            }
            get(parent).children.add(get(child));
            return true;
        }
    }

    public static class Node{
        char project;
        int parents = 0;
        ArrayList<Node> children = new ArrayList<Node>();
        Node(char character){
            project = character;
        }
    }
}