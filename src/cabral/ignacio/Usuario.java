package cabral.ignacio;

import cabral.ignacio.exception.CodigoExistente;

public abstract class Usuario {
	
	private String nombre;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void agregarFigurita(Figurita figurita) throws CodigoExistente;
}
