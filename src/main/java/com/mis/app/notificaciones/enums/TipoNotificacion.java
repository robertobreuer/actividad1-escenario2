package com.mis.app.notificaciones.enums;

/**
 * Enumeración que define los diferentes tipos de notificaciones disponibles.
 * Cada tipo tiene una descripción asociada para su identificación.
 */
public enum TipoNotificacion {

    /** Notificación de tipo mensaje informativo. */
    MENSAJE("Mensaje"),
    /** Notificación de tipo alerta crítica. */
    ALERTA("Alerta"),
    /** Notificación de tipo advertencia. */
    ADVERTENCIA("Advertencia"),
    /** Notificación de tipo confirmación. */
    CONFIRMACION("Confirmación");

    /** Descripción textual del tipo de notificación. */
    private final String descripcion;

    /**
     * Constructor del enum.
     *
     * @param descripcion la descripción del tipo de notificación
     */
    TipoNotificacion(final String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del tipo de notificación.
     *
     * @return la descripción del tipo
     */
    public String getDescripcion() {
        return descripcion;
    }
}
