using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class Specialty {
        [PrimaryKey, AutoIncrement]
        public int IdSpecialty { get; set; }
        public string Name { get; set; }

        public Specialty() { 
        }
        
        public Specialty(int IdSpecialty, string Name)
        {
            this.Name = Name;
            this.IdSpecialty = IdSpecialty;
        }
    }
}
