package hoja_6;

import java.util.Map;

public class Factory implements MainFactory {

	@Override
	public estructura crearOrdenamiento(String orden) {
		// TODO Auto-generated method stub
		//aqui se crean HMap, LHMap y TMap
		
		if(orden.equalsIgnoreCase("HashMap")) {
			
			return  new HMap();
			
		}
		else if(orden.equalsIgnoreCase("LinkedHashMap")) {
			
			return new LHMap();
			
		}else if(orden.equalsIgnoreCase("TreeMap")) {
			
			return  new TMap();
			
		}else {
			
			return null;
			
		}
		
	}

}
