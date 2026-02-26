package com.mis.app.notificaciones.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mis.app.notificaciones.enums.TipoNotificacion;
import com.mis.app.notificaciones.plataforma.impl.PlataformaEscritorio;
import com.mis.app.notificaciones.plataforma.impl.PlataformaMovil;
import com.mis.app.notificaciones.plataforma.impl.PlataformaWeb;

@ExtendWith(MockitoExtension.class)
class NotificacionServiceTest {

	@Mock
	private PlataformaWeb webPlataforma;

	@Mock
	private PlataformaMovil movilPlataforma;

	@Mock
	private PlataformaEscritorio escritorioPlataforma;

	@InjectMocks
	private NotificacionService notificacionService;

	@Test
	void enviarNotificacion_PlataformaWeb_RetornaResultadoEsperado() {
		when(webPlataforma.mostrar("Título", "Mensaje", TipoNotificacion.MENSAJE))
				.thenReturn("[WEB-Mensaje] Título: Mensaje");

		String resultado = notificacionService.enviarNotificacion("web", TipoNotificacion.MENSAJE, "Título", "Mensaje");

		assertEquals("[WEB-Mensaje] Título: Mensaje", resultado);
		verify(webPlataforma).mostrar("Título", "Mensaje", TipoNotificacion.MENSAJE);
	}

	@Test
	void enviarNotificacion_PlataformaMovil_RetornaResultadoEsperado() {
		when(movilPlataforma.mostrar("Alerta", "Error", TipoNotificacion.ALERTA))
				.thenReturn("[Movil-Alerta] Alerta: Error");

		String resultado = notificacionService.enviarNotificacion("movil", TipoNotificacion.ALERTA, "Alerta", "Error");

		assertEquals("[Movil-Alerta] Alerta: Error", resultado);
		verify(movilPlataforma).mostrar("Alerta", "Error", TipoNotificacion.ALERTA);
	}

	@Test
	void enviarNotificacion_PlataformaEscritorio_RetornaResultadoEsperado() {
		when(escritorioPlataforma.mostrar("Advertencia", "Mantenimiento", TipoNotificacion.ADVERTENCIA))
				.thenReturn("[Escritorio-Advertencia] Advertencia: Mantenimiento");

		String resultado = notificacionService.enviarNotificacion("escritorio", TipoNotificacion.ADVERTENCIA,
				"Advertencia", "Mantenimiento");

		assertEquals("[Escritorio-Advertencia] Advertencia: Mantenimiento", resultado);
		verify(escritorioPlataforma).mostrar("Advertencia", "Mantenimiento", TipoNotificacion.ADVERTENCIA);
	}

	@Test
	void enviarNotificacion_PlataformaInvalida_LanzaExcepcion() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> notificacionService.enviarNotificacion("invalida", TipoNotificacion.MENSAJE, "Título", "Mensaje"));

		assertEquals("Plataforma no válida: invalida", exception.getMessage());
	}

	@Test
	void enviarNotificacion_PlataformaMayusculas_FuncionaCorrectamente() {
		when(webPlataforma.mostrar("Test", "Test", TipoNotificacion.CONFIRMACION))
				.thenReturn("[WEB-Confirmacion] Test: Test");

		String resultado = notificacionService.enviarNotificacion("WEB", TipoNotificacion.CONFIRMACION, "Test", "Test");

		assertEquals("[WEB-Confirmacion] Test: Test", resultado);
		verify(webPlataforma).mostrar("Test", "Test", TipoNotificacion.CONFIRMACION);
	}
}
