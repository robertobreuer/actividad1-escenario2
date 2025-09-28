package com.mis.app.notificaciones.service;

import org.springframework.stereotype.Service;
import com.mis.app.notificaciones.Notificacion;
import com.mis.app.notificaciones.enums.TipoNotificacion;
import com.mis.app.notificaciones.plataforma.impl.PlataformaNotificacion;
import com.mis.app.notificaciones.plataforma.impl.PlataformaWeb;

import lombok.RequiredArgsConstructor;

import com.mis.app.notificaciones.plataforma.impl.PlataformaMovil;
import com.mis.app.notificaciones.plataforma.impl.PlataformaEscritorio;

/**
 * Servicio para gestionar el envío de notificaciones a diferentes plataformas.
 * Utiliza inyección de dependencias para obtener las implementaciones de cada plataforma.
 */
@Service
@RequiredArgsConstructor
public class NotificacionService {

	/** Plataforma de notificaciones web */
	private final PlataformaWeb webPlataforma;
	/** Plataforma de notificaciones móvil */
	private final PlataformaMovil movilPlataforma;
	/** Plataforma de notificaciones de escritorio */
	private final PlataformaEscritorio escritorioPlataforma;

	/**
	 * Envía una notificación a la plataforma especificada.
	 * 
	 * @param plataforma nombre de la plataforma (web, movil, escritorio)
	 * @param tipo tipo de notificación a enviar
	 * @param titulo título de la notificación
	 * @param mensaje contenido del mensaje
	 * @return representación de la notificación enviada
	 * @throws IllegalArgumentException si la plataforma no es válida
	 */
	public String enviarNotificacion(String plataforma, TipoNotificacion tipo, String titulo, String mensaje) {
		PlataformaNotificacion plataformaObj = obtenerPlataforma(plataforma);
		Notificacion notificacion = new Notificacion(plataformaObj, tipo);
		return notificacion.enviar(titulo, mensaje);
	}

	/**
	 * Obtiene la implementación de plataforma correspondiente al nombre especificado.
	 * 
	 * @param plataforma nombre de la plataforma
	 * @return implementación de la plataforma
	 * @throws IllegalArgumentException si la plataforma no existe
	 */
	private PlataformaNotificacion obtenerPlataforma(String plataforma) {
		return switch (plataforma.toLowerCase()) {
		case "web" -> webPlataforma;
		case "movil" -> movilPlataforma;
		case "escritorio" -> escritorioPlataforma;
		default -> throw new IllegalArgumentException("Plataforma no válida: " + plataforma);
		};
	}
}