package com.mis.app.notificaciones.plataforma.impl;

import org.springframework.stereotype.Component;
import com.mis.app.notificaciones.enums.TipoNotificacion;

/**
 * Implementación de plataforma de notificación para aplicaciones móviles.
 * Proporciona funcionalidad específica para mostrar notificaciones en dispositivos móviles.
 */
@Component
public class PlataformaMovil implements PlataformaNotificacion {
	
	/**
	 * Muestra una notificación móvil con formato específico según el tipo.
	 * 
	 * @param titulo el título de la notificación
	 * @param mensaje el contenido del mensaje
	 * @param tipo el tipo de notificación a mostrar
	 * @return la notificación formateada para plataforma móvil
	 */
	@Override
	public String mostrar(String titulo, String mensaje, TipoNotificacion tipo) {
		 // implementacion para cada tipo de notificacion
 		return switch (tipo) {
 		case MENSAJE -> 
 			"[MovilMensaje] " + titulo +": "+ mensaje;
 		case ALERTA -> 
 			"[MovilAlerta] " + titulo +": "+ mensaje;
 		case ADVERTENCIA -> 
 			"[MovilAdvertencia] " + titulo +": "+ mensaje;
 		case CONFIRMACION -> 
 			"[MovilConfirmacion] " + titulo +": "+ mensaje;
 		};
	}
	
}