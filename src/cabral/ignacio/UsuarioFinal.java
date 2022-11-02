package cabral.ignacio;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cabral.ignacio.exception.FiguritaNoDisponible;
import cabral.ignacio.exception.FiguritaRepetida;

public class UsuarioFinal extends Usuario {

	private List<Figurita> stockDeFiguritas = new LinkedList<Figurita>();
	private Set<Figurita> album = new TreeSet<Figurita>();

	public UsuarioFinal(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public List<Figurita> getStockDeFiguritas() {
		return stockDeFiguritas;
	}

	public void setStockDeFiguritas(List<Figurita> stockDeFiguritas) {
		this.stockDeFiguritas = stockDeFiguritas;
	}

	public Set<Figurita> getAlbum() {
		return album;
	}

	public void setAlbum(Set<Figurita> album) {
		this.album = album;
	}

	@Override
	public void agregarFigurita(Figurita figurita) {
		this.getStockDeFiguritas().add(figurita);

	}

	public void pegarFigurita(Figurita figurita) throws FiguritaRepetida {
		this.getStockDeFiguritas().remove(figurita);
		if(!(this.getAlbum().add(figurita))) {
			throw new FiguritaRepetida("No se puede pegar esta figurita, ya fue pegada anteriormente");
		}
	}

	public void intercambio(UsuarioFinal usuario, Figurita figurita) throws FiguritaNoDisponible {
//		if(!(this.getStockDeFiguritas().remove(figurita))) {
//			throw new FiguritaNoDisponible("ERROR ---El usuario no tiene o ya pegó en su album la figurita");
//		} else {
//			usuario.getStockDeFiguritas().add(figurita);
//		}
//		
		if(!(usuario.getStockDeFiguritas().contains(figurita))) {
			throw new FiguritaNoDisponible("ERROR ---El usuario no tiene o ya pegó en su album la figurita");
		} else {
			usuario.getStockDeFiguritas().remove(figurita);
			this.getStockDeFiguritas().add(figurita);
		}
	}

}
