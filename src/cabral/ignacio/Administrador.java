package cabral.ignacio;

import java.util.Set;
import java.util.TreeSet;

import cabral.ignacio.exception.CodigoExistente;

public class Administrador extends Usuario {

	private Set<Figurita> baseDeDatosFiguritasGeneradas = new TreeSet<Figurita>();

	public Administrador(String nombre) {
		super(nombre);
	}

	@Override
	public void agregarFigurita(Figurita figurita) throws CodigoExistente{
		if(!this.getBaseDeDatosFiguritasGeneradas().add(figurita)) {
			throw new CodigoExistente("Esta figurita ya existe");
		}
		
	}

	public Set<Figurita> getBaseDeDatosFiguritasGeneradas() {
		return baseDeDatosFiguritasGeneradas;
	}

	public void setBaseDeDatosFiguritasGeneradas(Set<Figurita> baseDeDatosFiguritasGeneradas) {
		this.baseDeDatosFiguritasGeneradas = baseDeDatosFiguritasGeneradas;
	}

}
