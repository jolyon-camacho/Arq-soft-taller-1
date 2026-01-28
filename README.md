# NumLogic Explorer 🚀

¡Bienvenido a **NumLogic Explorer**! Una herramienta educativa diseñada como pieza de ingeniería robusta para ayudar a los niños a desarrollar pensamiento lógico a través de la adivinanza de números.

## 🛠️ Arquitectura
El sistema implementa el patrón **MVC (Model-View-Controller)** para garantizar la separación de responsabilidades y la mantenibilidad a largo plazo:

- **Modelo**: Contiene la lógica matemática, generador aleatorio y gestión de configuración.
- **Vista**: Gestiona la interacción con el usuario (consola) con alta tolerancia a errores.
- **Controlador**: Orquesta el flujo de la aplicación.

## 📋 Requisitos de Ingeniería Cumplidos
1.  **Rangos Dinámicos**: Configuración 1-10 (Principiante) y 1-1000 (Avanzado).
2.  **Robustez**: El sistema no falla ante entradas de texto o caracteres especiales.
3.  **Analítica**: Reporte de intentos, tiempo transcurrido y eficiencia al finalizar.
4.  **Mantenibilidad**: Código documentado con Javadoc.

## 🚀 Cómo Ejecutar

### Compilación
Desde la raíz del proyecto:
```bash
javac -d bin -sourcepath src src/com/edtech/numlogic/App.java
```

### Ejecutar Aplicación
```bash
java -cp bin com.edtech.numlogic.App
```

### Ejecutar Pruebas
```bash
# Compilar pruebas
javac -d bin -sourcepath "src;test" test/com/edtech/numlogic/model/JuegoTest.java test/com/edtech/numlogic/model/GeneradorAleatorioTest.java

# Ejecutar JuegoTest
java -cp bin com.edtech.numlogic.model.JuegoTest

# Ejecutar GeneradorAleatorioTest
java -cp bin com.edtech.numlogic.model.GeneradorAleatorioTest
```

## 📄 Documentación Adicional
- `Informe_Pruebas.md`: Detalle de los casos de prueba y resultados de auditoría técnica.
