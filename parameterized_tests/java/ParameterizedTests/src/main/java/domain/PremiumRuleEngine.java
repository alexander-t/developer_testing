package domain;

public class PremiumRuleEngine {
    public double getPremiumFactor(int age, Gender gender) {
        double genderMultiplier = gender == Gender.FEMALE ? 0.9 : 1;
        if (age >= 18 && age < 24) {
            return 1.75 * genderMultiplier;
        } else if (age >= 24 && age < 60) {
            return 1 * genderMultiplier;
        } else if (age > 60) {
            return 1.35 * genderMultiplier;
        }
        throw new IllegalArgumentException();
    }
}
