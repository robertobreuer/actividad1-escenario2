package com.mis.app.notificaciones.plataforma.impl;

import org.springframework.stereotype.Component;
import com.mis.app.notificaciones.enums.TipoNotificacion;

/**
 * Implementación de plataforma de notificación para aplicaciones web.
 * Proporciona funcionalidad específica para mostrar notificaciones en
 * entornos web.
 */
@Component
public class PlataformaWeb implements PlataformaNotificacion {

    /**
     * Muestra una notificación web con formato específico según el tipo.
     *
     * @param titulo el título de la notificación
     * @param mensaje el contenido del mensaje
     * @param tipo el tipo de notificación a mostrar
     * @return la notificación formateada para plataforma web
     */
    @Override
    public String mostrar(final String titulo, final String mensaje,
            final TipoNotificacion tipo) {
        return switch (tipo) {
        case MENSAJE ->
            "[WEBMensaje] " + titulo + ": " + mensaje;
        case ALERTA ->
            "[WEBAlerta] " + titulo + ": " + mensaje;
        case ADVERTENCIA ->
            "[WEBAdvertencia] " + titulo + ": " + mensaje;
        case CONFIRMACION ->
            "[WEBConfirmacion] " + titulo + ": " + mensaje;
        };
    }

}