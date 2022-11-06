package cabral.ignacio;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import cabral.ignacio.exception.CodigoExistente;
import cabral.ignacio.exception.FiguritaNoDisponible;
import cabral.ignacio.exception.FiguritaRepetida;

public class PaniniTest {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Integer numeroFigurita = 10;
		String grupo = "C";
		String seleccion = "Argentina";
		String jugador = "Lionel Messi";
		Double precio = 300000000.00;
		Figurita figurita = new Figurita(numeroFigurita, grupo, seleccion, jugador, precio);

		assertNotNull(figurita);
	}

	@Test
	public void queSePuedaCrearUnAdministrador() {
		String nombre = "Juan";
		Usuario admin = new Administrador(nombre);
		assertNotNull(admin);
	}

	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);
		assertNotNull(user);
	}

	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
		String nombre = "Juan";
		Usuario admin = new Administrador(nombre);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		try {
			admin.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		Integer esperado = 1;
		Integer actual = ((Administrador) admin).getBaseDeDatosFiguritasGeneradas().size();

		assertEquals(esperado, actual);

	}

	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita1 = 7;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lo Celso";
		Double precio1 = 300000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		Integer esperado = 1;
		Integer actual = ((UsuarioFinal) user).getStockDeFiguritas().size();

		assertEquals(esperado, actual);

	}

	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 150.00;

		Integer numeroFigurita4 = 11;
		String grupo4 = "G";
		String seleccion4 = "Brasil";
		String jugador4 = "Richarlison";
		Double precio4 = 200.00;

		Integer numeroFigurita3 = 1;
		String grupo3 = "C";
		String seleccion3 = "Argentina";
		String jugador3 = "Martinez";
		Double precio3 = 150.00;

		Integer numeroFigurita1 = 7;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lo Celso";
		Double precio1 = 120.00;

		Integer numeroFigurita5 = 7;
		String grupo5 = "E";
		String seleccion5 = "Inglaterra";
		String jugador5 = "Harry Kane";
		Double precio5 = 100.00;

		Integer numeroFigurita6 = 7;
		String grupo6 = "F";
		String seleccion6 = "Belgica";
		String jugador6 = "De Bruyne";
		Double precio6 = 100.00;

		Integer numeroFigurita7 = 7;
		String grupo7 = "A";
		String seleccion7 = "Uruguay";
		String jugador7 = "Luis Suarez";
		Double precio7 = 90.00;

		Integer numeroFigurita8 = 7;
		String grupo8 = "C";
		String seleccion8 = "Mexico";
		String jugador8 = "Chicarito";
		Double precio8 = 80.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		Figurita figurita6 = new Figurita(numeroFigurita6, grupo6, seleccion6, jugador6, precio6);

		Figurita figurita7 = new Figurita(numeroFigurita7, grupo7, seleccion7, jugador7, precio7);

		Figurita figurita8 = new Figurita(numeroFigurita8, grupo8, seleccion8, jugador8, precio8);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita6);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita7);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita8);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		Integer esperado = 8;
		Integer actual = ((UsuarioFinal) user).getStockDeFiguritas().size();

		assertEquals(esperado, actual);
	}

	@Test(expected = CodigoExistente.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistente {
		String nombre = "Juan";
		Usuario admin = new Administrador(nombre);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Integer numeroFigurita3 = 10;
		String grupo3 = "D";
		String seleccion3 = "Francia";
		String jugador3 = "Mbappe";
		Double precio3 = 200000000.00;

		Integer numeroFigurita4 = 7;
		String grupo4 = "C";
		String seleccion4 = "Argentina";
		String jugador4 = "Lo Celso";
		Double precio4 = 150000000.00;

		Integer numeroFigurita5 = 7;
		String grupo5 = "C";
		String seleccion5 = "Argentina";
		String jugador5 = "Lo Celso";
		Double precio5 = 150000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		admin.agregarFigurita(figurita1);

		admin.agregarFigurita(figurita2);

		admin.agregarFigurita(figurita3);

		admin.agregarFigurita(figurita4);

		admin.agregarFigurita(figurita5);

	}

//	@Test
//	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
//		String nombre = "Pedro";
//		Usuario user = new UsuarioFinal(nombre);
//		
//	}
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			((UsuarioFinal) user).pegarFigurita(figurita2);
		} catch (FiguritaRepetida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer cantidadDeFiguritasEnAlbumEsperada = 1;
		Integer cantidadDeFiguritasEnAlbum = ((UsuarioFinal) user).getAlbum().size();

		assertEquals(cantidadDeFiguritasEnAlbumEsperada, cantidadDeFiguritasEnAlbum);
	}

	@Test(expected = FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Integer numeroFigurita3 = 10;
		String grupo3 = "G";
		String seleccion3 = "Brasil";
		String jugador3 = "Neymar";
		Double precio3 = 250000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		((UsuarioFinal) user).pegarFigurita(figurita1);
		((UsuarioFinal) user).pegarFigurita(figurita2);
		((UsuarioFinal) user).pegarFigurita(figurita3);

	}

	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() {
		String nombre1 = "Pedro";
		Usuario user1 = new UsuarioFinal(nombre1);

		String nombre2 = "Juan";
		Usuario user2 = new UsuarioFinal(nombre2);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Integer numeroFigurita3 = 10;
		String grupo3 = "D";
		String seleccion3 = "Francia";
		String jugador3 = "Mbappe";
		Double precio3 = 200000000.00;

		Integer numeroFigurita4 = 7;
		String grupo4 = "C";
		String seleccion4 = "Argentina";
		String jugador4 = "Lo Celso";
		Double precio4 = 150000000.00;

		Integer numeroFigurita5 = 10;
		String grupo5 = "F";
		String seleccion5 = "Belgica";
		String jugador5 = "De Bruyne";
		Double precio5 = 250000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		try {
			user1.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user1.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		////////////// INTERCAMBIO////////////
		try {
			((UsuarioFinal) user1).intercambio((UsuarioFinal) user2, figurita1);
		} catch (FiguritaNoDisponible e) {
			e.printStackTrace();
		}

		Integer cantFiguritasEsperadasUsuario2 = 4;
		Integer cantFiguritasUsuario2 = ((UsuarioFinal) user2).getStockDeFiguritas().size();

		assertEquals(cantFiguritasEsperadasUsuario2, cantFiguritasUsuario2);

	}

	@Test(expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaNoDisponible {
		String nombre1 = "Pedro";
		Usuario user1 = new UsuarioFinal(nombre1);

		String nombre2 = "Juan";
		Usuario user2 = new UsuarioFinal(nombre2);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Integer numeroFigurita3 = 10;
		String grupo3 = "D";
		String seleccion3 = "Francia";
		String jugador3 = "Mbappe";
		Double precio3 = 200000000.00;

		Integer numeroFigurita4 = 7;
		String grupo4 = "C";
		String seleccion4 = "Argentina";
		String jugador4 = "Lo Celso";
		Double precio4 = 150000000.00;

		Integer numeroFigurita5 = 10;
		String grupo5 = "F";
		String seleccion5 = "Belgica";
		String jugador5 = "De Bruyne";
		Double precio5 = 250000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		try {
			user1.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user1.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		/////// INTERCAMBIO///////

		((UsuarioFinal) user1).intercambio((UsuarioFinal) user2, figurita1);

	}

	@Test(expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaNoDisponible {
		String nombre1 = "Pedro";
		Usuario user1 = new UsuarioFinal(nombre1);

		String nombre2 = "Juan";
		Usuario user2 = new UsuarioFinal(nombre2);

		Integer numeroFigurita1 = 10;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lionel Messi";
		Double precio1 = 300000000.00;

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 250000000.00;

		Integer numeroFigurita3 = 10;
		String grupo3 = "D";
		String seleccion3 = "Francia";
		String jugador3 = "Mbappe";
		Double precio3 = 200000000.00;

		Integer numeroFigurita4 = 7;
		String grupo4 = "C";
		String seleccion4 = "Argentina";
		String jugador4 = "Lo Celso";
		Double precio4 = 150000000.00;

		Integer numeroFigurita5 = 10;
		String grupo5 = "F";
		String seleccion5 = "Belgica";
		String jugador5 = "De Bruyne";
		Double precio5 = 250000000.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		try {
			user1.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user1.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user2.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		///// LA PEGA EN EL ALBUM/////

		try {
			((UsuarioFinal) user2).pegarFigurita(figurita4);
		} catch (FiguritaRepetida e) {
			e.printStackTrace();
		}
		/////// INTERCAMBIO///////
		/// EL USUARIO 1 QUIERE LA FIGURITA DE USUARIO 2///
		((UsuarioFinal) user1).intercambio((UsuarioFinal) user2, figurita4);
	}

	@Test
	public void filter() {
		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 150.00;

		Integer numeroFigurita4 = 11;
		String grupo4 = "G";
		String seleccion4 = "Brasil";
		String jugador4 = "Richarlison";
		Double precio4 = 200.00;

		Integer numeroFigurita3 = 1;
		String grupo3 = "C";
		String seleccion3 = "Argentina";
		String jugador3 = "Martinez";
		Double precio3 = 150.00;

		Integer numeroFigurita1 = 7;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lo Celso";
		Double precio1 = 120.00;

		Integer numeroFigurita5 = 7;
		String grupo5 = "E";
		String seleccion5 = "Inglaterra";
		String jugador5 = "Harry Kane";
		Double precio5 = 100.00;

		Integer numeroFigurita6 = 7;
		String grupo6 = "F";
		String seleccion6 = "Belgica";
		String jugador6 = "De Bruyne";
		Double precio6 = 100.00;

		Integer numeroFigurita7 = 7;
		String grupo7 = "A";
		String seleccion7 = "Uruguay";
		String jugador7 = "Luis Suarez";
		Double precio7 = 90.00;

		Integer numeroFigurita8 = 7;
		String grupo8 = "C";
		String seleccion8 = "Mexico";
		String jugador8 = "Chicarito";
		Double precio8 = 80.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		Figurita figurita6 = new Figurita(numeroFigurita6, grupo6, seleccion6, jugador6, precio6);

		Figurita figurita7 = new Figurita(numeroFigurita7, grupo7, seleccion7, jugador7, precio7);

		Figurita figurita8 = new Figurita(numeroFigurita8, grupo8, seleccion8, jugador8, precio8);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita6);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita7);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita8);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		// me traigo el stock de figuritas
		List<Figurita> figuritas = ((UsuarioFinal) user).getStockDeFiguritas();

		List<Figurita> grupoC = figuritas.stream().filter((f) -> f.getGrupo().startsWith("C"))
				.collect(Collectors.toList());

		// recorro la nueva lista y muestro el nombre de jugadores
		grupoC.forEach((x) -> System.out.println(x.getJugador()));
	}

	@Test
	public void map() {

		String nombre = "Pedro";
		Usuario user = new UsuarioFinal(nombre);

		Integer numeroFigurita2 = 10;
		String grupo2 = "G";
		String seleccion2 = "Brasil";
		String jugador2 = "Neymar";
		Double precio2 = 150.00;

		Integer numeroFigurita4 = 11;
		String grupo4 = "G";
		String seleccion4 = "Brasil";
		String jugador4 = "Richarlison";
		Double precio4 = 200.00;

		Integer numeroFigurita3 = 1;
		String grupo3 = "C";
		String seleccion3 = "Argentina";
		String jugador3 = "Martinez";
		Double precio3 = 150.00;

		Integer numeroFigurita1 = 7;
		String grupo1 = "C";
		String seleccion1 = "Argentina";
		String jugador1 = "Lo Celso";
		Double precio1 = 120.00;

		Integer numeroFigurita5 = 7;
		String grupo5 = "E";
		String seleccion5 = "Inglaterra";
		String jugador5 = "Harry Kane";
		Double precio5 = 100.00;

		Integer numeroFigurita6 = 7;
		String grupo6 = "F";
		String seleccion6 = "Belgica";
		String jugador6 = "De Bruyne";
		Double precio6 = 100.00;

		Integer numeroFigurita7 = 7;
		String grupo7 = "A";
		String seleccion7 = "Uruguay";
		String jugador7 = "Luis Suarez";
		Double precio7 = 90.00;

		Integer numeroFigurita8 = 7;
		String grupo8 = "C";
		String seleccion8 = "Mexico";
		String jugador8 = "Chicarito";
		Double precio8 = 80.00;

		Figurita figurita1 = new Figurita(numeroFigurita1, grupo1, seleccion1, jugador1, precio1);

		Figurita figurita2 = new Figurita(numeroFigurita2, grupo2, seleccion2, jugador2, precio2);

		Figurita figurita3 = new Figurita(numeroFigurita3, grupo3, seleccion3, jugador3, precio3);

		Figurita figurita4 = new Figurita(numeroFigurita4, grupo4, seleccion4, jugador4, precio4);

		Figurita figurita5 = new Figurita(numeroFigurita5, grupo5, seleccion5, jugador5, precio5);

		Figurita figurita6 = new Figurita(numeroFigurita6, grupo6, seleccion6, jugador6, precio6);

		Figurita figurita7 = new Figurita(numeroFigurita7, grupo7, seleccion7, jugador7, precio7);

		Figurita figurita8 = new Figurita(numeroFigurita8, grupo8, seleccion8, jugador8, precio8);

		try {
			user.agregarFigurita(figurita1);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita2);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita3);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita4);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita5);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita6);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}
		try {
			user.agregarFigurita(figurita7);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		try {
			user.agregarFigurita(figurita8);
		} catch (CodigoExistente e) {
			e.printStackTrace();
		}

		// me traigo el stock de figuritas
		List<Figurita> figuritas = ((UsuarioFinal) user).getStockDeFiguritas();

		List<Figurita> figuritasEnDolares = figuritas.stream().map(e -> {
			Figurita n = new Figurita(e.getNumeroFigurita(), e.getGrupo(), e.getSeleccion(), e.getJugador(),
					e.getPrecio());
			n.pasarADolar();
			return n;
		}).collect(Collectors.toList());
		figuritasEnDolares.forEach(x -> System.out.println(x.toString()));
	}
}
