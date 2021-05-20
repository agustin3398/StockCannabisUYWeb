package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import controlador.ControladorEmpresaFarmaciaRemote;
import entidades.EmpresaFarmacia;

@ManagedBean(name ="empresaFarmaciaBeanDTT")
@SessionScoped
public class EmpresaFarmaciaBeanDT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5356325535158861445L;
	@EJB
	private ControladorEmpresaFarmaciaRemote controlador;
	private List<EmpresaFarmacia> empresas = null;

	@PostConstruct
	public void obtenerTodasEmpresasFarmacias() {
		try {
			empresas = controlador.obtenerTodasEmpresaFarmacia();
			System.out.println(empresas.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hubo un error al crear obtenerTodasEmpresasFarmacias");
			System.out.println("Clase: EmpresaFarmaciaBean");
			System.out.println("Metodo: obtenerTodasEmpresasFarmacias");
			System.out.println("****************************");
		}

	}

	public List<EmpresaFarmacia> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaFarmacia> empresas) {
		this.empresas = empresas;
	}

}
