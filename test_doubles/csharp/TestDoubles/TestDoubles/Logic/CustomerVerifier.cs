using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles.Logic
{
    public class CustomerVerifier
    {
        public static void Verify(int age, string firstName, string lastName)
        {
            if (age < 20)
            {
                throw new ArgumentOutOfRangeException("Minimum age is 20");
            }

            // Method continues...
            // Do something with the name parameters

            throw new NotImplementedException();
        }
    }
}
