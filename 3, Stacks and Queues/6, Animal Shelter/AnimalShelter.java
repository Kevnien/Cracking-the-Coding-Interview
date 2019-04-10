// An animal shelter, which holds only dogs and cats,
// operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals at the shlter,
// or they can select whether they would prefer a dog or a cats
// (and receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create the data structures to maintain this system and implement operations such as 
// enqueue, dequeueAny, dequeueDog, and dequeueCat.
// You may use the built-in LinkedList data structure.

import java.util.LinkedList;
class AnimalShelter{
    public static class ShelterQueue{
        LinkedList<Animal> dogs = new LinkedList<Animal>();
        LinkedList<Animal> cats = new LinkedList<Animal>();
        int number = 0;
        ShelterQueue(){}
        void enqueue(String animalName, String species){
            Animal animal = new Animal(animalName, species, number++);
            if(animal.getSpecies() == "dog"){
                dogs.add(animal);
            }else if(animal.getSpecies() == "cat"){
                cats.add(animal);
            }else{
                System.out.println("invalid species");
                return;
            }
        }
        Animal dequeueAny(){
            Animal dog = dogs.peek();
            Animal cat = cats.peek();
            if(dog == null){
                if(cat == null){
                    return null;
                }
                return cats.remove();
            }
            if(cat == null){
                return dogs.remove();
            }
            if(dog.getNumber() < cat.getNumber()){
                return dogs.remove();
            }else{
                return cats.remove();
            }
        }
        Animal dequeueDog(){
            return dogs.remove();
        }
        Animal dequeueCat(){
            return cats.remove();
        }
    }

    public static void main(String[] args){
        ShelterQueue queue = new ShelterQueue();
        queue.enqueue("Paul", "cat");
        queue.enqueue("Meowster", "cat");
        queue.enqueue("Lucky", "dog");
        queue.enqueue("Spot", "dog");
        queue.enqueue("Furball", "cat");
        queue.enqueue("Meadowlark Lemon", "dog");
        Animal animal = queue.dequeueAny();
        animal.print();
        animal = queue.dequeueDog();
        animal.print();
        animal = queue.dequeueAny();
        animal.print();
        animal = queue.dequeueCat();
        animal.print();
    }

    public static class Animal{
        private String name;
        private String species;
        private int number;
        Animal(String name, String species, int number){
            this.name = name;
            this.species = species;
            this.number = number;
        }
        String getName(){
            return name;
        }
        String getSpecies(){
            return species;
        }
        int getNumber(){
            return number;
        }
        void print(){
            System.out.println(name+" "+species);
        }
    }
}