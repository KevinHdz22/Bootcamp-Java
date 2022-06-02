package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.Cliente;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionCliente implements DAO<Cliente, Integer>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;
	
	@Override
	public Cliente buscarPorId(Integer id) {
		Cliente cliente = null;
		String sql = "select id, nombre, calle, ciudad, id_empleado from clientes where id = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setId(id);
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setCalle(resultSet.getString("calle"));
				cliente.setCiudad(resultSet.getString("ciudad"));
				cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public boolean insertar(Cliente cliente) {
		// Evitar java.lang.NullPointerException
		if (cliente == null) {
			return false;
		}

		String sql = "insert into clientes (id, nombre, calle, ciudad, id_empleado) values (?,?,?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setInt(1, cliente.getId());
			preparedStatementInsertar.setString(2, cliente.getNombre());
			preparedStatementInsertar.setString(3, cliente.getCalle());
			preparedStatementInsertar.setString(4, cliente.getCiudad());
			preparedStatementInsertar.setInt(5, cliente.getIdEmpleado());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Cliente cliente) {
		// Evitar java.lang.NullPointerException
		if (cliente == null) {
			return false;
		}

		String sql = "update clientes set nombre = ? where id = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, cliente.getNombre());
			preparedStatementModificar.setInt(2, cliente.getId());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Cliente cliente) {
		// Evitar java.lang.NullPointerException
		if (cliente == null) {
			return false;
		}

		String sql = "delete from clientes where id = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, cliente.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select id, nombre, calle, ciudad, id_empleado from clientes";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setCalle(resultSet.getString("calle"));
				cliente.setCiudad(resultSet.getString("ciudad"));
				cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	
	}

}
