using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace RegistroCitas.ViewModel {
    class ManageAppointmentViewModel {
        private AppointmentDAO appointmentDAO = new AppointmentDAO(Config.Database);

        public IList<Appointment> Appointments
        {
            get
            {

                return appointmentDAO.GetNonHistoricAppointments();
            }
        }
    }
}
