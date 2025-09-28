package com.mis.app.notificaciones.dto;

import com.mis.app.notificaciones.enums.TipoNotificacion;
import lombok.Data;

/**
 * DTO para las peticiones de envío de notificaciones.
 */
@Data
public class NotificacionRequest {
    
    private String plataforma;
    private TipoNotificacion tipo;
    private String titulo;
    private String mensaje;
    
}