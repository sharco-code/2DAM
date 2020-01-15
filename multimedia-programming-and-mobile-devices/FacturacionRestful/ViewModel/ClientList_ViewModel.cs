using FacturacionRestful.DAO;
using FacturacionRestful.Model;
using FacturacionRestful.View;
using FacturacionRestful.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace FacturacionRestful.ViewModel {
    public class ClientList_ViewModel : ViewModelBase {
        public ObservableCollection<Client> ClientList { get; set; }

        private ClientDAO clientDAO = new ClientDAO();
        public ClientList_ViewModel() {

            ClientList = clientDAO.GetAll();

        }
    }
}
