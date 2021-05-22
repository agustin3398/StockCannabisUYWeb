package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import controlador.ControladorEmpresaFarmaciaRemote;
import entidades.EmpresaFarmacia;
import entidades.TransaccionStockFarmacia;
import entidades.Usuario;

@ManagedBean(name = "empresaFarmaciaBean")
@SessionScoped
public class EmpresaFarmaciaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7497636567590305063L;

	private int idempresaFarmacia;
	private String departamento;
	private String direccion;
	private String localidad;
	private String nombreFantasia;
	private String razonSocial;
	private String rut;
	private List<TransaccionStockFarmacia> transaccionStockFarmacias;
	private Usuario usuario;
	private List<EmpresaFarmacia> empresas = null;

	@EJB
	private ControladorEmpresaFarmaciaRemote controlador;

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

	public int getIdempresaFarmacia() {
		return idempresaFarmacia;
	}

	public void setIdempresaFarmacia(int idempresaFarmacia) {
		this.idempresaFarmacia = idempresaFarmacia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}

	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public List<TransaccionStockFarmacia> getTransaccionStockFarmacias() {
		return transaccionStockFarmacias;
	}

	public void setTransaccionStockFarmacias(List<TransaccionStockFarmacia> transaccionStockFarmacias) {
		this.transaccionStockFarmacias = transaccionStockFarmacias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
