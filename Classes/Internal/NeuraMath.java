package Classes.Internal;
import java.util.function.BiFunction;
public class NeuraMath {
    public static final BiFunction<Double, Integer, Double> avg1 = (sum, size) ->  sum / (size * 1.00);
    public static final BiFunction<Double, Integer, Double> avg100 = (sum, size) ->  (sum / (size * 1.00)) * 100;
}
