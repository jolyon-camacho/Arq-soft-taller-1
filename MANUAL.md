# Manual de Usuario y Guía de Instalación - NumLogic Explorer

Este documento proporciona las instrucciones necesarias para instalar, configurar y jugar a **NumLogic Explorer**, garantizando una experiencia educativa fluida y técnicamente sólida.

---

## 🛠️ I. Guía de Instalación

### 1. Requisitos del Sistema
Para ejecutar o compilar este software, es necesario contar con:
- **Java Development Kit (JDK) 11 o superior** (Se recomienda OpenJDK 17+).
- **Variable de Entorno PATH**: Asegúrese de que el binario de Java (`javac` y `java`) esté disponible en la terminal.

### 2. Pasos para la Instalación
1. **Descargar el Proyecto**: Clone o descargue el repositorio en una carpeta local.
2. **Preparar el entorno**: Abra una terminal (PowerShell, CMD o Terminal de Linux) en la raíz del proyecto.
3. **Compilación**:
   Ejecute el siguiente comando para generar los archivos binarios:
   ```bash
   javac -d bin -sourcepath src src/com/edtech/numlogic/App.java
   ```
   *Nota: Esto creará una carpeta `bin/` con el código ejecutable organizado por paquetes.*

---

## 🎮 II. Manual de Usuario

### 1. Inicio de la Aventura
Al iniciar el programa con el comando `java -cp bin com.edtech.numlogic.App`, el sistema le dará la bienvenida y le pedirá sus datos básicos:
- **Nombre, Edad y Curso**: Estos datos se guardan durante la sesión para personalizar la experiencia.

### 2. Selección de Dificultad
El sistema permite elegir entre dos desafíos dinámicos:
- **Nivel Principiante (1)**: Rango del 1 al 10. Ideal para niños pequeños.
- **Nivel Avanzado (2)**: Rango del 1 al 1000. Para exploradores expertos.

### 3. Mecánica del Juego
- El sistema pensará un número secreto. Tú debes intentar adivinarlo.
- **Pistas Inteligentes**: Si tu número no es el correcto, el sistema te dirá si el número secreto es **MAYOR** o **MENOR** al que ingresaste.
- **Robustez de Entrada**: No te preocupes si te equivocas y escribes letras por error; el sistema detectará el fallo y te pedirá el número nuevamente sin cerrarse.

### 4. Resumen y Analítica
Al finalizar, verás una pantalla de resultados con:
- **Intentos totales**: ¿Cuántas veces probaste?
- **Tiempo**: Segundos transcurridos.
- **Eficiencia**: Una calificación basada en tu desempeño.

---

## 🔧 III. Gestión y Mantenimiento (Para Ingenieros)

### 1. Estructura del Código (MVC)
- **Model**: Lógica pura (`Juego`, `Configuracion`, `GeneradorAleatorio`).
- **View**: Interacción con el usuario (`InterfazUsuario`).
- **Controller**: Conector de flujo (`ControladorJuego`).

### 2. Generación de Documentación Técnica
El código está documentado con estándares **Javadoc**. Para generar el manual técnico navegable (HTML), ejecute:
```bash
javadoc -d docs -sourcepath src -subpackages com.edtech.numlogic
```

### 3. Ejecución de Pruebas
Consulte el archivo `Informe_Pruebas.md` para las instrucciones detalladas sobre cómo correr los tests unitarios y validar la integridad del sistema.
