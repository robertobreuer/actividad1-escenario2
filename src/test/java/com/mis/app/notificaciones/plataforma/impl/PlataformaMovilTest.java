package com.mis.app.notificaciones.plataforma.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mis.app.notificaciones.enums.TipoNotificacion;

class PlataformaMovilTest {

	private final PlataformaMovil plataforma = new PlataformaMovil();

	@Test
	void mostrar_TipoMensaje_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Título", "Contenido", TipoNotificacion.MENSAJE);
		assertEquals("[MovilMensaje] Título: Contenido", resultado);
	}

	@Test
	void mostrar_TipoAlerta_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Alerta", "Error crítico", TipoNotificacion.ALERTA);
		assertEquals("[MovilAlerta] Alerta: Error crítico", resultado);
	}

	@Test
	void mostrar_TipoAdvertencia_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Advertencia", "Mantenimiento", TipoNotificacion.ADVERTENCIA);
		assertEquals("[MovilAdvertencia] Advertencia: Mantenimiento", resultado);
	}

	@Test
	void mostrar_TipoConfirmacion_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Éxito", "Operación completada", TipoNotificacion.CONFIRMACION);
		assertEquals("[MovilConfirmacion] Éxito: Operación completada", resultado);
	}
}
