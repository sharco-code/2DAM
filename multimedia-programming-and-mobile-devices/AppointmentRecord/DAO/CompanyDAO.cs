using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace RegistroCitas.DAO {
    public class CompanyDAO {
        private SQLiteAsyncConnection connection;
        public CompanyDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
        }

        internal void insert(Company company)
        {

                connection.InsertAsync(company);

        }
        internal void update(Company company)
        {

                connection.UpdateAsync(company);

        }
        internal void delete(Company company)
        {
            connection.DeleteAsync(company).Wait();
        }

        internal int getIdByName(String name)
        {
            List<Company> result = connection.QueryAsync<Company>("SELECT * FROM Company WHERE Name Like \""+name+"\"").Result;
            if ((result == null) || (result.Count == 0))
            {
                return -1;
            } else
            {
                return result[0].IdCompany;
            }
            
        }

        internal List<Company> getAll()
        {
            List<Company> result = connection.QueryAsync<Company>("SELECT * from Company").Result;
            return result;
        }
        public ObservableCollection<Company> GetCompanies()
        {
            var l = connection.Table<Company>().ToListAsync().Result;
            return new ObservableCollection<Company>(l);
        }
    }
}
