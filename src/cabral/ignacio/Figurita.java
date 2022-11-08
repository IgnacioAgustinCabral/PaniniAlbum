package cabral.ignacio;

import java.util.List;
import java.util.Objects;

public class Figurita implements Comparable<Figurita>{
	private Integer numeroFigurita;
	private String grupo;
	private String seleccion;
	private String jugador;
	private Double precio;
	private String codigoId;

	public Figurita(Integer numeroFigurita, String grupo, String seleccion, String jugador, Double precio) {
		super();
		this.numeroFigurita = numeroFigurita;
		this.grupo = grupo;
		this.seleccion = seleccion;
		this.jugador = jugador;
		this.precio = precio;
		this.codigoId = seleccion + numeroFigurita;
	}

	public Integer getNumeroFigurita() {
		return numeroFigurita;
	}

	public void setNumeroFigurita(Integer numeroFigurita) {
		this.numeroFigurita = numeroFigurita;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}

	public void pasarADolar() {
		this.setPrecio(this.getPrecio()*300);
		
	}
	
	public Double pasarADolar2() {
		return this.getPrecio()*300;
	}
	 
	@Override
	public int hashCode() {
		return Objects.hash(codigoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(codigoId, other.codigoId);
	}

	@Override
	public int compareTo(Figurita o) {
		if(this.getGrupo().equals(o.getGrupo())) {
			if(this.getSeleccion().equals(o.getSeleccion())) {
				return this.getNumeroFigurita().compareTo(o.getNumeroFigurita());
			} return this.getSeleccion().compareTo(o.getSeleccion());
		}return this.getGrupo().compareTo(o.getGrupo());
	}

	@Override
	public String toString() {
		return "Figurita [numeroFigurita=" + numeroFigurita + ", grupo=" + grupo + ", seleccion=" + seleccion
				+ ", jugador=" + jugador + ", precio=" + precio + ", codigoId=" + codigoId + "]";
	}
	
}
