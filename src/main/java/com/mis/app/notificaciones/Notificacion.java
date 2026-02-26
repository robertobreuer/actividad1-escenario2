package com.mis.app.notificaciones;

import com.mis.app.notificaciones.enums.TipoNotificacion;
import com.mis.app.notificaciones.plataforma.impl.PlataformaNotificacion;

/**
 * Clase que representa una notificación con una plataforma y tipo
 * específicos.
 * Implementa el patrón Bridge separando la abstracción (Notificación)
 * de su implementación (PlataformaNotificación), evitando la explosión
 * combinatoria de clases.
 */
public class Notificacion {

    /** Plataforma utilizada para mostrar la notificación. */
    private final PlataformaNotificacion plataforma;

    /** Tipo de notificación. */
    private final TipoNotificacion tipo;

    /**
     * Constructor que inicializa una notificación con plataforma y tipo.
     *
     * @param plat la plataforma donde se mostrará la notificación
     * @param tipoNotif el tipo de notificación
     */
    public Notificacion(final PlataformaNotificacion plat,
            final TipoNotificacion tipoNotif) {
        this.plataforma = plat;
        this.tipo = tipoNotif;
    }

    /**
     * Envía la notificación utilizando la plataforma configurada.
     *
     * @param titulo el título de la notificación
     * @param mensaje el contenido del mensaje
     * @return la representación de la notificación enviada
     */
    public String enviar(final String titulo, final String mensaje) {
        return plataforma.mostrar(titulo, mensaje, tipo);
    }

}

