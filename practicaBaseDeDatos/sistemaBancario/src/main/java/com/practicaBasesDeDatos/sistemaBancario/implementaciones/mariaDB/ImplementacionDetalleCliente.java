package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.DetalleCliente;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionDetalleCliente implements DAO<DetalleCliente, Integer>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public DetalleCliente buscarPorId(Integer id) {
		DetalleCliente detalleCliente = null;
		String sql = "select id_cliente from detalle_clientes where id_cuenta = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				detalleCliente = new DetalleCliente();
				detalleCliente.setIdCuenta(id);
				detalleCliente.setIdCliente(resultSet.getInt("id_cliente"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return detalleCliente;
	}

	@Override
	public boolean insertar(DetalleCliente detalleCliente) {
		// Evitar java.lang.NullPointerException
		if (detalleCliente == null) {
			return false;
		}

		String sql = "insert into detalle_clientes (id_cliente, id_cuenta) values (?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setInt(1, detalleCliente.getIdCliente());
			preparedStatementInsertar.setInt(2, detalleCliente.getIdCuenta());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(DetalleCliente detalleCliente) {
		// Evitar java.lang.NullPointerException
		if (detalleCliente == null) {
			return false;
		}

		String sql = "update detalle_clientes set id_cliente = ? where id_cuenta = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setInt(1, detalleCliente.getIdCliente());
			preparedStatementModificar.setInt(2, detalleCliente.getIdCuenta());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(DetalleCliente detalleCliente) {
		// Evitar java.lang.NullPointerException
		if (detalleCliente == null) {
			return false;
		}

		String sql = "delete from detalle_clientes where id_cuenta= ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, detalleCliente.getIdCuenta());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DetalleCliente> listar() {
		List<DetalleCliente> detalleClientes = new ArrayList<DetalleCliente>();
		String sql = "select id_cuenta, id_cliente from detalle_clientes";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				DetalleCliente detalleCliente = new DetalleCliente();
				detalleCliente.setIdCuenta(resultSet.getInt("id_cuenta"));
				detalleCliente.setIdCliente(resultSet.getInt("id_cliente"));
				
				detalleClientes.add(detalleCliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalleClientes;
	}

}
