package design_pattern_principles.defining_functional_interface;

import java.time.LocalDateTime;

public class AnimalTest {
	
	public static String printSpecie(Animal animal, Sprint print) {
		return "";
	}
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.setSpecie("Feline");
		
		System.out.println(printSpecie(animal, a -> a.getSpecie()));
		
		LocalDateTime.now();
	}
}
