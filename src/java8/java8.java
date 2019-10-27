package java8;

// novos defaults methods do java 8: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * A proposta dessa classe é treinar e comparar as diferenças entre o java 8 e as versões anteriores.
 */
public class java8 {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Development", "Title", "Hi");

		/*
		 * Ilustrando a transi��o at� o usa do LAMBDA no sort
		 */
		// Comparator: é utilizado para definir uma nova forma de ordenar uma lista
//		Comparator<String> comparador = new ConparadorPorTamanho();

		/*
		 * por default o método sort ordena por ordem alfabetica obs: forma anterior ao
		 * java 8 de ordenar
		 */
		// Collections.sort(palavras);
		/*
		 * com o meu comparator, é ordenado por tamanho (length) da string obs: forma
		 * anterior ao java 8 de ordenar
		 */
		// Collections.sort(palavras, comparador);

		palavras.sort(null);// forma de ordenar do java 8. Comparator default (alfabetico)

//		palavras.sort(comparador); //1� implementa��o do comparator: usando classe. Forma de ordenar do java 8. Meu Comparator

//		palavras.sort(new Comparator<String>() { //2� implementa��o do comparator: usando classe anonima
//			@Override
//			public int compare(String s1, String s2) {
//				if (s1.length() < s2.length())
//					return -1;
//				if (s1.length() > s2.length())
//					return 1;
//				// se as strings forem do mesmo tamanho
//				return 0;
//			}
//		});

		/*
		 * Usando o LAMBDA
		 */
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//quebranco o c�digo acima para visualizar melhor o que esta acontecendo
		
//		Function<String, Integer> funcao = s -> s.length(); //1� interface funcional que define o crit�rio de compara��o
//		Comparator<String> comparador = Comparator.comparing(funcao);//2� usamos o coparing que � uma factory de comparator 
		//e que recebe uma instancia de uma interface funcional (lambda) que define o crit�rio de compa��o.
//		palavras.sort(comparador);//3� passamos para o m�todo default sort o nosse crit�rio de ordena��o
		
		/*
		 * Method Reference :: � uma forma ainda mais simples de escrever o lambda, fazendo apenas uma referencia ao m�todo
		 * Aplicando o Method Reference no palavras.sort(Comparator.comparing(s -> s.length()));
		 */
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.forEach(s -> System.out.println(s)); //lambda
		palavras.forEach(System.out::println); //method reference
		
		Function<String, Integer> funcaoUsandoLambda = s -> s.length(); //lambda
		Function<String, Integer> funcaoUsandoReference = String::length; //method reference
		
//		exemplo de lambda que nao poder ser representado com method reference: s -> s.substring(0, 5); pois n�o � uma simples invoca��o de m�todo
//		onde os parametros s�o os mesmos do lambda
		
		//mostrando outra forma de usar o lambda apresentado acima
		Comparator<String> comparadorUsandoLambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		palavras.sort(comparadorUsandoLambda);

		/*
		 * Ilustrando a transi��o at� o usa do LAMBDA no forEach
		 */
		// consumidor para ser usado no forEach
//		Consumer<String> consumidor = new ImprimeNaLinha(); //1� implementa��o consumidor: usando classe q implementa consumer

		// usando classe anonima
//		Consumer<String> consumidor = new Consumer<String>() { //2� implementa��o consumidor: usando classe anonima na interface consumer
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};

		// forEach: precisa de um consumidor
//		palavras.forEach(consumidor);

//		palavras.forEach(new Consumer<String>() { // 3� implementa��o consumidor: passando a classe anonima direto
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});

		/*
		 * Usando Lambda
		 */
		palavras.forEach(s -> System.out.println(s));

		//mostrando outra forma de usar o lambda apresentado acima
		Consumer<String> consumidorUsandoLambda = s -> System.out.println(s);
		palavras.forEach(consumidorUsandoLambda);
		
		/*
		 * Sobre o Default Method Exemplo: método sort do List. Ex.: default void sort
		 * (Comparator<? super E> c) { Collections.sort(this, c) } É um método que
		 * possui corpo dentre de uma interface, ou seja não é um método abstrato
		 */
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		/*
		 * Quando a express�o lambda n�o estiver passando parametros devemos usar parenteses vazios: ()
		 * como  neste exemplo: () -> System.out.println("Executando um Runnable")
		 */
	}
}

//neste caso se usa classe anonima
//class ImprimeNaLinha implements Consumer <String> {
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//	
//}

/*
 * é a implementação do das resgras do meu comparator, ou seja da minha forma
 * de ordenar
 */
//class ConparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		// se as strings forem do mesmo tamanho
//		return 0;
//	}
//
//}