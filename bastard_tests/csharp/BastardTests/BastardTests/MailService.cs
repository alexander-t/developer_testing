using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;

namespace FastTests
{
    public class MailService
    {
        private const String Footer = "Kindest regards,\nNafGraax Support";

        private readonly MailAddress FromAddress
            = new MailAddress("support@nafgraax.com", "NafGraax Support");

        private SmtpClient smtpClient;

        public MailService(String smtpServer)
        {
            smtpClient = new SmtpClient(smtpServer, 25);
        }

        public void SendMail(MailAddress toAddress, String subject, String body)
        {
            MailMessage mail = new MailMessage(FromAddress, toAddress);
            mail.Subject = subject;
            mail.Body = body + "\nKindest regards\nNafGraax Support";
            smtpClient.Send(mail);
        }
    }
}
