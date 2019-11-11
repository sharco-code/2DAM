using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace RegistroCitas.config {
    public class Config {
        public static string Database = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "AppointmentRecord.db3");
        public static string FolderPath = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);
    }
}
