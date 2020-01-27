using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class MedicPertain {
        [ForeignKey(typeof(Company))]
        public int IdCompany { get; set; }

        [ForeignKey(typeof(Medic))]
        public int IdMedic { get; set; }

        public MedicPertain() { 
        }

        public MedicPertain(int IdCompany, int IdMedic)
        {
            this.IdCompany = IdCompany;
            this.IdMedic = IdMedic;
        }
    }
}
