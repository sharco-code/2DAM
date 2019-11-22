using SQLite;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.Model {
    public class Company {
        [PrimaryKey, AutoIncrement]
        public int IdCompany { get; set; }
        public string Name { get; set; }

        [ManyToMany(typeof(MedicPertain))]
        public int IdMedic { get; set; }
       
        public Company() { }
        public Company(int IdCompany, string Name)
        {
            this.IdCompany = IdCompany;
            this.Name = Name;
        }
    }
}

