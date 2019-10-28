package java8.stream;

import java.util.Arrays;
import java.util.List;

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(new Curso("JavaScript", 150), new Curso("Java 8", 113),
				new Curso("Python", 45), new Curso("C", 55));
		
		/*
		 * learning abaut stream api
		 */
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100) //filter: a partir de um predicate filtra os objetos da lista
//			.map(c -> c.getAlunos()) //map: mapeia um tipo de objeto (ex.: curso) para outro (Integer do getAlunos)
//			.mapToInt(Curso::getAlunos) //mapToInt: possui operações internas como o .sum() para somar ints
//			.sum(); // sum: operação do mapToInt para somar os valores inteiros de cada objeto
//			.forEach(c -> System.out.println(c.getAlunos()));
	
		/*
		 * new tests in stream api
		 */
		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.map(Curso::getNome);
		// collect: pesquisar
		// findFirst: pesquisar
		// findAny: pesquisar
		
	}

}

class Curso {
	
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}
