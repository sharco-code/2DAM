using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace AppointmentRecord.config
{
    public class FillDatabase
    {
        private CompanyDAO companyDAO = new CompanyDAO(Config.Database);
        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        private MedicPertainDAO medicPertainDAO = new MedicPertainDAO(Config.Database);
        private SpecialtyDAO specialtyDAO = new SpecialtyDAO(Config.Database);

        public void insertCompanies()
        {
            Company c1 = new Company(1, "Medicos Pro");
            Company c2 = new Company(2, "TeCuramos.com");
            Company c3 = new Company(3, "Asegurancias Loa");
            companyDAO.insert(c1);
            companyDAO.insert(c2);
            companyDAO.insert(c3);
        }
        public void insertMedics()
        {
            Medic[] m = new Medic[15];

            m[0] = new Medic(1, "Javier", "Sarrion", "20148963F", 1, 1);
            m[1] = new Medic(2, "Marcos", "Franco", "20148963F", 2, 1);
            m[2] = new Medic(3, "Raul", "Pastor", "20148963F", 3, 1);
            m[3] = new Medic(4, "Javier", "Galan", "20148963F", 4, 1);
            m[4] = new Medic(5, "Maria", "Sierra", "20148963F", 5, 1);

            m[5] = new Medic(6, "Pedro", "Perea", "20148963F", 1, 2);
            m[6] = new Medic(7, "Dimitri", "Martinez", "20148963F", 2, 2);
            m[7] = new Medic(8, "Javier", "Simarro", "20148963F", 3, 2);
            m[8] = new Medic(9, "Sofian", "Fernander", "20148963F", 4, 2);
            m[9] = new Medic(10, "Roberto", "Bonaparte", "20148963F", 5, 2);

            m[10] = new Medic(11, "Sofia", "Garrigues", "20148963F", 1, 3);
            m[11] = new Medic(12, "Dimitri", "Palomares", "20148963F", 2, 3);
            m[12] = new Medic(13, "Laura", "Simarro", "20148963F", 3, 3);
            m[13] = new Medic(14, "Marcos", "Franco", "20148963F", 4, 3);
            m[14] = new Medic(15, "Dolores", "Bonaparte", "20148963F", 5, 3);

            for(int i = 0; i < m.Length;i++)
            {
                medicDAO.insert(m[i]);
            }
        }

        public void insertSpecialities()
        {
            Specialty[] s = new Specialty[5];

            s[0] = new Specialty(1, "Alergología");
            s[1] = new Specialty(2, "Anestesiología");
            s[2] = new Specialty(3, "Cardiología");
            s[3] = new Specialty(4, "Gastroenterología");
            s[4] = new Specialty(5, "Endocrinología");

            for (int i = 0; i < s.Length; i++)
            {
                specialtyDAO.insert(s[i]);
            }
        }

        public void insertMedicPertain()
        {
            MedicPertain[] m = new MedicPertain[15];

            m[0] = new MedicPertain(1, 1);
            m[1] = new MedicPertain(1, 2);
            m[2] = new MedicPertain(1, 3);
            m[3] = new MedicPertain(1, 4);
            m[4] = new MedicPertain(1, 5);

            m[5] = new MedicPertain(2, 6);
            m[6] = new MedicPertain(2, 7);
            m[7] = new MedicPertain(2, 8);
            m[8] = new MedicPertain(2, 9);
            m[9] = new MedicPertain(2, 10);

            m[10] = new MedicPertain(3, 11);
            m[11] = new MedicPertain(3, 12);
            m[12] = new MedicPertain(3, 13);
            m[13] = new MedicPertain(3, 14);
            m[14] = new MedicPertain(3, 15);

            for (int i = 0; i < m.Length; i++)
            {
                medicPertainDAO.insert(m[i]);
            }
        }
    }
}
