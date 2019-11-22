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
        internal IList<Appointment> GetAppointmentByMedicAndDate(int IdMedic, String Date)
        {
            string[] words = Date.Split(' ');
            IList<Appointment> list = connection.QueryAsync<Appointment>("SELECT* from Appointment WHERE IdMedic like "+IdMedic+" and Date like \""+words[0]+"%\"").Result;
                return list;

        }
        internal ObservableCollection<Appointment> GetHistoricAppointments()
        {
            IList < Appointment > list = connection.QueryAsync<Appointment>("SELECT * FROM Appointment WHERE isHistory LIKE 1").Result;
            return new ObservableCollection<Appointment>(list);
        }
        internal ObservableCollection<Appointment> GetNonHistoricAppointments()
        {
            IList<Appointment> list = connection.QueryAsync<Appointment>("SELECT * FROM Appointment WHERE isHistory LIKE 0").Result;
            return new ObservableCollection<Appointment>(list);
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
        internal void delete(Appointment appointment)
        {
            connection.DeleteAsync(appointment).Wait();
        }
        public ObservableCollection<Appointment> GetAppointments()
        {
            var l = connection.Table<Appointment>().ToListAsync().Result;
            return new ObservableCollection<Appointment>(l);
        }
    }
}
