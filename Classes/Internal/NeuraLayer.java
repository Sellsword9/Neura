package Classes.Internal;

import java.util.Iterator;
import java.util.List;
/**
 * Iterable class that contains a list of neurons
 * 
 */
public class NeuraLayer implements Iterable<Neuron> {
    public List<Neuron> neurons;

    public double getAverageWeigth(int InputNumber, boolean overOne) {
        double value = 0;
        for (Neuron n : this){
            value += n.getWeightAtIndex(InputNumber);
        }
        return /*is*/ overOne? 
        /* then */ NeuraMath.avg1.apply(value, neurons.size()) :
        /* else */ NeuraMath.avg100.apply(value, neurons.size());
    }


    @Override
    public Iterator<Neuron> iterator() {
        return neurons.iterator();
    }
}
