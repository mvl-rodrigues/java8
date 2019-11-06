package novadata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {

	public static void main(String[] args) {

		//pegando a data de hoje
		LocalDate dataHoje = LocalDate.now();
		
		System.out.println("Data de hoje: "+dataHoje);
		
		//criando uma data específica
		LocalDate dataOlimpiadas = LocalDate.of(2020, Month.JUNE, 5);
		
		//ver a diferença de anos chamando o getYear das datas
		int dataEntreHojeEOlimpiadas = dataOlimpiadas.getYear() - dataHoje.getYear();
		System.out.println(dataEntreHojeEOlimpiadas);
		
		//ver a diferença de anos entre duas datas usando o Period.between
		Period periodo = Period.between(dataHoje, dataOlimpiadas);
		System.out.println(periodo.getYears());  //periodo.getDays() periodo.getMonths()
		
		//somar anos a minha data
		LocalDate proximasOlimpiadas = dataOlimpiadas.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		//criando um formatador para as datas
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//aplicando o formatador na data das proximas olimpiadas
		String dataFormatada = proximasOlimpiadas.format(formatador);
		System.out.println(dataFormatada); 
		//ou podemos fazer assim:
		System.out.println(formatador.format(proximasOlimpiadas));
		
		//criando a formatação para data e hora
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		//pegando a data e hora local
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		//criando uma hora especifica
		LocalTime horaEspecifica = LocalTime.of(15, 30);
		System.out.println(horaEspecifica);
		
		/*
		 * Pesquisar mais sobre: ZoneDateTime
		 */
		
	}

}
