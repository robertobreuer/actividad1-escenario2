package com.mis.app.notificaciones.plataforma.impl;

import com.mis.app.notificaciones.enums.TipoNotificacion;

/**
 * Interfaz para definir plataformas de notificación.
 * Permite mostrar notificaciones con diferentes tipos y contenido.
 */
public interface PlataformaNotificacion {
	
    /**
     * Muestra una notificación con el título, mensaje y tipo especificados.
     * 
     * @param titulo el título de la notificación
     * @param mensaje el contenido del mensaje a mostrar
     * @param tipo el tipo de notificación a mostrar
     * @return una representación en cadena de la notificación mostrada
     */
    String mostrar(String titulo, String mensaje, TipoNotificacion tipo);
}
