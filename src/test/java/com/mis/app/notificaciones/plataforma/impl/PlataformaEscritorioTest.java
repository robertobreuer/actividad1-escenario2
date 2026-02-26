package com.mis.app.notificaciones.plataforma.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mis.app.notificaciones.enums.TipoNotificacion;

class PlataformaEscritorioTest {

	private final PlataformaEscritorio plataforma = new PlataformaEscritorio();

	@Test
	void mostrar_TipoMensaje_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Título", "Contenido", TipoNotificacion.MENSAJE);
		assertEquals("[EscritorioMensaje] Título: Contenido", resultado);
	}

	@Test
	void mostrar_TipoAlerta_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Alerta", "Error crítico", TipoNotificacion.ALERTA);
		assertEquals("[EscritorioAlerta] Alerta: Error crítico", resultado);
	}

	@Test
	void mostrar_TipoAdvertencia_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Advertencia", "Mantenimiento", TipoNotificacion.ADVERTENCIA);
		assertEquals("[EscritorioAdvertencia] Advertencia: Mantenimiento", resultado);
	}

	@Test
	void mostrar_TipoConfirmacion_RetornaFormatoEsperado() {
		String resultado = plataforma.mostrar("Éxito", "Operación completada", TipoNotificacion.CONFIRMACION);
		assertEquals("[EscritorioConfirmacion] Éxito: Operación completada", resultado);
	}
}
