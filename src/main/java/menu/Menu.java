package menu;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.*;

public class Menu {
	
	
	public static Ciudad PedirDatosCiudad() {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Nombre de la ciudad:");
	    String nombre = scanner.nextLine();
	    
	    System.out.println("Población:");
	    int poblacion = Integer.parseInt(scanner.nextLine());
	    
	    System.out.println("Ubicación Geográfica:");
	    String ubicacionGeografica = scanner.nextLine();
	    
	    
	    Ciudad nuevaCiudad = new Ciudad();
	    nuevaCiudad.setNombre(nombre);
	    nuevaCiudad.setPoblacion(poblacion);
	    nuevaCiudad.setUbicacionGeografica(ubicacionGeografica);
	    
	    return nuevaCiudad;
	}

	public static Deportista PedirDatosDeportista() {
		Scanner scanner = new Scanner(System.in);
		 System.out.print("Nombre: ");
	        String nombre = scanner.nextLine();
	        
	        System.out.print("Edad: ");
	        int edad = Integer.parseInt(scanner.nextLine());
	        
	        System.out.print("Género: ");
	        String genero = scanner.nextLine();
	        
	        System.out.print("Email: ");
	        String email = scanner.nextLine();
	        
	        System.out.print("Teléfono: ");
	        int telefono = Integer.parseInt(scanner.nextLine());
	        
	        System.out.print("DNI: ");
	        String dni = scanner.nextLine();
	        
	        Deportista nuevoDeportista = new Deportista();
	        nuevoDeportista.setNombre(nombre);
	        nuevoDeportista.setEdad(edad);
	        nuevoDeportista.setGenero(genero);
	        nuevoDeportista.setEmail(email);
	        nuevoDeportista.setTelefono(telefono);
	        nuevoDeportista.setDni(dni);
	        
	        
	        return nuevoDeportista;
	}
}
