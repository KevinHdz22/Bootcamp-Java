package com.protalento.jdbc.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.protalento.entidades.Empleado;
import com.protalento.entidades.Usuario;
import com.protalento.jdbc.AdministradorDeConexionMariaDB;
import com.protalento.jdbc.interfaces.IEmpleado;
import com.protalento.utilidades.Fechas;

public class EmpleadoImp implements IEmpleado{
	private PreparedStatement preparedStatementBuscarPorId;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementListar;
	private PreparedStatement preparedStatementBuscarPorTipoNumeroDoc;
	private AdministradorDeConexionMariaDB administradorDeConexionMariaDB;

	public EmpleadoImp() {
		administradorDeConexionMariaDB = new AdministradorDeConexionMariaDB();
	}
	@Override
	public Empleado buscarPorID(String k) {
		return null;
	}

	@Override
	public boolean insertar(Empleado empleado) {
		String sql = "insert into Empleados (tipoDocumento, numeroDocumento, nombre, apellido, edad, fechaNacimiento) values (?,?,?,?,?,?)";
		try {

			if (null == preparedStatementInsertar) {
				preparedStatementInsertar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setString(1, empleado.getTipoDocumento());
			preparedStatementInsertar.setString(2, empleado.getNumeroDocumento());
			preparedStatementInsertar.setString(3, empleado.getNombreEmpleado());
			preparedStatementInsertar.setString(4, empleado.getApellidoEmpleado());
			preparedStatementInsertar.setInt(5, empleado.getEdadEmpleado());
			preparedStatementInsertar.setString(6, Fechas.getString(empleado.getFechaNacimiento()));
			
			//logger.debug(preparedStatementInsertar);
			//logger.info(usuario);
			
			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			//logger.error(e);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Empleado empleado) {	
		return false;
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		return false;
	}

	@Override
	public List<Empleado> listar() {	
		return null;
	}

	

	@Override
	public Empleado buscarPorTipoNumeroDoc(String tipoDoc, String numDoc) {
		Empleado empleado = null;
		String sql = "select nombre,apellido,edad,fechaNacimiento from Empleados where tipoDocumento = ? and numeroDocumento = ?";
		try {
			if (null == preparedStatementBuscarPorTipoNumeroDoc) {
				preparedStatementBuscarPorTipoNumeroDoc = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorTipoNumeroDoc.setString(1, tipoDoc);
			preparedStatementBuscarPorTipoNumeroDoc.setString(2, numDoc);

			ResultSet resultSet = preparedStatementBuscarPorTipoNumeroDoc.executeQuery();

			if (resultSet.next()) {
				empleado = new Empleado();
				empleado.setTipoDocumento(tipoDoc);
				empleado.setNumeroDocumento(numDoc);
				empleado.setNombreEmpleado(resultSet.getString("nombre"));
				empleado.setNombreEmpleado(resultSet.getString("apellido"));
				empleado.setEdadEmpleado(resultSet.getInt("edad"));
				//empleado.setFechaNacimiento(Fechas.getString(LocalDate.parse(resultSet.getString("fechaNacimiento"))));
			}

			// logger.debug(preparedStatementBuscarPorId);

			// logger.info(usuario);

		} catch (SQLException e) {
			// logger.error(e);
			e.printStackTrace();
		}
		return empleado;
	}

	public static void main(String[] args) {
		Empleado empleado = new Empleado("CCT", "1234567", "Luan", "Perez", 20, Fechas.getLocalDate("05-10-1999"));
		
		System.out.println(empleado);
		
		EmpleadoImp iEmpleado = new EmpleadoImp();
		iEmpleado.insertar(empleado);
	}
}
