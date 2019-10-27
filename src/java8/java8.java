package java8;

// novos defaults methods do java 8: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * A proposta dessa classe Ã© treinar e comparar as diferenÃ§as entre o java 8 e as versÃµes anteriores.
 */
public class java8 {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Development", "Title", "Hi");

		/*
		 * Ilustrando a transição até o usa do LAMBDA no sort
		 */
		// Comparator: Ã© utilizado para definir uma nova forma de ordenar uma lista
//		Comparator<String> comparador = new ConparadorPorTamanho();

		/*
		 * por default o mÃ©todo sort ordena por ordem alfabetica obs: forma anterior ao
		 * java 8 de ordenar
		 */
		// Collections.sort(palavras);
		/*
		 * com o meu comparator, Ã© ordenado por tamanho (length) da string obs: forma
		 * anterior ao java 8 de ordenar
		 */
		// Collections.sort(palavras, comparador);

		palavras.sort(null);// forma de ordenar do java 8. Comparator default (alfabetico)

//		palavras.sort(comparador); //1º implementação do comparator: usando classe. Forma de ordenar do java 8. Meu Comparator

//		palavras.sort(new Comparator<String>() { //2º implementação do comparator: usando classe anonima
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
		//quebranco o código acima para visualizar melhor o que esta acontecendo
		
//		Function<String, Integer> funcao = s -> s.length(); //1º interface funcional que define o critério de comparação
//		Comparator<String> comparador = Comparator.comparing(funcao);//2º usamos o coparing que é uma factory de comparator 
		//e que recebe uma instancia de uma interface funcional (lambda) que define o critério de compação.
//		palavras.sort(comparador);//3º passamos para o método default sort o nosse critério de ordenação
		
		/*
		 * Method Reference :: é uma forma ainda mais simples de escrever o lambda, fazendo apenas uma referencia ao método
		 * Aplicando o Method Reference no palavras.sort(Comparator.comparing(s -> s.length()));
		 */
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.forEach(s -> System.out.println(s)); //lambda
		palavras.forEach(System.out::println); //method reference
		
		Function<String, Integer> funcaoUsandoLambda = s -> s.length(); //lambda
		Function<String, Integer> funcaoUsandoReference = String::length; //method reference
		
//		exemplo de lambda que nao poder ser representado com method reference: s -> s.substring(0, 5); pois não é uma simples invocação de método
//		onde os parametros são os mesmos do lambda
		
		//mostrando outra forma de usar o lambda apresentado acima
		Comparator<String> comparadorUsandoLambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		palavras.sort(comparadorUsandoLambda);

		/*
		 * Ilustrando a transição até o usa do LAMBDA no forEach
		 */
		// consumidor para ser usado no forEach
//		Consumer<String> consumidor = new ImprimeNaLinha(); //1º implementação consumidor: usando classe q implementa consumer

		// usando classe anonima
//		Consumer<String> consumidor = new Consumer<String>() { //2º implementação consumidor: usando classe anonima na interface consumer
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};

		// forEach: precisa de um consumidor
//		palavras.forEach(consumidor);

//		palavras.forEach(new Consumer<String>() { // 3º implementação consumidor: passando a classe anonima direto
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
		 * Sobre o Default Method Exemplo: mÃ©todo sort do List. Ex.: default void sort
		 * (Comparator<? super E> c) { Collections.sort(this, c) } Ã‰ um mÃ©todo que
		 * possui corpo dentre de uma interface, ou seja nÃ£o Ã© um mÃ©todo abstrato
		 */
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		/*
		 * Quando a expressão lambda não estiver passando parametros devemos usar parenteses vazios: ()
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
 * Ã© a implementaÃ§Ã£o do das resgras do meu comparator, ou seja da minha forma
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