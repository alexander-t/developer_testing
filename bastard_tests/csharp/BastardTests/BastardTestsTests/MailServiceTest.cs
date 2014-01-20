using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using FastTests;
using System.Net.Mail;
using netDumbster.smtp;

namespace FastTestsTests
{
    [TestClass]
    public class MailServiceTest
    {
        private SimpleSmtpServer smtpServer;

        [TestInitialize]
        public void Setup()
        {
            smtpServer = SimpleSmtpServer.Start(25);
        }

        [TestCleanup]
        public void TearDown()
        {
            smtpServer.Stop();
        }

        [TestMethod]
        public void CompanyInformationIsPresentInEmail()
        {
            MailService testedService 
                = new MailService("localhost");
            testedService.SendMail(new MailAddress("user@test.com"), 
                "Dear customer", "We care!");
            
            Assert.AreEqual(1, smtpServer.ReceivedEmailCount);
            
            SmtpMessage sentMail 
                = (SmtpMessage)smtpServer.ReceivedEmail[0];
            Assert.AreEqual("support@nafgraax.com", 
                sentMail.FromAddress.ToString());
            StringAssert.Contains(sentMail.Data, 
                "NafGraax Support");
        }
    }
}
