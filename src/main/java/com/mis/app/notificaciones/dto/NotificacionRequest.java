package com.mis.app.notificaciones.dto;

import com.mis.app.notificaciones.enums.TipoNotificacion;
import lombok.Data;

/**
 * DTO para las peticiones de envío de notificaciones.
 */
@Data
public class NotificacionRequest {

    /** Nombre de la plataforma destino. */
    private String plataforma;
    /** Tipo de notificación. */
    private TipoNotificacion tipo;
    /** Título de la notificación. */
    private String titulo;
    /** Mensaje de la notificación. */
    private String mensaje;

}

