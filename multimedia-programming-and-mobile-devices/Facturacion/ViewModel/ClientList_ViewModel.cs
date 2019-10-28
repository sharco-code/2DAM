using Facturacion.DAO;
using Facturacion.Model;
using Facturacion.View;
using Facturacion.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace Facturacion.ViewModel {
    public class ClientList_ViewModel : ViewModelBase {
        public ObservableCollection<Client> ClientList { get; set; }

        private ClientDAO clientDAO = new ClientDAO(Config.Database);
        public ClientList_ViewModel() {

            ClientList = clientDAO.GetClients();

        }
    }
}
