package Classes.Internal;
import java.util.function.BiFunction;
import java.util.function.Function;
public class NeuraMath {
    public static final BiFunction<Double, Integer, Double> avg = (sum, size) ->  sum / (size * 1.00);
    // Deleted this line because it didn't make any sense mathematically
    private static final Function<String, String[]> decomposerSubstract = str -> str.strip().replaceAll("-","@").split("@");
    
    
    
    
    
    public static void main(String[] args) {
        String exp1 = "2x";
        int exp2 = 4;
        System.out.println("Expected " + exp1 + ", " + exp2);
        System.out.println("Obtained: ");
        String[] a = decomposerSubstract.apply("2x + 4");
        for (String b : a)
        System.out.println(b.strip());
    }
}

