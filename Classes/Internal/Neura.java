/**
 * Neura.java
 * This class is a neural network that can be trained to predict the output of a linear function. (2x + 1)
 * To change the function, change the target values in the training section
 */
package Classes.Internal;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

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
        double learningRate = 0.01;
        double predicted = predict(input);
        double error = target - predicted;
        this.weight += (input * error * learningRate);
        this.bias += (error * learningRate);
    }

    public static void main(String[] args) {
        // Create the neural network
        Neura neuralNetwork = new Neura();

        // Inicial training section
        Function<Double, Double> function = (x) -> (2 * x) + 4;
        double input = 2.0;
        double target = function.apply(input);
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 4.0;
        target = function.apply(input);
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 3.0;
        target = function.apply(input);
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        input = 5.0;
        target = function.apply(input);
        for (int i = 0; i < 1000000; i++) {
            neuralNetwork.train(input, target);
        }
        // Prediction
        System.out.println("Introduce input number for calculations: ");
        Scanner inputManager = new Scanner(System.in);
        double testInput = inputManager.nextInt();
        inputManager.close();
        double predictedOutput = neuralNetwork.predict(testInput);
        double expectedOutput = function.apply(testInput);

        System.out.println("Input: " + testInput);
        System.out.println("Correct output: " + function.apply(testInput));
        System.out.println("First predicted Output: " + predictedOutput);
        System.out.println("Applying training:");
        try{
            int counter = 0;
            while (!(Math.abs(predictedOutput - expectedOutput) < 0.001)) {
                neuralNetwork.train(testInput, expectedOutput);
                predictedOutput = neuralNetwork.predict(testInput);
                System.out.println("Predicted Output: " + predictedOutput + "(real: " + expectedOutput + ")");
                Thread.sleep(1000 - counter / 10);
                System.out.println("Current bias and weight: " + neuralNetwork.bias + ", " + neuralNetwork.weight);
                counter++;
            }
            System.out.println("Number of iterations needed: " + counter);
        }catch(InterruptedException e){
            System.out.println("Warning --> Sleep method failed: " + e);
        }
    }
}
