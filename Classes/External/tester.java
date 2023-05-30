package Classes.External;
import Classes.Internal.*;

public class tester {
    public static void main(String[] args) {
        Neura network = new Neura()
        .addLayer(
            new NeuraLayer(
                new NeuraInput(5.0, null)));
        network.layers.get(0).addNeuron();
        network.layers.get(0).addNeuron();
        network.layers.get(0).addNeuron();
        network.layers.get(0).addNeuron();
        //All neurons in the first layer now have 5 as input and 1 as weight: should output 5
        NeuraLayer layer0 = network.layers.get(0);
        NeuraInput input0layer0 = layer0.neuraInputs.get(0);
        System.out.println(layer0.getAverageWeigth(input0layer0));
        System.out.println(layer0.getAverageOutput());
        //Let's train the neurons to output 10 (f=2x)
        for (int i = 0; i < 1000; i++) {
        layer0.train(input0layer0, 10.0, 0.01);   
        System.out.println(layer0.getAverageOutput()); 
        }
        System.out.println(layer0.getAverageOutput());
        
        network.addLayer(new NeuraLayer(layer0.neuraInputs.get(0)));
        NeuraLayer layer1 = network.layers.get(1);
        layer1.addNeuron();
        layer1.addNeuron();
        layer1.addNeuron();
        layer1.addNeuron();
        layer1.addNeuron();

        System.out.println(network.toText());
    }
}
