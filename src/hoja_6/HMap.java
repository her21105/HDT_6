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
	Map<categorizar,producto> listaUsuario = new HashMap<categorizar, producto>() ;
	Map<categorizar,String> listaProducto = new HashMap<categorizar, String>();
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
		System.out.println("ingrese la categoria que desea comprar");
		String categoria = scan.nextLine();
		
		if(ComprobarCategoria(categoria) == true) {//analizar si la categoria 
			
			for (int i = 0; i< varios; i++) {
				
				
				String nombre = scan.nextLine();
				
				if(ComprobarProducto(nombre, categoria)) {
					
					System.out.println("ingrese la cantidad de produco que desea");
					int cantidad = Integer.parseInt(scan.nextLine());
					IngresoUsuario(categoria,i, nombre, cantidad);
					
				}
				
				
			}
			
		}else {
			
			System.out.println("escriba una categoria existente");
			
		}
	}
	
	public boolean ComprobarCategoria(String categoria) {
		
		
		for (int i = 0; i < categorias.size(); i++) {
			

			
			if(categorias.get(i).equalsIgnoreCase(categoria)) {
				

				return true;
				
			}
			
		}
			
		return false;
		
	}
	
	public boolean ComprobarProducto(String producto, String categoria3) {
		
		muestra(categoria3);
		
		for (int i = 0; i < NombreProductos.size(); i++) {
			
			if(NombreProductos.get(i).equalsIgnoreCase(producto)) {
				
				return true;
				
			}
			
		NombreProductos.clear();
			
		}
		
		
		return false;
	}
	
	public void muestra(String categoria2) {
		
		if(ComprobarCategoria(categoria2)) {
			listaProducto.entrySet().forEach(entry->{
				
				if(categoria2.equalsIgnoreCase(entry.getKey().getCategoria()) == true) {
					
					NombreProductos.add(entry.getValue());
				}

			});	
		
		}
		
	}
	
	
	
	public void IngresoProducto() throws FileNotFoundException {
		
        File file = new File("C:\\Users\\Joabh\\Documents\\workplace\\hoja_6\\src\\hoja_6\\ListadoProducto.txt");
        Scanner s = new Scanner(file);
        
        
        int i = 0;
        
        while (s.hasNextLine()){
        	
        	i++;
        	
            String linea = s.nextLine();
            String[] items = linea.split("\\|");
            
            String categoria = items[0];
            String nombre = items[1];
            
            categorizar B2 = new categorizar(i, categoria);
            listaProducto.put(B2, nombre);
            
            
            categorias.add(categoria.trim());
            
            
            
            
        }
        s.close();
        
        
		
	}


	
	public void ImprimirProducto() {
		// TODO Auto-generated method stub
	listaProducto.entrySet().forEach(entry->{
				
				System.out.println(entry.getKey().getCategoria() + " | "+ entry.getValue());
	
			});	
		
	}

	
	public void ImprimirProductoFiltro(String filtro) {
		// TODO Auto-generated method stub
		
		if(ComprobarCategoria(filtro)) {
			listaProducto.entrySet().forEach(entry->{
				
				
				if(filtro.equalsIgnoreCase(entry.getKey().getCategoria()) == true) {
					System.out.println(entry.getKey() + " | "+ entry.getValue());
				}

			});	
			
		}else {
			System.out.println("escriba la categoria correctamente");
		
		
		}
	}


	public void ImprimirUsuario() {
		// TODO Auto-generated method stub
		
		listaUsuario.entrySet().forEach(entry->{
			
			System.out.println(entry.getKey() + " | "+ entry.getValue());

		});	
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
