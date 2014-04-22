using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public enum Gender { Male, Female, Unknown}
    
    public class PremiumRuleEngine 
    {
        public double GetPremiumFactor(int age, Gender gender)
        {
            double genderMultiplier = gender
                    == Gender.Female ? 0.9 : 1;
            if (age >= 18 && age < 24)
            {
                return 1.75 * genderMultiplier;
            }
            else if (age >= 24 && age < 60)
            {
                return 1 * genderMultiplier;
            }
            else if (age >= 60)
            {
                return 1.35 * genderMultiplier;
            }
            throw new ArgumentOutOfRangeException(
                    "Age out of range");
        }
    }
    
}
