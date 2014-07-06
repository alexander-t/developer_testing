using System;
using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProgrammingByContract.CodeContracts
{
    public class Time
    {
        private int hour;
        private int minute;

        public Time(int hour, int minute)
        {
            Contract.Requires<ArgumentException>
                (hour >= 0 && hour <= 23);
            Contract.Requires(minute >= 0 && minute <= 59);
            this.hour = hour;
            this.minute = minute;
        }
    }
}
