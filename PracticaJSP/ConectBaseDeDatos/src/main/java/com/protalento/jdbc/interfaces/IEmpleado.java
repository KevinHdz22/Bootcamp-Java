package com.protalento.jdbc.interfaces;

import com.protalento.entidades.Empleado;
import com.protalento.entidades.Usuario;

public interface IEmpleado extends DAOGenerico<Empleado, String> {
	Empleado buscarPorTipoNumeroDoc(String tipoDoc, String numDoc);
}
