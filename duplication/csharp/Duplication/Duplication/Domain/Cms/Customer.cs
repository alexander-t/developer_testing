using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Duplication.Domain
{

    public enum Gender 
    {
        Male, 
        Female, 
        Unknown
    }

    public class Customer
    {
        public Gender Gender {get; set;}

        public int? YearOfBirth { get; set; }
    }
}
