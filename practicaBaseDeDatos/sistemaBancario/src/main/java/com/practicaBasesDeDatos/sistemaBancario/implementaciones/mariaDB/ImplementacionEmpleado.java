package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.Empleado;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionEmpleado implements DAO<Empleado, Integer>, ConexionMariaDB {
	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Empleado buscarPorId(Integer id) {
		Empleado empleado = null;
		String sql = "select nombre, telefono, fechaIngreso, idJefe from empleados where id = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				empleado = new Empleado();
				empleado.setId(id);
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setTelefono(resultSet.getString("telefono"));
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("fechaIngreso"));
				empleado.setFechaIngreso(date1);
				empleado.setIdJefe(resultSet.getInt("idJefe"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return empleado;
	}

	@Override
	public boolean insertar(Empleado empleado) {
		// Evitar java.lang.NullPointerException
		if (empleado == null) {
			return false;
		}

		String sql = "insert into empleados (id, nombre, telefono, fechaIngreso, idJefe) values (?,?,?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			preparedStatementInsertar.setInt(1, empleado.getId());
			preparedStatementInsertar.setString(2, empleado.getNombre());
			preparedStatementInsertar.setString(3, empleado.getTelefono());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaComoCadena = sdf.format(empleado.getFechaIngreso());
			preparedStatementInsertar.setString(4, fechaComoCadena);
			preparedStatementInsertar.setInt(5, empleado.getIdJefe());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Empleado empleado) {
		// Evitar java.lang.NullPointerException
		if (empleado == null) {
			return false;
		}

		String sql = "update empleados set nombre = ?, telefono = ?, fechaIngreso = ?, idJefe = ? where id = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, empleado.getNombre());
			preparedStatementModificar.setString(2, empleado.getTelefono());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaComoCadena = sdf.format(empleado.getFechaIngreso());
			preparedStatementModificar.setString(3, fechaComoCadena);
			preparedStatementModificar.setInt(4, empleado.getIdJefe());
			preparedStatementModificar.setInt(5, empleado.getId());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		// Evitar java.lang.NullPointerException
		if (empleado == null) {
			return false;
		}

		String sql = "delete from empleados where id = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, empleado.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Empleado> listar() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		String sql = "select id, nombre, telefono, fechaIngreso, idJefe from empleados";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(resultSet.getInt("id"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setTelefono(resultSet.getString("telefono"));
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("fechaIngreso"));
				empleado.setFechaIngreso(date1);
				empleado.setIdJefe(resultSet.getInt("idJefe"));
				empleados.add(empleado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return empleados;
	}

}
