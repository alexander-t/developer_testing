using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class Computer
    {
        private readonly Money basePrice;
        private Cpu cpu;
        private Ram ram;
        private HardDrive hardDrive;
        
        public Computer(Money basePrice) {
            this.basePrice = basePrice;
            cpu = new Cpu(Manufacturer.Acme, 
                "Dual core 3GHz", new Money(50));
            ram = new Ram(Manufacturer.Omega, 
                "4GB 1600MHz", new Money(45));
            hardDrive = new HardDrive(Manufacturer.Beta, 
                "2TB", new Money(100));
        }

        public Money GetTotalPrice() {
            return basePrice + cpu.Price 
                + ram.Price + hardDrive.Price;
        }
    }

    public class Money {
        int value;
        public Money(int value)
        {
            this.value = value;
        }

        public static Money operator +(Money m1, Money m2) {
            return new Money(m1.value + m2.value);
        }

        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            return this.value == ((Money) obj).value;
        }

        public override string ToString()
        {
            return value.ToString();
        }
    }

    class ComputerComponent 
    {
        private Manufacturer manufacturer;
        private string description;
        private Money price;

        public Money Price { get { return price; } }

        public ComputerComponent(Manufacturer manufacturer, string description, Money price) 
        {
            this.manufacturer = manufacturer;
            this.description = description;
            this.price = price;
        }
    }
    
    class Cpu : ComputerComponent
    {
        public Cpu(Manufacturer manufacturer, string descrioption, Money price) : base(manufacturer, descrioption, price) { }
    }

    class Ram : ComputerComponent
    { 
        public Ram(Manufacturer manufacturer, string descrioption, Money price) : base(manufacturer, descrioption, price) { }
    }

    class HardDrive : ComputerComponent
    {
        public HardDrive(Manufacturer manufacturer, string descrioption, Money price) : base(manufacturer, descrioption, price) { }
    }

    enum Manufacturer
    {
        Acme, Omega, Beta
    }
}
