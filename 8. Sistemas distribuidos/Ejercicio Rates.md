# Guía práctica – Ejercicio de pagos vía QR

## ✅ Ejercicio 1

### Objetivo

Configurar correctamente el RestClient que consulta a `discounts-api`, de forma que se garantice:

- Tiempo de respuesta total (incluyendo retries) menor a 500ms.
- Error rate de nuestro servicio < 0.5%.

### SLA de discounts-api

- Average: 40ms
- P95: 150ms
- P99: 300ms
- Máximo: 400ms
- Error Rate: 0.9%

---

### Propuesta de configuración del RestClient

#### ⏱ Timeout: **150ms**

- Elegimos el `P95` como valor de timeout para no caer en los peores casos (P99 o MAX), que consumirían demasiado tiempo.
- Nos permite tener margen para retries sin superar los 500ms.

#### 🔁 Retries: **2**

- Total de 3 intentos (1 original + 2 retries).
- Nos da oportunidades de evitar errores transitorios sin saturar el sistema.

#### ♻️ Retry strategy: **Exponential backoff con jitter**

- Usamos un **backoff exponencial** (por ejemplo: 0ms → 50ms → 100ms) para espaciar los intentos.
- **Jitter aleatorio** para evitar que múltiples instancias reintenten al mismo tiempo y generen picos sincronizados.

#### ⏳ Total budget de tiempo (estimado):

- Primer intento: ~150ms
- Retry 1: ~100ms
- Retry 2: ~100ms
- Overhead + tiempo de lógica: ~50ms
- **Total estimado: ~400ms**, bajo el límite de 500ms.

---

## ✅ Ejercicio 2

### Problema

Nuestro microservicio reintenta 2 veces ante errores 429 (Too Many Requests) del servicio que consume. Cuando el servicio externo pasa más de 1 minuto devolviendo 429:

- Nuestro tiempo de respuesta se dispara.
- El error rate sube al 100%.
- Aun cuando el otro servicio se recupera, el nuestro no, hasta reiniciar instancias.

---

### Análisis

#### ❗ Por qué ocurre:

- Cada request que recibe nuestro servicio hace 3 intentos (original + 2 retries).
- Si el servicio externo tarda (ej: 500ms por intento), cada request puede ocupar nuestro sistema por **hasta 1500ms**.
- Se acumulan llamadas fallidas → saturación de threads, CPU o recursos.
- Aunque el servicio externo vuelva a estar disponible, **seguimos congestionados con retries inútiles iniciados durante el mal estado**.

---

### Propuesta de cambio

1. **No reintentar ante 429**

   - 429 no indica un fallo transitorio sino una política de rate limit → reintentar sin esperar rompe aún más el sistema.

2. **Aplicar un Circuit Breaker**

   - Si vemos muchos 429 seguidos, cortar las llamadas al servicio externo por un período de enfriamiento.
   - Evitamos retries innecesarios y protegemos recursos.

3. **Devolver 503 en vez de 500**

   - 500 sugiere un fallo interno.
   - 503 indica que dependemos de un servicio temporalmente no disponible → mejora la trazabilidad del error.

4. **Agregar Retry Budget**
   - Limitar la cantidad de retries por ventana de tiempo para no amplificar errores cuando el otro servicio está mal.

---

### Beneficios del cambio

- Evitamos la congestión progresiva.
- Nos recuperamos rápido cuando el servicio externo se normaliza.
- Mejoramos la resiliencia general del sistema.
