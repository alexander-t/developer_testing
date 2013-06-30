using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class Entity
    {
        public Guid Id { get; set; }
        public Object Attribute1 { get; set; }
        public Object Attribute2 { get; set; }
        public DateTime Created { get; set; }
    }

    public class EntityDTO
    {
        public Object Attribute1 { get; set; }
        public Object Attribute2 { get; set; }
    }

    public class EntityCreator
    {
        public static Entity CreateEntity(EntityDTO dto)
        {
            return new Entity
            {
                Id = Guid.NewGuid(),
                Attribute1 = dto.Attribute1,
                Attribute2 = dto.Attribute2,
                Created = DateTime.Now
            };
        }
    }
}
