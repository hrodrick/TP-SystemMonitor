

package monitor;


public abstract class Monitor {
    private CPU micro;

    public CPU getMicro() {
        return micro;
    }

    
    public Monitor(CPU micro) {
        this.micro = micro;
    }
    
}
