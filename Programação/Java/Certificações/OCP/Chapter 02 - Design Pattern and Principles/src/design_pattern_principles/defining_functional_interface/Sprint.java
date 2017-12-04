package design_pattern_principles.defining_functional_interface;

@FunctionalInterface
public interface Sprint {
	void sprint(Animal animal);
	
	default double paws() {
		return 2;
	}
	
	static double eyes() {
		return 2;
	}
}
