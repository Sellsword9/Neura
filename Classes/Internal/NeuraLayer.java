package Classes.Internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterable class that contains a list of neurons
 * 
 */
public class NeuraLayer implements Iterable<NeuraInput>{
    public List<Neuron> neurons;
    public List<NeuraInput> neuraInputs;

    public void addNeuraInput(NeuraInput input) {
        this.neuraInputs.add(input);
    }

    public NeuraLayer() {
        this.neuraInputs = new ArrayList<>();
        this.neurons = new ArrayList<>();
    }
    /**
     * Creates a new layer with a single input set
     * @param input The input to set
     */
    public NeuraLayer(NeuraInput input) {
        this.neurons = new ArrayList<>();
        this.neuraInputs = new ArrayList<>();
        this.neuraInputs.add(input);
    }
    /**
     * Returns the average weights of all neurons in the layer
     * for a specific input
     * @param InputNumber
     * @param overOne If true, returns a value between 0 and 1, else returns a value between 0 and 100
     * @return The average weight of all neurons in the layer for the specified input
     */
    public double getAverageWeigth(NeuraInput input) {
        double value = 0;
        for (Neuron n : neurons){
            value += n.getWeightAtIndex(input.getIndex());
        }
        return NeuraMath.avg.apply(value, neurons.size());
    }
    public double getAverageOutput() {
        double value = 0;
        for (Neuron n : neurons){
            for (NeuraInput input : this) {
                value += n.predict(input);
            }
        }
        return NeuraMath.avg.apply(value, neurons.size());
    }

    /**
     * Adds a new neuron to the layer
     */
    public NeuraLayer addNeuron() {
        Neuron n = new Neuron();
        this.neurons.add(n);
        return this;
    }
    @Override
    public Iterator<NeuraInput> iterator() {
        return neuraInputs.iterator();
    }



    public void train(NeuraInput input, double target, double lr) {
        for (Neuron n : this.neurons) {
            n.train(input, target, lr);
        }
    }

    public String toText(int layerIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("Layer " + layerIndex + ": " + "\n");
        int total_neurons = 0;
        for (Neuron n : neurons) {
            total_neurons++;
        }
        sb.append("Neurons: " + total_neurons);
        sb.append("\n" + "Average weight: " + getAverageWeigth(neuraInputs.get(0)));
        sb.append("\n" + "Average output: " + getAverageOutput());
        sb.append("\n");
        return sb.toString();
    } 

}
