package Classes.Internal;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private List<Double> weights;
    private List<Double> biases;

    public Neuron(List<Double> weight , List<Double> bias) {
        this.weights = weight;
        this.biases = bias;
    }

    public Neuron() {
        this.weights = new ArrayList<>();
        this.biases = new ArrayList<>();
        this.weights.add(1.0);
        this.biases.add(0.0);
    }
    
    public double predict(NeuraInput input)
    {
        int index = input.getIndex();
        return input.getValue() * weights.get(index) + biases.get(index);
    }

    public void train(NeuraInput input, double target, double lr) {
        int index = input.getIndex();
        double weightAtIndex = weights.get(index);
        double biasAtIndex = biases.get(index);
        double predict = predict(input);
        double error = target - predict;
        double correctedWeight = weightAtIndex + error * input.getValue() * lr;
        weights.set(index, correctedWeight);
        double correctedBias = biasAtIndex + error * lr;
        biases.set(index, correctedBias);
    }

    public List<Double> getWeights() {
        return weights;
    }
    public double getWeightAtIndex(int index) {
        return weights.get(index);
    }
    public List<Double> getBiases() {
        return biases;
    }
    public double getBiasAtIndex(int index) {
        return weights.get(index);
    }

}
