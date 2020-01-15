using FacturacionRestful.DAO;
using FacturacionRestful.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace FacturacionRestful.ViewModel {
    public class ClientDetail_ViewModel {
        public Client Client { get; set; }
        private ClientDAO clientDao = new ClientDAO();
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
