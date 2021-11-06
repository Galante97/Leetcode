//An animal shelter holds only dogs and cats, and operates on a strictly "First in first out" basis 
//People must adopt either the oldest (based on arrvial time) of the all animals at the shelter or they can select whether they would
//prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select whcih specific 
//animal they would like. Create the data structures to maintain this system and implement operations such as 
//enqueue, dequeueAny, dequeueDog, dequeueCat. You must use the built in linkedList data structure


public class Shelter {

    LinkedList<Dog> Dogs = new LinkedList<Dog>();
    LinkedList<Cat> Cats = new LinkedList<Cat>();

    private int order; //acts as a timestamp

    public async void Enqueue(Animal animal) {
        a.setOrder(order);
        order++;

        if (a is Dog) {
            Dogs.AddLast((Dog)a);
        }
        if (a is Cat) {
            Cats.AddLast((Cat)a);
        }  
        
    }

    public void DequeueAny() {}

    public void DequeueCat() {}


}

public class Animal {
    private int order;
    public string name;
    public Animal(string n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public bool isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }

}

public class Dog : Animal {

} 

public class Cat : Animal {

}