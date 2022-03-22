package hoja_6;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//menu 
		/* 
		 * debe tener
		 * 1. agregar producto y puede agregar más de uno a una misma categoria
		 * 2. ingresar el nombre de un producto y mostrar su categoria
		 * 3. mostrar en la lista del usuario cada producto con = nombre producto, categiro, cantidad
		 * 4. mostrar la lista del usuario ordenada por tipo (que el usuario decida que tipo)
		 * 5. mostrar el producto y la categoria de todo el inventario
		 * 6. mostrar el producto y categia existentes, ordenadas por tipo
		 */
		
		//contructor de factory
		
		Factory organizar = new Factory();
		
		estructura tipoListas = null;
		
		Scanner userInput = new Scanner(System.in);
		
		boolean actividad = true;
		
		//selección en factory
		
		System.out.println("tipo de orden (HashMap / TreeMap / LinkedHashMap)");
		
		if(userInput.hasNextLine()) {
			
			String tipo = userInput.nextLine();
			
			tipoListas = organizar.crearOrdenamiento(tipo);
			
		}
		
			
			tipoListas.IngresoProducto();
		
			do {
				
				//menu
				
				if(tipoListas != null) {
					
					System.out.println("seleccione que quiere realizar \n"
							+ "1.mostrar productos con categorias \n"
							+ "2. mostrar producto por una categoria seleccionada \n"
							+ "3. mostrar lista del usuario \n"
							+ "4. mostrar lista del usuario por una categoria seleccionada \n"
							+ "5. agregar producto");//sub menu en agregar producto donde pregunta la cantidad de productos de una categoria quiere agregar
					
					int selección = Integer.parseInt(userInput.nextLine());
					
					switch(selección) {
					
					case 1:
						
						tipoListas.ImprimirProducto();
						
						break;
					
					case 2:
						
						String filtro = userInput.nextLine();
						
						tipoListas.ImprimirProductoFiltro(filtro);
						
						break;
						
					case 3:
						
						tipoListas.ImprimirUsuario();
						
						break;
						
					case 4: 
						
						String filtro2 = userInput.nextLine();
						
						tipoListas.ImprimirProductoFiltro(filtro2);
						
						break;
						
					case 5:
						
						System.out.println("cuantos productos de una categoria desea agregar?");
						
						int varios = Integer.parseInt(userInput.nextLine());
						
						tipoListas.IngresoVariosUsuario(varios);
						
						break;
						
					default:
							
						System.out.println("seleccione una opción valida");
						
						break;
						
					}
					
					
				}else {
					System.out.println("escoja una opción valida");
					actividad = false;
				}
				
				
				System.out.println("desea salir del sistema? Y/N");
				String des = userInput.nextLine();
				if(des.equalsIgnoreCase("N")) {
					actividad = false;
				}
				
			}while(actividad = true);
			
			
			
			
			
			
			
			
		
		
		
		
	}

}
