package Classes.Internal;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**
 * Represents the neural network
 */
public class Neura {
    public List<NeuraLayer> layers;

    public Neura() {
        this.layers = new ArrayList<>();
    }

    public Neura addLayer(NeuraLayer layer) {
        layers.add(layer);
        return this;
    }
    /** 
     * Saves the network to a String used for making a text file
     */
    public String toText() {
        StringBuilder sb = new StringBuilder();
        int layerIndex = 1;
        for (NeuraLayer layer : layers) {
            sb.append(layer.toText(layerIndex));
            layerIndex++;
        }
        return sb.toString();
    }

    /**
     * Saves the network to a file
     * 
     */
    public void Save()
    {
        try {
            File file = new java.io.File("network.txt");
            PrintWriter output = new java.io.PrintWriter(file);
            output.print(this.toText());
            output.close();
        } catch (Exception e) {
            System.err.println("Error saving network");
        }
    }


}
