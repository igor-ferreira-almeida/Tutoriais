package br.com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {
	public static void main(String[] args) {
		
		List<Curso> cursos1 = new ArrayList<>();
		cursos1.add(new Curso("Python", 45, true));
		cursos1.add(new Curso("JavaScript", 150, false));
		cursos1.add(new Curso("Java 8", 113, true));
		cursos1.add(new Curso("C", 55, false));
		
		List<Curso> cursos2 = new ArrayList<>();
		cursos2.add(new Curso("Python", 45));
		cursos2.add(new Curso("JavaScript", 150, true));
		
		
		
		List<Curso> cursosDeletados = new ArrayList<>();
		
		cursosDeletados = new ArrayList<>(cursos1);
		cursosDeletados.removeAll(cursos2);
		
		cursosDeletados = cursosDeletados.stream().filter(c -> c.isAtivo()).collect(Collectors.toList());
		
		
		
	}
}
