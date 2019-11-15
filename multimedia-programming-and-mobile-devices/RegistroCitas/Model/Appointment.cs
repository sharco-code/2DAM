using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class Appointment {

        [PrimaryKey, AutoIncrement]
        public int IdAppointment { get; set; }
        public int IdCompany { get; set; }
        public String Date { get; set; }

        [ForeignKey(typeof(Medic))]
        public int IdMedic { get; set; }

        [ForeignKey(typeof(Patient))]
        public int IdPatient { get; set; }

        public Appointment() { }
        public Appointment(int IdAppointment, int IdCompany, String Date, int IdMedic, int IdPatient) {
            this.IdAppointment = IdAppointment;
            this.IdCompany = IdCompany;
            this.Date = Date;
            this.IdMedic = IdMedic;
            this.IdPatient = IdPatient;
        }
    }
}
