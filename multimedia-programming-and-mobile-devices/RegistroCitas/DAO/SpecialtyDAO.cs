using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.DAO {
    public class SpecialtyDAO {
        private SQLiteAsyncConnection connection;
        public SpecialtyDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
        }
        internal List<Specialty> getAll()
        {
            List<Specialty> result = connection.QueryAsync<Specialty>("SELECT * from Specialty").Result;
            return result;
        }
    }
}
