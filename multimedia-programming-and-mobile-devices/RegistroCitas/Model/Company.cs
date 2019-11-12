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
        public List<Medic> Medics {get; set;}
    }
}

