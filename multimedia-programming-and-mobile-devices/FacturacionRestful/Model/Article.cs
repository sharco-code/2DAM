using System;
using System.Collections.Generic;
using System.Text;

namespace FacturacionRestful.Model {
    public class Article {
        public int ID { get; set; }
        public string Description { get; set; }
        public string PVP { get; set; }
        public string IVA { get; set; }
    }
}
