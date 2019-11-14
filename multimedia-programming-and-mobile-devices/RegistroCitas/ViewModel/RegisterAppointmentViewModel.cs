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
        private MedicPertainDAO medicPertainDAO = new MedicPertainDAO(Config.Database);
        private SpecialtyDAO specialtyDAO = new SpecialtyDAO(Config.Database);

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

        public List<String> getMedicFiltered(String companyName, String specialtyName)
        {

            List<Medic> medics = medicDAO.getAllFromCompanyAndSpecialty(companyName, specialtyName);
            List<string> lst = new List<string>();
            foreach (Medic m in medics)
            {
                lst.Add(m.Name);
            }
            return lst;
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
