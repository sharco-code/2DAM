using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace RegistroCitas.DAO {
    public class AppointmentDAO {
        private SQLiteAsyncConnection connection;
        public AppointmentDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
        }

        internal void insert(Appointment appointment)
        {
            try {
                connection.InsertAsync(appointment);
            } catch {
                throw new Exception();
            }
            
        }
        internal void update(Appointment appointment)
        {
            try
            {
                connection.UpdateAsync(appointment);
            } catch {
                throw new Exception();
          }

        }
        internal void Delete(Appointment appointment)
        {
            connection.DeleteAsync(appointment).Wait();
        }
        public ObservableCollection<Appointment> GetArticles()
        {
            var l = connection.Table<Appointment>().ToListAsync().Result;
            return new ObservableCollection<Appointment>(l);
        }
    }
}
