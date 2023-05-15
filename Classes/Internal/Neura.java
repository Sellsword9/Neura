/**
 * Neura.java
 * This class is a neural network that can be trained to predict the output of a linear function. (2x + 1)
 * To change the function, change the target values in the training section
 */
package Classes.Internal;
import java.util.Random;
import java.util.Scanner;

public class Neura {
    private double weight;
    private double bias;

    public Neura() {
        // Initialize random weights and bias
        Random random = new Random();
        weight = random.nextDouble();
        bias = random.nextDouble();
    }

    public double predict(double input) {
        // Apply the formula: output = (input * weight) + bias
        double output = (input * weight) + bias;
        return output;
    }

    public void train(double input, double target) {
        // Adjust the weight and bias based on the prediction error
        double learningRate = 0.02;
        double predicted = predict(input);
        double error = target - predicted;
        this.weight += (input * error * learningRate);
        this.bias += (error * learningRate);
    }

    public static void main(String[] args) {
        // Create the neural network
        Neura neuralNetwork = new Neura();

        // Inicial training section
        double input = 2.0;
        double target = 5.0;
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 4.0;
        target = 9.0;
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 3.0;
        target = 7.0;
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 5.0;
        target = 11.0;
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        // Prediction
        double testInput = new Random().nextInt(0, 11);
        double predictedOutput = neuralNetwork.predict(testInput);

        System.out.println("Input: " + testInput);
        System.out.println("First predicted Output: " + predictedOutput);
        System.out.println("Introduce 1 to continue training:");
        if (new Scanner(System.in).nextInt() == 1) {
            int counter = 0;
            while (!(Math.abs(predictedOutput - (testInput * 2 + 1)) < 0.001)) {
                neuralNetwork.train(testInput, testInput * 2 + 1);
                predictedOutput = neuralNetwork.predict(testInput);
                System.out.println("Predicted Output: " + predictedOutput);
                System.out.println("Current bias and weight (should be 1 and 2): " + neuralNetwork.bias + ", " + neuralNetwork.weight);
                counter++;
            }
            System.out.println("Number of iterations needed: " + counter);
        }
    }
}
