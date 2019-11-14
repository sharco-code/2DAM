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
        internal List<Medic> getAll()
        {
            List<Medic> result = connection.QueryAsync<Medic>("SELECT * from Medic").Result;
            return result;
        }
        
        internal List<Medic> getAllFromCompanyAndSpecialty(String companyName, String specialtyName)
        {
            List<Medic> result = connection.QueryAsync<Medic>("SELECT Medic.IdMedic, Medic.Name, Medic.Surnames, Medic.DNI, Medic.IdSpecialty from Medic, MedicPertain, Company, Specialty WHERE Medic.IdMedic like MedicPertain.IdMedic and Company.IdCompany like MedicPertain.IdCompany and Medic.IdSpecialty like Specialty.IdSpecialty and Specialty.Name like \""+specialtyName+"\" and Company.Name like\""+companyName+"\"").Result;
            return result;
        }
        
        public ObservableCollection<Medic> GetArticles()
        {
            var l = connection.Table<Medic>().ToListAsync().Result;
            return new ObservableCollection<Medic>(l);
        }
    }
}
