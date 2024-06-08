
public aspect ObserverAsp {
	// Pointcut para la ejecución al colocar un estado en MainSubject
    pointcut stateChange(MainSubject subject): execution(void MainSubject.setState(int)) && this(subject);

    // Advice que se ejecuta después de que cambie el estado
    after(MainSubject subject): stateChange(subject) {
        subject.notifyObservers();
    }

}
