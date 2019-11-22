using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.ViewModel {

    public class RegisterAppointmentViewModel {

        private CompanyDAO companyDAO = new CompanyDAO(Config.Database);
        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        private SpecialtyDAO specialtyDAO = new SpecialtyDAO(Config.Database);

        public DateTime MinDate
        {
            get
            {
                return DateTime.Now;
            }
        }
        public IList<string> CompanyNames {
            get {
                List<Company> companies = companyDAO.getAll();
                List<string> lst = new List<string>();
                foreach(Company c1 in companies)
                {
                    lst.Add(c1.Name);
                }
               
                return lst;
            }
        }
        public IList<string> Minuts
        {
            get
            {
                List<string> lst = new List<string>();
                lst.Add("00");
                lst.Add("10");
                lst.Add("20");
                lst.Add("30");
                lst.Add("40");
                lst.Add("50");
                return lst;
            }
        }
        public IList<string> Hours
        {
            get
            {
                List<string> lst = new List<string>();
                lst.Add("8");
                lst.Add("9");
                lst.Add("10");
                lst.Add("11");
                lst.Add("12");
                lst.Add("13");
                
                return lst;
            }
        }
        public IList<string> MedicNames
        {
            get
            {
                List<Medic> medics = medicDAO.getAll();
                List<string> lst = new List<string>();
                foreach (Medic m in medics)
                {
                    lst.Add(m.Name);
                }

                return lst;
            }
        }
        public IList<string> SpecialtyNames
        {
            get
            {
                List<Specialty> specialties = specialtyDAO.getAll();
                List<string> lst = new List<string>();
                foreach (Specialty s in specialties)
                {
                    lst.Add(s.Name);
                }

                return lst;
            }
        }
    }
}
