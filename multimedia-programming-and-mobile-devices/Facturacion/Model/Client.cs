using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace Facturacion.Model {
    public class Client {
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public string DNI { get; set; }
        public string Name { get; set; }
        public string Surnames { get; set; }
        public string Adress { get; set; }
        public string Locality { get; set; }
        public string PostalCode { get; set; }
        public string Province { get; set; }
        public string Country { get; set; }
    }
}
