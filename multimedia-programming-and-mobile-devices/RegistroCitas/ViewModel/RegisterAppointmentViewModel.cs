using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.ViewModel {

    public class RegisterAppointmentViewModel {
        public Company Company { get; set; }

        private CompanyDAO companyDAO = new CompanyDAO(Config.Database);

        public IList<string> Names
        {
            get
            {
                List<Company> companies = companyDAO.getAll();
                List<string> lst = new List<string>();
                foreach(Company c1 in companies)
                {
                    lst.Add(c1.Name);
                }
               
                return lst;
            }
        }
    }
}
