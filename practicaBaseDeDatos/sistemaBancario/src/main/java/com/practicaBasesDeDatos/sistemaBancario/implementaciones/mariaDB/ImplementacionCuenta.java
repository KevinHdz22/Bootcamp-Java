package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.Cuenta;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionCuenta implements DAO<Cuenta, Integer>, ConexionMariaDB {
	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Cuenta buscarPorId(Integer id) {
		Cuenta cuenta = null;
		String sql = "select tipoCuenta from cuentas where id = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				cuenta = new Cuenta();
				cuenta.setId(id);
				cuenta.setTipoDeCuenta(resultSet.getString("tipoCuenta"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cuenta;
	}

	@Override
	public boolean insertar(Cuenta cuenta) {
		// Evitar java.lang.NullPointerException
		if (cuenta == null) {
			return false;
		}

		String sql = "insert into cuentas (id, tipoCuenta) values (?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setInt(1, cuenta.getId());
			preparedStatementInsertar.setString(2, cuenta.getTipoDeCuenta());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Cuenta cuenta) {
		// Evitar java.lang.NullPointerException
		if (cuenta == null) {
			return false;
		}

		String sql = "update cuentas set tipoCuenta = ? where id = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, cuenta.getTipoDeCuenta());
			preparedStatementModificar.setInt(2, cuenta.getId());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Cuenta cuenta) {
		// Evitar java.lang.NullPointerException
		if (cuenta == null) {
			return false;
		}

		String sql = "delete from cuentas where id = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, cuenta.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cuenta> listar() {
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		String sql = "select id, tipoCuenta from cuentas";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setId(resultSet.getInt("id"));
				cuenta.setTipoDeCuenta(resultSet.getString("tipoCuenta"));
				
				cuentas.add(cuenta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentas;
	}
}
