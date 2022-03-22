package hoja_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TMap implements estructura {
	
	Map<categorizar,producto> listaUsuario = new TreeMap<categorizar, producto>() ;
	Map<String,String> listaProducto = new TreeMap<String, String>();
	ArrayList <String> categorias = new ArrayList <String> ();
	ArrayList <String> NombreProductos = new ArrayList <String>();
	
	
	
	public void IngresoUsuario(String categoria, int Num, String nombre, int cantidad) {
		
		//necesita un comparador para saber si existe una x categoria
		
		producto A1 = new producto(nombre, cantidad);
		categorizar B1 = new categorizar(Num, categoria);
		
		listaUsuario.put(B1, A1);

	}
	
	
	public void IngresoVariosUsuario(int varios) {
		
		Scanner scan = new Scanner(System.in); //primero ingreso de la categoria
		String categoria = scan.nextLine();
		
		if(ComprobarCategoria(categoria)) {//analizar si la categoria 
			
			for (int i = 0; i< varios; i++) {
				
				String nombre = scan.nextLine();
				int cantidad = Integer.parseInt(scan.nextLine());
				IngresoUsuario(categoria,i, nombre, cantidad);
				
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
	
	public void IngresoProducto() throws FileNotFoundException {
		
        File file = new File("C:\\Users\\Joabh\\Documents\\workplace\\hoja_6\\src\\hoja_6\\ListadoProducto.txt");
        Scanner s = new Scanner(file);
        
        while (s.hasNextLine()){
            String linea = s.nextLine();
            String[] items = linea.split("\\|");
            
            String categoria = items[0];
            String nombre = items[1];

            listaProducto.put(categoria, nombre);
            categorias.add(categoria);
            
        }
        s.close();
		
	}


	
	public void ImprimirProducto() {
		// TODO Auto-generated method stub
		System.out.println(listaProducto);
		
	}

	
	public void ImprimirProductoFiltro(String filtro) {
		// TODO Auto-generated method stub
		
		if(ComprobarCategoria(filtro)) {
			listaProducto.entrySet().forEach(entry->{
				
				
				if(filtro.equalsIgnoreCase(entry.getKey()) == true) {
					System.out.println(entry.getKey() + " | "+ entry.getValue());
				}

			});	
			
		}else {
			System.out.println("escriba la categoria correctamente");
		
		
		}
	}


	public void ImprimirUsuario() {
		// TODO Auto-generated method stub
		System.out.println(listaUsuario);
		
	}

	public void ImprimirUsuarioFiltro(String filtro) {
		// TODO Auto-generated method stub
		if(ComprobarCategoria(filtro)) {
			listaUsuario.entrySet().forEach(entry->{
				
				
				if(filtro.equalsIgnoreCase(entry.getKey().getCategoria()) == true) {
					System.out.println(entry.getKey() + " | "+ entry.getValue());
				}

			});	
			
		}else {
			System.out.println("escriba la categoria correctamente");
		
		
		}
	}

	
}
