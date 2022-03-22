package hoja_6;

import java.io.FileNotFoundException;

public interface estructura {

	
public void IngresoUsuario(String categoria, String nombre, int cantidad);

public void IngresoVariosUsuario(int varios);

public boolean ComprobarCategoria(String categoria);

public void IngresoProducto() throws FileNotFoundException;

public void ImprimirProducto();

public void ImprimirProductoFiltro();

public void ImprimirUsuario();

public void ImprimirUsuarioFiltro();

}
