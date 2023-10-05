package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Program {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
	
			System.out.print("Dia do checkin: ");
			LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
	
			System.out.print("Dia do checkout: ");
			LocalDate checkout = LocalDate.parse(sc.next(), fmt1);
	
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println(reserva);
	
			System.out.println();
			System.out.println("Entre com os dados novamente para atualizar a reserva:");
	
			System.out.print("Dia do checkin: ");
			checkin = LocalDate.parse(sc.next(), fmt1);
	
			System.out.print("Dia do checkout: ");
			checkout = LocalDate.parse(sc.next(), fmt1);
	
			reserva.atualizarData(checkin, checkout);
	
			System.out.println(reserva);
		}
		catch (DominioException e) {
			
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();

	}

}
