package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import model.exceptions.DominioException;

public class Reserva {

	private Integer numeroQuarto;
	private LocalDate checkin;
	private LocalDate checkout;

	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, LocalDate checkin, LocalDate checkout){

		if (!checkout.isAfter(checkin)) {

			throw new DominioException("Erro na reserva: Data de checkou anterior a data de checkin.");
		}

		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public long duracao() {

		Period dif = Period.between(checkin, checkout);
		return dif.getDays();

	}

	public void atualizarData(LocalDate checkin, LocalDate checkout){

		LocalDate hoje = LocalDate.now();

		if (checkin.isBefore(hoje) || checkout.isBefore(hoje)) {

			throw new DominioException("Erro na reserva: As datas para atualização devem ser futuras.");
		}

		this.checkin = checkin;
		this.checkout = checkout;

	}

	@Override
	public String toString() {
		return "Reserva: numeroQuarto= " + numeroQuarto + ", checkin= " + fmt1.format(checkin) + ", checkout= "
				+ fmt1.format(checkout) + ", duração= " + duracao() + " noites.";
	}

}
