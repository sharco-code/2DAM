using Facturacion.DAO;
using Facturacion.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Facturacion.ViewModel {
    public class ClientDetail_ViewModel {
        public Client Client { get; set; }
        private ClientDAO clientDao = new ClientDAO(Config.Database);
        internal void SaveClient()
        {
            clientDao.Save(Client);
        }
        internal void DeleteClient()
        {
            clientDao.Delete(Client);
        }
    }
}
