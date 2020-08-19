package stacksandqueues;

import java.util.LinkedList;

abstract class Animal {
	int serialNumber;

	public abstract void whoami();
}

class Dog extends Animal {

	@Override
	public void whoami() {
		// TODO Auto-generated method stub
		System.out.println("me dog");
	}

}

class Cat extends Animal {

	@Override
	public void whoami() {
		// TODO Auto-generated method stub
		System.out.println("me cat");
	}

}

public class AnimalShelter {
	int seq;
	LinkedList<Animal> dogs;
	LinkedList<Animal> cats;

	public AnimalShelter() {
		this.seq = 0;
		dogs = new LinkedList<>();
		cats = new LinkedList<>();
	}

	public void enqueue(Animal a) {
		a.serialNumber = seq;
		seq++;
		if (a instanceof Cat) {
			cats.add(a);
		} else {
			dogs.add(a);
		}
	}

	public Animal DequeueAny() {
		if (dogs.size() == 0 && cats.size() == 0)
			return null;
		if (dogs.size() == 0)
			return cats.poll();
		if (cats.size() == 0)
			return dogs.poll();

		Dog d = (Dog) dogs.peek();
		Cat c = (Cat) cats.peek();

		if (d.serialNumber < c.serialNumber)
			return dogs.poll();

		return cats.poll();
	}

	public Cat dequeueCat() {
		return (Cat) cats.poll();
	}

	public Dog dequeueDog() {
		return (Dog) dogs.poll();
	}

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Cat());
		
		Animal dequeueAny = shelter.DequeueAny();
		dequeueAny.whoami();
		Animal dequeueAny1 = shelter.dequeueDog();
		dequeueAny1.whoami();
	}

}
