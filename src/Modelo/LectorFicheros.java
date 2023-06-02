package Modelo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LectorFicheros {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	public String Lector(String Archivo) {
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(Archivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "";
	}

	public List<Aeropuerto> ObtenerDatosArchivoAero(String Archivo) {
		List<Aeropuerto> Aeropuertos = new ArrayList<Aeropuerto>();
		try {
			Aeropuertos = Files.lines(Paths.get(Archivo))
					.map(l -> new Aeropuerto(
							new Coordenadas(Double.parseDouble(l.split(";")[0]), Double.parseDouble(l.split(";")[1])),
							l.split(";")[2]))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Error procesando archivos: " + e.getMessage());
		}
		// pasajeros.stream().forEach(System.out::println);
		return Aeropuertos;
	}

}
