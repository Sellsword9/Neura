package Classes.Internal;

import java.util.ArrayList;
import java.util.List;

public class NeuraInput {
    private Neuron source;
    private Neuron[] neurons;
    private List<Double> inputs;
    private int grade;

    public static NeuraInput CreateInput(NeuraInput base, double input, Neuron src) {
        return null;
    }


    /**
     * 
     * @return The amount of inputs (1-many)
     */
    public int Grade()
    {
        return grade;
    }
    /**
     * 
     * @return The neurons this input is attached to
     */
    public Neuron[] getNeurons()
    {
        return neurons;
    }

    /**
     * If this input is not shared between more than one neuron, returns that one neuron.
     * Else, returns the first one added
     * @return The one neuron that takes this input
     * 
     */
    public Neuron getNeuron(){
        return neurons[0];
    }

    public Neuron getSource() {
        return source;
    }
}