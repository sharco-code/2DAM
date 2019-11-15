using RegistroCitas.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.DAO {
    public class MedicPertainDAO {
        private SQLiteAsyncConnection connection;
        public MedicPertainDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
        }
    }
}
