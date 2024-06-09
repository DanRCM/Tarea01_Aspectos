
public aspect ObserverAsp {
	// Pointcut para la ejecución al colocar un estado en MainSubject
    pointcut stateChange(MainSubject subject): execution(void MainSubject.setState(int)) && this(subject);

    // Advice que se ejecuta después de que cambie el estado
    after(MainSubject subject): stateChange(subject) {
        subject.notifyObservers();
    }
    
    // Definición del pointcut para seleccionar el método changeColors
    pointcut changeColorsExecution(): execution(* *.changeColors(..));
    
    // Advice alrededor del método changeColors para medir el tiempo de ejecución
    Object around(): changeColorsExecution() {
        long start = System.currentTimeMillis();
        proceed(); // Proseguir con la ejecución del método original
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Execution time: " + elapsedTime + "ms");
    }
}
