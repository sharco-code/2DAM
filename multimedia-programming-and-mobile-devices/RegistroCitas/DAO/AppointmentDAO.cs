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
            connection.CreateTableAsync<Appointment>().Wait();
        }

        internal void Save(Appointment appointment)
        {
            if (appointment.IdAppointment != 0)
            {
                connection.UpdateAsync(appointment);
            }
            else
            {
                connection.InsertAsync(appointment);
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
