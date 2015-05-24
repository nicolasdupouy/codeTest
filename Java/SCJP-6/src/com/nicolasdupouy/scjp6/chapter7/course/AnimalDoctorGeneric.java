package com.nicolasdupouy.scjp6.chapter7.course;

import java.util.ArrayList;
import java.util.List;

public class AnimalDoctorGeneric {
	// change the argument from Animal[] to ArrayList<Animal>
	public void checkAnimals(List<? extends Animal> /*List<Animal>*/animals) {
		for (Animal a : animals) {
			a.checkup();
		}
	}

	public void addAnimal(List<? super Dog> /*List<? extends Animal>*//*List<Animal>*/animals) {
		animals.add(new Dog()); // impossible if List<? extends Animal>
	}

	public void addAnything(List<Object> list) {
		list.add(new Dog());
		list.add(new Cat());
		list.add(new IndexOutOfBoundsException());
	}

	public static void main(String[] args) {
		// make ArrayLists instead of arrays for Dog, Cat, Bird
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Bird());
		animals.add(new Cat());

		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat());
		cats.add(new Cat());
		List<Bird> birds = new ArrayList<Bird>();
		birds.add(new Bird());
		// this code is the same as the Array version
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
		// this worked when we used arrays instead of ArrayLists
		doc.checkAnimals(dogs); // send a List<Dog>
		doc.checkAnimals(cats); // send a List<Cat>
		doc.checkAnimals(birds); // send a List<Bird>

		doc.addAnimal(animals);
		doc.addAnimal(dogs);
		//doc.addAnimal(cats); => due to List<? super Dog
	}
}
