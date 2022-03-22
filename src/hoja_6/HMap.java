package hoja_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HMap implements estructura {

	
	//crear objetos
	//producto
	
	//crear HashMap
	Map<String,producto> listaUsuario = new HashMap<String, producto>() ;
	Map<String,String> listaProducto = new HashMap<String, String>();
	ArrayList <String> categorias = new ArrayList <String> ();
	
	
	public void ingresoUsuario(String categoria, String nombre, int cantidad) {
		
		//necesita un comparador para saber si existe una x categoria
		
		producto A1 = new producto(nombre, cantidad);
		
		listaUsuario.put(categoria, A1);
		
		
		
	}
	
	public void ingresoVariosUsuario(int varios) {
		
		Scanner scan = new Scanner(System.in); //primero ingreso de la categoria
		String categoria = scan.nextLine();
		
		if(ComprobarCategoria(categoria)) {//analizar si la categoria 
			
			for (int i = 0; i< varios; i++) {
				
				String nombre = scan.nextLine();
				int cantidad = Integer.parseInt(scan.nextLine());
				ingresoUsuario(categoria, nombre, cantidad);
				
			}
			
		}else {
			
			System.out.println("escriba una categoria existente");
			
		}
	}
	
	public boolean ComprobarCategoria(String categoria) {
		
		for (int i = 0; i < categorias.size(); i++) {
			
			if(categorias.get(i).equalsIgnoreCase(categoria) == true) {
				
				return true;
				
				
			}
			
		}
			
		return false;
		
	}
	
	public void ingresoProducto() throws FileNotFoundException {
		
		ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File("C:\\Users\\Joabh\\Documents\\workplace\\hoja_6\\src\\hoja_6\\ListadoProducto.txt");
        Scanner s = new Scanner(file);
        
        while (s.hasNextLine()){
            String linea = s.nextLine();
            String[] items = linea.split("\\|");
            
            String categoria = items[0];
            String nombre = items[1];

            listaProducto.put(categoria, nombre);
            categorias.add(categoria);
            System.out.println(categoria +" "+nombre);
        }
        s.close();
		
	}

	
	
	
	
}
