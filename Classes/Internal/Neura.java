package Classes.Internal;
import java.util.ArrayList;
import java.util.List;
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

}
