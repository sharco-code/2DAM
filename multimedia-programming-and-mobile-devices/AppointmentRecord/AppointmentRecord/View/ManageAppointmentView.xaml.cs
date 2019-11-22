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
        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        public ManageAppointmentView()
        {
            InitializeComponent();
            SetValue(NavigationPage.BarBackgroundColorProperty, Color.Black);
        }


        private async void Appointment_ItemTapped(object sender, ItemTappedEventArgs e)
        {
            var clickedObj = e.Item as Appointment;

            Medic m = medicDAO.getMedicById(clickedObj.IdMedic);

            bool mensaje = await DisplayAlert("Cita", "Médico: "+m.Name+" "+m.Surnames+"\nFecha: "+clickedObj.Date, "Borrar", "Volver");
            if(mensaje)
            {
                bool result = await DisplayAlert("Cita", "¿Borrar cita?", "Si", "Cancelar");
                if (result)
                {




                    //comprobacion de cuando se puede borrar
                    string[] datex = clickedObj.Date.Split(' ');
                    string[] date = datex[0].Split('/');
                    /*
                    String msg = "Dia:" + (Int32.Parse(DateTime.Now.Day.ToString()) - Int32.Parse(date[0]))+
                        "\nMes:"+(Int32.Parse(DateTime.Now.Month.ToString()) - Int32.Parse(date[1])+
                        "\nAño:"+ (Int32.Parse(DateTime.Now.Year.ToString()) - Int32.Parse(date[2])));
                    await DisplayAlert("DEBUG", msg, "Aceptar");
                    */
                    int calcDIA = (Int32.Parse(date[0]) - Int32.Parse(DateTime.Now.Day.ToString()));
                    int calcMES = (Int32.Parse(date[1]) - Int32.Parse(DateTime.Now.Month.ToString()));
                    int calcYEAR = (Int32.Parse(date[2]) - Int32.Parse(DateTime.Now.Year.ToString()));
                    //await DisplayAlert("DEBUG", "CalcDia:" + calcDIA + "\nRes:" + Config.CancelRestrictionDays + "\n", "Aceptar");
                    if (calcMES == 0 && calcYEAR == 0)
                    {
                        if (calcDIA <= Config.CancelRestrictionDays)
                        {
                            await DisplayAlert("info", "Solo se puede borrar con " + Config.CancelRestrictionDays + " dia/s de antelacion. ", "Aceptar");
                            return;
                        }
                    }
                    appointmentDAO.delete(clickedObj);
                    await DisplayAlert("Info", "Cita borrada", "Aceptar");
                    Navigation.PopAsync();
                    //  1/2/2020 | 2/2/2020 | 3/2/2020
                    //1/1/2019


                }
                else
                {
                    return;
                }
            }
           
        }

        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }
    }
}