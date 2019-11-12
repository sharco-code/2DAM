using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace RegistroCitas.DAO {
    public class MedicDAO {
        private SQLiteAsyncConnection connection;
        public MedicDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
            connection.CreateTableAsync<Medic>().Wait();
        }

        internal void save(Medic medic)
        {
            if (medic.IdMedic != 0)
            {
                connection.UpdateAsync(medic);
            }
            else
            {
                connection.InsertAsync(medic);
            }
        }
        internal void delete(Medic medic)
        {
            connection.DeleteAsync(medic).Wait();
        }
        public ObservableCollection<Medic> GetArticles()
        {
            var l = connection.Table<Medic>().ToListAsync().Result;
            return new ObservableCollection<Medic>(l);
        }
    }
}
