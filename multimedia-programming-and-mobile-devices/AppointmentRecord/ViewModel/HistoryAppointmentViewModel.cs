using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace AppointmentRecord.ViewModel
{
    class HistoryAppointmentViewModel
    {
        private AppointmentDAO appointmentDAO = new AppointmentDAO(Config.Database);

        public IList<Appointment> Appointments
        {
            get
            {

                return appointmentDAO.GetHistoricAppointments();
            }
        }
    }
}
