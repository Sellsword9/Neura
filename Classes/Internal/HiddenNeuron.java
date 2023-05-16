package Classes.Internal;

import java.io.IOException;
import java.util.List;

public class HiddenNeuron extends Neuron{
    private Neuron father;
    private List<Neuron> sons;

    public HiddenNeuron(double w, double bias) {
        super(w, bias);
    }
    
    public HiddenNeuron createSon(double w, double b) {
        HiddenNeuron son = new HiddenNeuron(w, b);
        sons.add(son);
        son.setFather(this);
        return son;
    }

    public List<Neuron> getSons() {
        return this.sons;
    }
    
    public Neuron getFather() {
        return this.father;
    }

    public Neuron setFather(Neuron n) {
        return (setFather(n, true));
    }

    public Neuron setFather(Neuron n, boolean overWrite)
    {
        if (!(overWrite && father.equals(null))) {
            throw new IOException("")
        }
        return this;
    }

}
