using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace Facturacion.Model {
    public class Article {
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public string Description { get; set; }
        public string PVP { get; set; }
        public string IVA { get; set; }
    }
}
