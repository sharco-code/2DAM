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
            connection.CreateTableAsync<Company>().Wait();
        }

        internal void save(Company company)
        {
            if (company.IdCompany != 0)
            {
                connection.UpdateAsync(company);
            }
            else
            {
                connection.InsertAsync(company);
            }
        }
        internal void delete(Company company)
        {
            connection.DeleteAsync(company).Wait();
        }

        internal List<Company> getAll()
        {
            List<Company> result = connection.QueryAsync<Company>("SELECT * from Company").Result;
            return result;
        }
        public ObservableCollection<Company> GetArticles()
        {
            var l = connection.Table<Company>().ToListAsync().Result;
            return new ObservableCollection<Company>(l);
        }
    }
}
