package com.mis.app.notificaciones.plataforma.impl;

import org.springframework.stereotype.Component;
import com.mis.app.notificaciones.enums.TipoNotificacion;

/**
 * Implementación de plataforma de notificación para aplicaciones de
 * escritorio.
 * Proporciona funcionalidad específica para mostrar notificaciones en
 * entornos de escritorio.
 */
@Component
public class PlataformaEscritorio implements PlataformaNotificacion {

    /**
     * Muestra una notificación de escritorio con formato específico según
     * el tipo.
     *
     * @param titulo el título de la notificación
     * @param mensaje el contenido del mensaje
     * @param tipo el tipo de notificación a mostrar
     * @return la notificación formateada para plataforma de escritorio
     */
    @Override
    public String mostrar(final String titulo, final String mensaje,
            final TipoNotificacion tipo) {
        return switch (tipo) {
        case MENSAJE ->
            "[EscritorioMensaje] " + titulo + ": " + mensaje;
        case ALERTA ->
            "[EscritorioAlerta] " + titulo + ": " + mensaje;
        case ADVERTENCIA ->
            "[EscritorioAdvertencia] " + titulo + ": " + mensaje;
        case CONFIRMACION ->
            "[EscritorioConfirmacion] " + titulo + ": " + mensaje;
        };
    }
}

