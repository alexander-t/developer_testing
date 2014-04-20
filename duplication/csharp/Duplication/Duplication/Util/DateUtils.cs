using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Duplication.Util
{
    public class DateUtils
    {
        public static long DiffTime(DateTime t1, DateTime t2)
        {
            if (t1.Date != t2.Date)
            {
                throw new ArgumentException("Incomparable dates");
            }
            return (t2.Hour - t1.Hour) * 60;
        }

        public static long DiffTime_Revised(DateTime t1, DateTime t2)
        {
            if (t1.Date != t2.Date)
            {
                throw new ArgumentException("Incomparable dates");
            }
            return (t2.Hour * 60 + t2.Minute) - (t1.Hour * 60 + t1.Minute);
        }
    }
}
