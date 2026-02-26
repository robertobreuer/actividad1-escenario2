package com.mis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 */
@SpringBootApplication
public final class MisApplication {

    /**
     * Constructor privado para evitar instanciación.
     */
    private MisApplication() {
    }

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(final String[] args) {
        SpringApplication.run(MisApplication.class, args);
    }

}
