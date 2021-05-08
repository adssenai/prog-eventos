package senai;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("--- Sistema de Eventos ---");
		Usuario usuario1 = new Usuario("João");
		Usuario usuario2 = new Usuario("Maria");
		
		System.out.println("--- Evento 1 ---");
		EventoPresencial evento1 = new EventoPresencial("Java for Dummies", 
				LocalDate.of(2020, 8, 10), usuario1, "SENAI/SC", 20);
		try {
			evento1.addParticipante(usuario2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		evento1.setData(LocalDate.of(2020, 10, 12));
		evento1.setData("15/10/2020");
		System.out.println(evento1);
		
		System.out.println("--- Evento 2 ---");
		EventoVirtual evento2 = new EventoVirtual("PostgreSQL for Dummies", 
				LocalDate.of(2020, 9, 7), usuario2, "http://eventovirtual.org.br/123");
		try {
			evento2.addParticipante(usuario2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(evento2);
		
		System.out.println("--- Compromisso ---");
		Compromisso compromisso = new Compromisso("Reunião de Planejamento", 
				LocalDate.of(2020, 10, 20));
		
		
		
		Agendamento[] agendamentos = new Agendamento[3];
		agendamentos[0] = evento1;
		agendamentos[1] = evento2;
		agendamentos[2] = compromisso; 
		for (Agendamento agendamento : agendamentos) {
			System.out.println(agendamento);
		}
		
		System.out.println("--- POLIMORFISMO ---");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.add(evento1);
		eventos.add(evento2);
		for (Evento evento : eventos) {
			System.out.println(evento);
		}
		
		System.out.println("--- FIM ---");

	}

}
