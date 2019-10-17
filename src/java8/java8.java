package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
/*
 * A proposta dessa classe é treinar e comparar as diferenças entre o java 8 e as versões anteriores.
 */
public class java8 {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Development","Title","Hi");
		
		//Comparator: é utilizado para definir uma nova forma de ordenar uma lista
		Comparator<String> comparador = new ConparadorPorTamanho();
		
		/*
		 * por default o método sort ordena por ordem alfabetica
		 * obs: forma anterior ao java 8 de ordenar
		 */
		//Collections.sort(palavras);
		
		
		palavras.sort(null);// forma de ordenar do java 8. Comparator default (alfabetico)
		
//		System.out.println(palavras);
		
		/*
		 * com o meu comparator, é ordenado por tamanho (length) da string
		 * obs: forma anterior ao java 8 de ordenar
		 */
		//Collections.sort(palavras, comparador);
		
		palavras.sort(comparador); // forma de ordenar do java 8. Meu Comparator
		
//		System.out.println(palavras);
		
		//consumidor para ser usado no forEach
		Consumer<String> consumidor = new ImprimeNaLinha();
		//forEach: precisa de um consumidor
//		palavras.forEach(consumidor);
		palavras.forEach(null);
		
		/*
		 * Sobre o Default Method
		 * Exemplo: método sort do List.
		 * Ex.: default void sort (Comparator<? super E> c) { Collections.sort(this, c) }
		 * É um método que possui corpo dentre de uma interface, ou seja não é um método abstrato
		 */
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}


/*
 * é a implementação do das resgras do meu comparator, ou seja da minha forma de ordenar
 */
class ConparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		//se as strings forem do mesmo tamanho
		return 0;
	}
	
}