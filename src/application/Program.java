package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		
		System.out.print("Dia do checkin: ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
		
		System.out.print("Dia do checkout: ");
		LocalDate checkout = LocalDate.parse(sc.next(), fmt1);
		
		if(!checkout.isAfter(checkin)) {
			
			System.out.println("Erro na reserva: Data de checkou anterior a data de checkin.");
			
		}
		else {
			
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados novamente para atualizar a reserva:");
			
			System.out.print("Dia do checkin: ");
			checkin = LocalDate.parse(sc.next(), fmt1);
			
			System.out.print("Dia do checkout: ");
			checkout = LocalDate.parse(sc.next(), fmt1);
			
			LocalDate hoje = LocalDate.now();
			
			if(checkin.isBefore(hoje) || checkout.isBefore(hoje)) {
				
				System.out.println("Erro na reserva: As datas para atualização devem ser futuras.");
			}
			else if(!checkout.isAfter(checkin)) {
				
				System.out.println("Erro na reserva: Data de checkou anterior a data de checkin.");
				
			}
			else {
			
			reserva.atualizarData(checkin, checkout);
			System.out.println(reserva);
			
			}
			
		}

	}

}
