using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class Appointment {
        [PrimaryKey, AutoIncrement]
        public int IdCompany { get; set; }
        public DateTime Date { get; set; }

        [ForeignKey(typeof(Medic))]
        public int IdMedic { get; set; }

        [ForeignKey(typeof(Patient))]
        public int IdPatient { get; set; }
    }
}
