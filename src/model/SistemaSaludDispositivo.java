package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaSaludDispositivo {
	private List<Empresa> lstEmpresas;
	private List<Dispositivo> lstDispositivos;
	
	public SistemaSaludDispositivo() {
		super();
		this.lstEmpresas = new ArrayList<Empresa>();
		this.lstDispositivos = new ArrayList<Dispositivo>();
	}

	public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		
		int id=1;
		if (lstDispositivos.size()>0) {
			int tam=lstDispositivos.size();
			id=lstDispositivos.get(tam-1).getIdDispositivo()+1;
		}
		
		
		return lstDispositivos.add(new Dispositivo(id, nombre, codigo, empresa));
	}
	
	public Dispositivo traerDispositivo(String codigo) {
		boolean disEncontrado=false;
		Dispositivo disBuscado=null;
		int i=0;
		
		while(i<lstDispositivos.size() && !disEncontrado) {
			
			if(lstDispositivos.get(i).getCodigo().equals(codigo)) {
				disEncontrado=true;
				disBuscado=lstDispositivos.get(i);
			}
			i++;
		}
		return disBuscado;
	}
	
	public Dispositivo traerDispositivoN (String nombre) {
		boolean disEncontrado=false;
		Dispositivo disBuscado=null;
		int i=0;
		
		while(i<lstDispositivos.size() && !disEncontrado) {
			
			if(lstDispositivos.get(i).getNombre().equals(nombre)) {
				disEncontrado=true;
				disBuscado=lstDispositivos.get(i);
			}
			i++;
		}
		return disBuscado;
	}
	
	public boolean agregarEmpresa(String nombre) throws Exception {
		
		if(TraerEmpresa(nombre)!=null) {
			throw new Exception("Error: la empresa ya existe");
		}
		int id=1;
		if (lstEmpresas.size()>0) {
			int tam=lstEmpresas.size();
			id=lstEmpresas.get(tam-1).getIdEmpresa()+1;
		}
		
		return lstEmpresas.add(new Empresa(id, nombre));
	}
	
	public Empresa TraerEmpresa(String nombre) {
		boolean empresaEncontrada=false;
		Empresa empresaBuscada=null;
		int i=0;
		
		while(i<lstEmpresas.size() && !empresaEncontrada) {
			
			if(lstEmpresas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				empresaEncontrada=true;
				empresaBuscada=lstEmpresas.get(i);
			}
			
			i++;
		}
		return empresaBuscada;
	}
	
	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}
	public void setLstEmpresas(List<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
	}
	public List<Dispositivo> getLstDispositivos() {
		return lstDispositivos;
	}
	public void setLstDispositivos(List<Dispositivo> lstDispositivos) {
		this.lstDispositivos = lstDispositivos;
	}

}
