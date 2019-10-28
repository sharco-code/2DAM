using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;
using Facturacion.Model;
using SQLite;

namespace Facturacion.DAO {
    public class ClientDAO {
        private SQLiteAsyncConnection connection;
        public ClientDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
            connection.CreateTableAsync<Client>().Wait();
        }

        internal void Save(Client client)
        {
            if(client.ID != 0)
            {
                connection.UpdateAsync(client);
            } else
            {
                connection.InsertAsync(client);
            }
        }
        internal void Delete(Client client)
        {
            connection.DeleteAsync(client).Wait();
        }
        public ObservableCollection<Client> GetClients() {
            var l = connection.Table<Client>().ToListAsync().Result;
            return new ObservableCollection<Client>(l);
        }
    }
}
