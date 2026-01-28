# Informe de Pruebas (Test Plan) - NumLogic Explorer

## 1. Introducción
Este documento detalla el plan de pruebas y los resultados obtenidos para garantizar que el sistema "NumLogic Explorer" cumpla con los estándares de robustez, integridad y precisión matemática exigidos.

## 2. Casos de Prueba Unitarios

### 2.1 Pruebas del Generador Aleatorio (`GeneradorAleatorioTest`)
| ID | Descripción | Entrada | Resultado Esperado | Resultado Real | Estado |
|---|---|---|---|---|---|
| UT-01 | Generación en rango | min=1, max=10 | El número debe estar consistentemente entre 1 y 10. | El número se mantuvo en el rango tras 100 pruebas. | ✅ PASSED |
| UT-02 | Rango de valor único | min=5, max=5 | El resultado debe ser exactamente 5. | Resultado: 5 | ✅ PASSED |

### 2.2 Pruebas de la Lógica del Juego (`JuegoTest`)
| ID | Descripción | Entrada | Resultado Esperado | Resultado Real | Estado |
|---|---|---|---|---|---|
| UT-03 | Validación de Acierto | Número secreto | El juego retorna 0 y se desactiva. | Retornó 0 y `juegoActivo` pasó a false. | ✅ PASSED |
| UT-04 | Lógica de Pistas | Intento < Secreto | El sistema retorna 1 (Pista: Mayor). | Retornó 1. | ✅ PASSED |
| UT-05 | Conteo de Intentos | 2 intentos fallidos | El contador de intentos debe ser 2. | Contador: 2 | ✅ PASSED |

## 3. Pruebas de Frontera e Integridad (Robustez)

| Escenario | Entrada | Comportamiento del Sistema | Estado |
|---|---|---|---|
| **Entrada de Texto** | "niño123" | La UI atrapa la excepción `NumberFormatException`, informa al usuario y solicita el dato de nuevo sin colapsar. | ✅ PASSED |
| **Entrada Vacía** | "" (Enter) | Se detecta como error de formato, el sistema pide el número nuevamente. | ✅ PASSED |
| **Números Negativos** | -10 | Se procesa como un número entero válido (fuera de rango lógico de adivinanza pero matemáticamente manejable). | ✅ PASSED |
| **Límites de Dificultad** | Opción 2 | Configura el rango dinámico a 1-1000 sin modificar el código fuente. | ✅ PASSED |

## 4. Analítica y Auditoría
Tras cada sesión, el sistema genera un resumen que incluye:
1.  **Intentos Totales**: Cuantificación del esfuerzo del usuario.
2.  **Tiempo Transcurrido**: Cálculo en segundos desde el inicio hasta el acierto.
3.  **Calificación de Eficiencia**: Evaluación cualitativa según la cantidad de intentos.

## 5. Conclusión
El software ha superado todas las pruebas de robustez. Es apto para su uso por parte de niños, cumpliendo con el requisito de ser "a prueba de errores de usuario" y ofreciendo una arquitectura mantenible bajo el patrón MVC.
