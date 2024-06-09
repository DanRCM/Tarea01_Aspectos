# Tarea01_Aspectos
# ObserverAsp Aspect

Este aspecto (`ObserverAsp`) se ha creado para demostrar cómo AspectJ puede ser utilizado para gestionar de manera efectiva los core concerns y los cross-cutting concerns en una aplicación Java. En este caso, estamos utilizando un aspecto para observar cambios de estado en una clase `MainSubject` y para medir el tiempo de ejecución de un método `changeColors` en la clase `MainWindow`.

## Core Concerns y Cross-Cutting Concerns

### Core Concerns

Los core concerns son las funcionalidades principales y específicas de una aplicación. En nuestro ejemplo, los core concerns son:

- **Cambiar el estado del objeto `MainSubject`**: Este es un comportamiento central en nuestro patrón Observer, donde los observadores son notificados de los cambios de estado.
- **Método `changeColors`**: Este método en `MainWindow` maneja la lógica de cambiar colores en respuesta a eventos de usuario.

### Cross-Cutting Concerns

Los cross-cutting concerns son aspectos de una aplicación que afectan a múltiples módulos pero no forman parte del núcleo de su funcionalidad. En nuestro ejemplo, los cross-cutting concerns incluyen:

- **Notificación de observadores**: Notificar a los observadores cada vez que el estado de `MainSubject` cambia es una funcionalidad transversal.
- **Medición del tiempo de ejecución**: Registrar el tiempo de ejecución del método `changeColors` es una preocupación transversal que puede ser aplicable a múltiples métodos.

## Aspecto `ObserverAsp`

El aspecto `ObserverAsp` se define para manejar estos cross-cutting concerns sin ensuciar el código de los core concerns.

### Definición del Aspecto

```java
public aspect ObserverAsp {
    // Pointcut para la ejecución al colocar un estado en MainSubject
    pointcut stateChange(MainSubject subject): execution(void MainSubject.setState(int)) && this(subject);

    // Advice que se ejecuta después de que cambie el estado
    after(MainSubject subject): stateChange(subject) {
        subject.notifyObservers();
    }

    // Definición del pointcut para seleccionar el método changeColors
    pointcut changeColorsExecution(): execution(void MainWindow.changeColors(..));

    // Advice alrededor del método changeColors para medir el tiempo de ejecución
    void around(): changeColorsExecution() {
        long start = System.currentTimeMillis();
        proceed(); // Proseguir con la ejecución del método original
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Execution time: " + elapsedTime + "ms");
    }
}
