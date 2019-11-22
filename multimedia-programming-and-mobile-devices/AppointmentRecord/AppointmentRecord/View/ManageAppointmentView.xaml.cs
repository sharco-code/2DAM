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

namespace RegistroCitas.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ManageAppointmentView : ContentPage {

        private AppointmentDAO appointmentDAO = new AppointmentDAO(Config.Database);
        public ManageAppointmentView()
        {
            InitializeComponent();
            SetValue(NavigationPage.BarBackgroundColorProperty, Color.Black);
        }


        private async void Appointment_ItemTapped(object sender, ItemTappedEventArgs e)
        {

            
            
            bool result = await DisplayAlert("Cita", "¿Borrar cita?", "Si", "Cancelar");
            if (result == true)
            {
                var clickedObj = e.Item as Appointment;

                

                //comprobacion de cuando se puede borrar
                string[] datex = clickedObj.Date.Split(' ');
                string[] date = datex[0].Split('/');

                if(Int32.Parse(DateTime.Now.AddDays(Config.CancelRestrictionDays).Day.ToString()) > Int32.Parse(date[0])
                    && Int32.Parse(DateTime.Now.AddDays(Config.CancelRestrictionDays).Month.ToString()) > Int32.Parse(date[1])
                    && Int32.Parse(DateTime.Now.AddDays(Config.CancelRestrictionDays).Year.ToString()) > Int32.Parse(date[2]))
                {
                    appointmentDAO.delete(clickedObj);
                    Navigation.PopAsync();
                } else
                {
                    await DisplayAlert("info", "Demasiado tarde para borrar la cita", "Aceptar");
                }
                //  1/2/2020 | 2/2/2020 | 3/2/2020
                //1/1/2019
                
                
            }
            else
            {
                return;
            }
        }

        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }
    }
}