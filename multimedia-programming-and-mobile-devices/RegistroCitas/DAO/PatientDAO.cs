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
        }

        internal void insert(Patient patient)
        {
            try
            {
                connection.InsertAsync(patient);
            }
            catch
            {
                throw new Exception();
            }

        }
        internal void update(Patient patient)
        {
            try
            {
                connection.UpdateAsync(patient);
            }
            catch
            {
                throw new Exception();
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
        internal bool hasPatient()
        {
            List<Company> result = connection.QueryAsync<Company>("SELECT * FROM Patient").Result;
            if ((result == null) || (result.Count == 0))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
