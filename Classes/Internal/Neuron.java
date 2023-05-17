package Classes.Internal;

public class Neuron {
    private double[] weight;
    private double[] bias;

    public Neuron(double[] weight , double[] bias) {
        
    }
    public Neuron() {
        
    }

    public double predict(NeuraInput input)
    {
        throw new UnsupportedOperationException("stub");
        // if input.Grade()
    }

    public void train(double input, double target, double lr) {
        throw new UnsupportedOperationException("stub");
       // double predicted = predict(input);
       // double error = target - predicted;
       // this.weight += (input * error * lr);
       // this.bias += (error * lr);
    }

    public double[] getWeights() {
        return weight;
    }
    public double getWeightAtIndex(int index) {
        return weight[index];
    }
    public double[] getBias() {
        return weight;
    }
    public double getBiasAtIndex(int index) {
        return weight[index];
    }

}
