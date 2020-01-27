using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppointmentRecord.View
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class HistoryAppointmentView : ContentPage
    {

        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        public HistoryAppointmentView()
        {
            InitializeComponent();
        }

        private async void Appointment_ItemTapped(object sender, ItemTappedEventArgs e)
        {
            var clickedObj = e.Item as Appointment;

            Medic m = medicDAO.getMedicById(clickedObj.IdMedic);
            await DisplayAlert("Cita", "Médico: " + m.Name + " " + m.Surnames + "\nFecha: " + clickedObj.Date, "Volver");

        }
        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }
    }
}