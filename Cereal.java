public class Cereal {
    private String name;
    private String type;
    private int nutrients;
    private double weight;

    // constructor (must be outside main)
    public Cereal(String name, String type, int nutrients, double weight) {
        this.name = name;
        this.type = type;
        this.nutrients = nutrients;
        this.weight = weight;
    }

    public int getNutrients() {
        return nutrients;
    }

    // compute mean nutrients
    public static double meanNutrients(Cereal[] cereals) {
        if (cereals == null || cereals.length == 0) return 0.0;
        double sum = 0.0;
        for (Cereal c : cereals) sum += c.getNutrients();
        return sum / cereals.length;
    }

    // compute population standard deviation of nutrients- this code snippet was provided by copilot
    public static double stdDevNutrients(Cereal[] cereals) {
        if (cereals == null || cereals.length == 0) return 0.0;
        double mean = meanNutrients(cereals);
        double sumSq = 0.0;
        for (Cereal c : cereals) {
            double diff = c.getNutrients() - mean;
            sumSq += diff * diff;
        }
        double variance = sumSq / cereals.length; // use (cereals.length - 1) for sample std dev
        return Math.sqrt(variance);
    }
    //snippet end

    public static void main(String[] args) {
        // sample data
        Cereal[] cereals = new Cereal[] {
            new Cereal("Corn Flakes", "flake", 8, 0.5),
            new Cereal("Bran", "flake", 12, 0.6),
            new Cereal("Oats", "hot", 10, 0.8),
            new Cereal("Sugar Puff", "puff", 6, 0.4)
        };

        double targetMean = 9.0;
        double maxDev = -1.0;
        Cereal maxCereal = null;

        for (Cereal c : cereals) {
            double dev = Math.abs(c.getNutrients() - targetMean);
            if (dev > maxDev) {
                maxDev = dev;
                maxCereal = c;
            }
        }

        if (maxCereal != null) {
            System.out.println("Cereal farthest from mean " + targetMean + ": " 
                + maxCereal.name + " (" + maxCereal.getNutrients() + " nutrients, deviation " + maxDev + ")");
        } else {
            System.out.println("No cereals to evaluate.");
        }
    }
}
