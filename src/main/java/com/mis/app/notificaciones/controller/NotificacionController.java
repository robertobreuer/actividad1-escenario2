package com.mis.app.notificaciones.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mis.app.notificaciones.dto.NotificacionRequest;
import com.mis.app.notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para gestionar notificaciones.
 * Utiliza el patrón Bridge para enviar notificaciones a diferentes
 * plataformas.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/notificaciones")
public class NotificacionController {

    /** Servicio de notificaciones. */
    private final NotificacionService notificacionService;

    /**
     * Envía una notificación a una plataforma específica.
     *
     * @param request datos de la notificación a enviar
     * @return resultado del envío
     */
    @PostMapping("/")
    public String enviarNotificacion(
            @RequestBody final NotificacionRequest request) {
        return notificacionService.enviarNotificacion(
            request.getPlataforma(),
            request.getTipo(),
            request.getTitulo(),
            request.getMensaje()
        );
    }

}

