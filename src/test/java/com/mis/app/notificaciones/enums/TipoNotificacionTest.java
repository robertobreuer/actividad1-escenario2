package com.mis.app.notificaciones.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipoNotificacionTest {

	@Test
	void getDescripcion_Mensaje_RetornaDescripcionCorrecta() {
		assertEquals("Mensaje", TipoNotificacion.MENSAJE.getDescripcion());
	}

	@Test
	void getDescripcion_Alerta_RetornaDescripcionCorrecta() {
		assertEquals("Alerta", TipoNotificacion.ALERTA.getDescripcion());
	}

	@Test
	void getDescripcion_Advertencia_RetornaDescripcionCorrecta() {
		assertEquals("Advertencia", TipoNotificacion.ADVERTENCIA.getDescripcion());
	}

	@Test
	void getDescripcion_Confirmacion_RetornaDescripcionCorrecta() {
		assertEquals("Confirmación", TipoNotificacion.CONFIRMACION.getDescripcion());
	}

	@Test
	void values_RetornaTodosLosValores() {
		TipoNotificacion[] valores = TipoNotificacion.values();
		assertEquals(4, valores.length);
	}

	@Test
	void valueOf_ConNombreValido_RetornaEnum() {
		assertEquals(TipoNotificacion.MENSAJE, TipoNotificacion.valueOf("MENSAJE"));
	}
}
