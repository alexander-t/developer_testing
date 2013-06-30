using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class PersonCreator
    {
        public static Person CreatePersonEntity(PersonDTO dto)
        {
            return new Person
            {
                Id = Guid.NewGuid(),
                FirstName = dto.FirstName,
                LastName = dto.LastName,
                Age = dto.Age,
                Created = DateTime.Now
            };
        }
    }
}
