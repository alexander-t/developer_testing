using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProgrammingByContract.CodeContracts;

namespace ProgrammingByContractTests
{
    [TestClass]
    public class TimeTest
    {
        [TestMethod]
        public void ValidHours()
        {
            new Time(0, 1);
            new Time(1, 1);
            new Time(15, 1);
            new Time(22, 1);
            new Time(23, 1);
        }

        [TestMethod]
        public void NegativeHourNotAccepted()
        {
            new Time(-1, 1);

        }

        [TestMethod]
        public void hoursGreaterThan23AreInvalid()
        {
            new Time(24, 1);
        }

        [TestMethod]
        public void validMinutes()
        {
            new Time(0, 0);
            new Time(0, 1);
            new Time(0, 30);
            new Time(0, 58);
            new Time(0, 59);
        }

        [TestMethod]
        public void negativeMinuteNotAccepted()
        {
            new Time(0, -1);
        }

        [TestMethod]
        public void minutesGreaterThan59AreInvalid()
        {
            new Time(1, 60);
        }
    }
}
