package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(new Curso("JavaScript", 150), new Curso("Java 8", 50),
				new Curso("Python", 80), new Curso("C", 170));
		
		/*
		 * learning abaut stream api
		 */
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100) //filter: a partir de um predicate filtra os objetos da lista
//			.map(c -> c.getAlunos()) //map: mapeia um tipo de objeto (ex.: curso) para outro tipo (Integer do getAlunos)
//			.mapToInt(Curso::getAlunos) //mapToInt: possui operações internas como o .sum() para somar ints
//			.sum(); // sum: operação do mapToInt para somar os valores inteiros de cada objeto
//			.forEach(c -> System.out.println(c.getAlunos()));
	
		/*
		 * new tests in stream api
		 */
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 50)
//			.forEach(c -> System.out.println(c.getNome()));
//		
//		cursos.stream()
//			.map(Curso::getNome); //mapeando o tipo de objeto curso para o tipo string (getNome)
		// collect: pesquisar
		// findFirst: pesquisar
		
		/*
		 * Classe Optional: nova classe do java 8 que ajuda a trabalhar com objetos nulos.
		 */
//		Optional<Curso> optionalCurso = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100) // filtra todos os cursos da lista a partir do predicate
//			.findAny(); // retorna um Optional<Curso> com qualquer curso (aleatório).
		
//		Curso curso = optionalCurso.get(); // retorna o objeto original dentro do optional (pode retornar null)
//		Curso curso2 = optionalCurso.orElse(new Curso("Padrao", 0)); // retorna um objeto se não tiver, retorna o que foi passado por parametro
//		optionalCurso.ifPresent(c -> System.out.println(c.getNome())); //ifPresente do Optional se existir ele executa o lambda que imprime
		//o nome do curso, se não tiver nem um curso ele não faz nada (não lança exception).
		
		/*
		 * Forma mais comum de usar Optional, stream e lambda
		 */
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100) // filtar os elementos
//			.findAny() // pega um elemento qualquer
//			.ifPresent(c -> System.out.println(c.getNome())); // se existir um elemento printa o nome
		
//		cursos = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toList()); // transforma a stream filtrada e converte para uma List<Cursos>
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toMap(Curso::getNome,Curso::getAlunos))// convertendo para map, tendo getNome como chave e getAlunos como valor.
//			.forEach((nome, valor) -> System.out.println(nome + " tem " + valor + " Alunos."));
		
		/*
		 * Obs: o stream permite usar streams paralelas para trabalhar com grandes valumes de dados
		 * ex:
		 */
//		cursos.parallelStream() // melhora a performace quando temos que trabalhar com grandes coleções de dados
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toMap(Curso::getNome,Curso::getAlunos))
//			.forEach((nome, valor) -> System.out.println(nome + " tem " + valor + " Alunos."));
		
//		OptionalDouble average = cursos.stream().mapToInt(Curso::getAlunos).average();
//		System.out.println(average);
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 99)
			.collect(Collectors.toList())
			.forEach(c -> System.out.println(c.getNome()));
		
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
