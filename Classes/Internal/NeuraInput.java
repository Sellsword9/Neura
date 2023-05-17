package Classes.Internal;

import java.util.ArrayList;
import java.util.List;

public class NeuraInput {
    private Neuron source;
    private List<Neuron> receivers;
    private Double value;
    private int index;

    public int getIndex() {
        return index;
    }

    public NeuraInput(double value, Neuron src) {
        this.source = src;
        this.receivers = new ArrayList<>();
        this.value = value;
    }
    /**
     * Builds a new input data and assigns it to the network
     * @param layer The neuron layer to assign the input to
     * @param input The input value
     * @param src The neuron from which the input comes from
     * @return
     */
    public static NeuraInput createInput(NeuraLayer layer, double input, Neuron src) {
        NeuraInput ni = new NeuraInput(input, src);
        layer.addNeuraInput(ni);
        return ni;
    }


    /**
     * 
     * @return The amount of inputs (1-many)
     */
    /**
     * 
     * @return The neurons this input is attached to
     */
    public List<Neuron> getReceivers()
    {
        return receivers;
    }

    /**
     * If this input is not shared between more than one neuron, returns that one neuron.
     * Else, returns the first one added
     * @return The one neuron that takes this input
     * 
     */
    public Neuron getNeuron(){
        return receivers.get(0);
    }

    public Neuron getSource() {
        return source;
    }

    public double getValue() {
        return value;
    }

}