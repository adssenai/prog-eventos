package senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Evento implements Agendamento {

	private String nome;
	private LocalDate data;
	private Usuario organizador;
	private List<Usuario> participantes;
	
	
	public Evento(String nome, LocalDate data, Usuario organizador) {
		this.nome = nome;
		this.data = data;
		this.organizador = organizador;
		this.participantes = new MeuArrayList<Usuario>();
	}
	
	public int getQuantidadeParticipantes() {
	    return this.participantes.size();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setData(String data) {
		String format = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		this.data = LocalDate.parse(data, formatter);
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}
	
	public void addParticipante(Usuario participante) throws Exception {
		if (participante == this.organizador) {
			throw new Exception("O participante informado é o organizador do evento.");
		}
		this.verificarLimitesPacote();
		this.participantes.add(participante);
		
	}
	
	protected void verificarLimitesPacote() {
		switch (this.organizador.getPacote()) {
		case GRATUITO:
			if (this.participantes.size() > 30) {
				throw new RuntimeException("O pacote gratuito permite eventos até 30 participantes");
			}
			break;
		case BASICO:
			if (this.participantes.size() > 100) {
				throw new RuntimeException("O pacote basico permite eventos até 100 participantes");
			}
			break;
		case PROFISSIONAL:
			if (this.participantes.size() > 500) {
				throw new RuntimeException("O pacote profissional permite eventos até 500 participantes");
			}
			break;

		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", data=" + data + 
				", organizador=" + organizador +
				", participantes=" + participantes + 
				"]";
	}
	

}
