package Classes.Internal;

public abstract class Neuron {
    private double weight;
    private double bias;

    public Neuron(double w, double bias) {
        this.weight = w;
        this.bias = bias;
    }
    public Neuron() {
        this(1, 1);
    }

    public double predict(double input)
    {
        double out = (input * weight) + bias;
        return out;
    }

    public void train(double input, double target, double lr) {
        double predicted = predict(input);
        double error = target - predicted;
        this.weight += (input * error * lr);
        this.bias += (error * lr);
    }
}
