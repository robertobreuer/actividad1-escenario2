package com.mis.app.notificaciones.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mis.app.notificaciones.enums.TipoNotificacion;
import com.mis.app.notificaciones.service.NotificacionService;

@WebMvcTest(NotificacionController.class)
class NotificacionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NotificacionService notificacionService;

	@Test
	void enviarNotificacion_Web_RetornaRespuestaExitosa() throws Exception {
		when(notificacionService.enviarNotificacion("web", TipoNotificacion.MENSAJE, "Título", "Mensaje"))
				.thenReturn("[WEBMensaje] Título: Mensaje");

		mockMvc.perform(post("/notificaciones/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"plataforma\":\"web\",\"tipo\":\"MENSAJE\",\"titulo\":\"Título\",\"mensaje\":\"Mensaje\"}"))
				.andExpect(status().isOk())
				.andExpect(content().string("[WEBMensaje] Título: Mensaje"));

		verify(notificacionService).enviarNotificacion("web", TipoNotificacion.MENSAJE, "Título", "Mensaje");
	}

	@Test
	void enviarNotificacion_Movil_RetornaRespuestaExitosa() throws Exception {
		when(notificacionService.enviarNotificacion("movil", TipoNotificacion.ALERTA, "Alerta", "Error"))
				.thenReturn("[MovilAlerta] Alerta: Error");

		mockMvc.perform(post("/notificaciones/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"plataforma\":\"movil\",\"tipo\":\"ALERTA\",\"titulo\":\"Alerta\",\"mensaje\":\"Error\"}"))
				.andExpect(status().isOk())
				.andExpect(content().string("[MovilAlerta] Alerta: Error"));
	}

	@Test
	void enviarNotificacion_Escritorio_RetornaRespuestaExitosa() throws Exception {
		when(notificacionService.enviarNotificacion("escritorio", TipoNotificacion.ADVERTENCIA, "Advertencia", "Mantenimiento"))
				.thenReturn("[EscritorioAdvertencia] Advertencia: Mantenimiento");

		mockMvc.perform(post("/notificaciones/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"plataforma\":\"escritorio\",\"tipo\":\"ADVERTENCIA\",\"titulo\":\"Advertencia\",\"mensaje\":\"Mantenimiento\"}"))
				.andExpect(status().isOk())
				.andExpect(content().string("[EscritorioAdvertencia] Advertencia: Mantenimiento"));
	}
}
