package hoja_6;

public class producto {
	
	private String nombre;
	private int cantidad;
	
	
	public producto(String nombre, int cantidad) {
		
		this.setNombre(nombre);
		this.setCantidad(cantidad);
		
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
