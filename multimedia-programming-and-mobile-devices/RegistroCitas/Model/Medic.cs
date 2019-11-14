using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class Medic {
        [PrimaryKey, AutoIncrement]
        public int IdMedic { get; set; }
        public string Name { get; set; }
        public string Surnames { get; set; }
        public string DNI { get; set; }
        [ForeignKey(typeof(Specialty))]
        public int IdSpecialty { get; set; }

        [ManyToMany(typeof(Company))]
        public int IdCompany { get; set; }
    }
}
