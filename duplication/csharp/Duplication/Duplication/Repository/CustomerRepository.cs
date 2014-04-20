using Duplication.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Duplication.Repository
{
    public class CustomerRepository
    {

        // Mimic a legacy create method
        public void Create(Customer customer)
        {
            if (customer.Gender == Gender.Unknown || !customer.YearOfBirth.HasValue)
            {
                throw new ArgumentException("Incomplete customer");
            }

            if (DateTime.Now.Year - customer.YearOfBirth.Value < 18)
            {
                throw new ArgumentOutOfRangeException("Underage customer");
            }

            // Equally scary logic for saving would go here...

        }

        // Mimic a legacy update method
        public void Update(Customer customer)
        {
            if (customer.Gender == Gender.Unknown || !customer.YearOfBirth.HasValue)
            {
                throw new ArgumentException("Incomplete customer");
            }

            if (DateTime.Now.Year - customer.YearOfBirth.Value < 18)
            {
                throw new ArgumentOutOfRangeException("Underage customer");
            }
        }
    }

}
