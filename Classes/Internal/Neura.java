package Classes.Internal;
/**
 * Represents the neural network
 */

import java.util.ArrayList;
import java.util.List;

public class Neura {
    public List<NeuraLayer> layers;

    public Neura() {
        this.layers = new ArrayList<>();
    }

    public Neura addLayer(NeuraLayer layer) {
        layers.add(layer);
        return this;
    }
}
