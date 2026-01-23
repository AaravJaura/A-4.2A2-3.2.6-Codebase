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

    // compute population standard deviation of nutrients
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

    public static void main(String[] args) {
        // sample data
        Cereal[] cereals = new Cereal[] {
            new Cereal("Corn Flakes", "flake", 8, 0.5),
            new Cereal("Bran", "flake", 12, 0.6),
            new Cereal("Oats", "hot", 10, 0.8),
            new Cereal("Sugar Puff", "puff", 6, 0.4)
        };

        double mean = meanNutrients(cereals);
        double stddev = stdDevNutrients(cereals);

        System.out.println("Mean nutrients: " + mean);
        System.out.println("Std dev (population): " + stddev);
    }
}
