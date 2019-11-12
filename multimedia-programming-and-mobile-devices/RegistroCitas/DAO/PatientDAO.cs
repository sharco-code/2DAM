using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace RegistroCitas.DAO {
    public class PatientDAO {
        private SQLiteAsyncConnection connection;
        public PatientDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
            connection.CreateTableAsync<Patient>().Wait();
        }

        internal void save(Patient patient)
        {
            if (patient.IdPatient != 0)
            {
                connection.UpdateAsync(patient);
            }
            else
            {
                connection.InsertAsync(patient);
            }
        }
        internal void delete(Patient patient)
        {
            connection.DeleteAsync(patient).Wait();
        }
        public ObservableCollection<Patient> GetArticles()
        {
            var l = connection.Table<Patient>().ToListAsync().Result;
            return new ObservableCollection<Patient>(l);
        }
    }
}
