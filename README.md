
### Actividad 1 Escenario 2
Estás desarrollando una aplicación que gestiona la visualización de notificaciones en diferentes plataformas (por ejemplo: escritorio, móvil, web). Las notificaciones pueden ser de distintos tipos (mensaje, alerta, advertencia, confirmación) y cada tipo puede mostrarse de distintas formas según la plataforma.

**Problema** Si usas herencia tradicional, tendrías que crear clases como:

● NotificacionMensajeWeb, NotificacionAlertaWeb, NotificacionMensajeMovil, NotificacionAlertaMovil, etc.

Esto lleva rápidamente a una explosión combinatoria de subclases difíciles de mantener.

**Guía de actividad**
Beneficios esperados de la solución:

● Separación de responsabilidades: Separar la lógica de la notificación del medio por el
que se presenta.

● Escalabilidad: Poder agregar nuevas plataformas o tipos de notificación sin modificar
el resto del sistema.

● Reducción de clases: Evitar la multiplicación de clases para cada combinación.

● Flexibilidad en tiempo de ejecución: Poder cambiar la plataforma dinámicamente si
es necesario.

# Solución
## 📋 Análisis del Patrón

### 🔍 Identificación del Tipo de Patrón

**Tipo**: **ESTRUCTURAL**

Los patrones estructurales se encargan de cómo las clases y objetos se componen para formar estructuras más grandes, facilitando el diseño al identificar relaciones simples entre entidades.

### 🎯 Selección del Patrón

**Patrón Seleccionado**: **BRIDGE (Puente)**

#### Justificación:
- **Problema**: Evitar la explosión combinatoria de clases 
- **Solución**: Separar la abstracción (Notificación) de su implementación (Plataforma)
- **Beneficio**: Permite que ambas jerarquías evolucionen independientemente

#### Características del Bridge Pattern:
- ✅ **Abstracción**: `Notificacion` - Define la interfaz de alto nivel
- ✅ **Implementador**: `PlataformaNotificacion` - Interfaz para implementaciones
- ✅ **Implementaciones Concretas**: `PlataformaWeb`, `PlataformaMovil`, `PlataformaEscritorio`
- ✅ **Separación**: Dos jerarquías independientes (tipos vs plataformas)

### 🎨 Diagrama de Clases de la Solución

```mermaid
classDiagram
direction LR
    
    %% Enumeración
    class TipoNotificacion {
        <<enumeration>>
        +MENSAJE : String
        +ALERTA : String
        +ADVERTENCIA : String
        +CONFIRMACION : String
        -descripcion : String
        +getDescripcion() : String
    }

    %% DTO
    class NotificacionRequest {
        -plataforma : String
        -tipo : TipoNotificacion
        -titulo : String
        -mensaje : String
        +getPlataforma() : String
        +setPlataforma(plataforma : String)
        +getTipo() : TipoNotificacion
        +setTipo(tipo : TipoNotificacion)
        +getTitulo() : String
        +setTitulo(titulo : String)
        +getMensaje() : String
        +setMensaje(mensaje : String)
    }

    %% Abstracción (Bridge)
    class Notificacion {
        -plataforma : PlataformaNotificacion
        -tipo : TipoNotificacion
        +Notificacion(plataforma, tipo)
        +enviar(titulo, mensaje) : String
    }

    %% Implementador (Bridge Interface)
    class PlataformaNotificacion {
        <<interface>>
        +mostrar(titulo, mensaje, tipo) : String
    }

    %% Implementaciones Concretas
    class PlataformaWeb {
        <<@Component>>
        +mostrar(titulo, mensaje, tipo) : String
    }

    class PlataformaMovil {
        <<@Component>>
        +mostrar(titulo, mensaje, tipo) : String
    }

    class PlataformaEscritorio {
        <<@Component>>
        +mostrar(titulo, mensaje, tipo) : String
    }

    %% Servicio
    class NotificacionService {
        <<@Service>>
        -webPlataforma : PlataformaWeb
        -movilPlataforma : PlataformaMovil
        -escritorioPlataforma : PlataformaEscritorio
        +enviarNotificacion(plataforma, tipo, titulo, mensaje) : String
        -obtenerPlataforma(plataforma) : PlataformaNotificacion
    }

    %% Controlador
    class NotificacionController {
        <<@RestController>>
        -notificacionService : NotificacionService
        +enviarNotificacion(request : NotificacionRequest) : String
    }

    %% Aplicación Principal
    class MisApplication {
        <<@SpringBootApplication>>
        +main(args) : void
    }

    %% Relaciones del Patrón Bridge
    Notificacion --> PlataformaNotificacion : usa
    Notificacion --> TipoNotificacion : contiene
    
    PlataformaWeb ..|> PlataformaNotificacion : implementa
    PlataformaMovil ..|> PlataformaNotificacion : implementa
    PlataformaEscritorio ..|> PlataformaNotificacion : implementa

    %% Relaciones de Spring
    NotificacionService --> PlataformaWeb : inyecta
    NotificacionService --> PlataformaMovil : inyecta
    NotificacionService --> PlataformaEscritorio : inyecta
    NotificacionService ..> Notificacion : crea
    
    NotificacionController --> NotificacionService : inyecta
    NotificacionController --> NotificacionRequest : recibe
    NotificacionRequest --> TipoNotificacion : contiene
```
## 🚀 Tecnologías

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?style=for-the-badge&logo=apache-maven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-Latest-yellow?style=for-the-badge&logo=lombok&logoColor=white)

### Stack Tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17 | Lenguaje de programación principal |
| **Spring Boot** | 3.5.6 | Framework para aplicaciones web |
| **Spring Web** | - | API REST endpoints |
| **Maven** | 3.6+ | Gestión de dependencias y build |
| **Lombok** | Latest | Reducción de código boilerplate |



## 📡 API Endpoints

### 🎯 Base URL
### 📋 Endpoints Disponibles

### **Enviar Notificación**

POST /mis/notificaciones/

Content-Type: application/json

Accept: application/json

#### Ejemplo 1: Notificación Web
```
curl -X POST http://HOST:PORT/api/notificaciones \
  -H "Content-Type: application/json" \
  -d '{
    "plataforma": "web",
    "tipo": "MENSAJE", 
    "titulo": "Bienvenido",
    "mensaje": "Usuario registrado exitosamente"
  }'
Respuesta:
[WEBMensaje] Bienvenido: Usuario registrado exitosamente
```


#### Ejemplo 2: Alerta Móvil
```
curl -X POST http://HOST:PORT/mis/notificaciones/ \
  -H "Content-Type: application/json" \
  -d '{
    "plataforma": "movil",
    "tipo": "ALERTA",
    "titulo": "Error Crítico",
    "mensaje": "Fallo en el sistema de pagos"
  }'
Respuesta:
[MovilAlerta] Error Crítico: Fallo en el sistema de pagos
```


#### Ejemplo 3: Advertencia Escritorio
```
curl -X POST http://HOST:PORT/mis/notificaciones/ \
  -H "Content-Type: application/json" \
  -d '{
    "plataforma": "escritorio",
    "tipo": "ADVERTENCIA",
    "titulo": "Mantenimiento",
    "mensaje": "El sistema se reiniciará en 5 minutos"
  }'
Respuesta:
[EscritorioAdvertencia] Mantenimiento: El sistema se reiniciará en 5 minutos
```


#### Ejemplo 4: Confirmación
```
curl -X POST http://HOST:PORT/mis/notificaciones/ \
  -H "Content-Type: application/json" \
  -d '{
    "plataforma": "web",
    "tipo": "CONFIRMACION",
    "titulo": "Operación Exitosa",
    "mensaje": "Los datos han sido guardados correctamente"
  }'
Respuesta:
[WEBConfirmacion] Operación Exitosa: Los datos han sido guardados correctamente
```


#2026-02-25 Taller DevOps
# Laboratorio CI/CD - Aplicación Notificaciones

## Objetivo
Configurar pipelines CI/CD para aplicación Java/Spring Boot con despliegue Kubernetes.

## Pipeline CI (GitHub Actions)
**Archivo**: `.github/workflows/ci.yml`

**Triggers**: push/PR a `main`

**Etapas**:
- ✅ Checkout código
- ✅ Setup Java 17  
- ✅ **Ejecución de pruebas** (`mvn test`)
- ✅ Build Maven (`mvn clean package`)
- ✅ **Análisis estático** (`mvn checkstyle:check`)

## Pipeline CD (Jenkins)
**Archivo**: `Jenkinsfile`

**Stages**:
1. Clonar repositorio
2. Build Maven  
3. Construir imagen Docker
4. Publicar imagen DockerHub

## Arquitectura del flujo CI/CD

```mermaid
graph TD
    A[Git Push/PR] --> B[GitHub Actions CI]
    B --> C[mvn test]
    C -->|OK| D[mvn package]
    D -->|OK| E[Análisis estático]
    E --> F[Jenkins CD]
    F --> G[Docker build]
    G --> H[Docker push]
    H --> I[Kubernetes Deploy]
```




