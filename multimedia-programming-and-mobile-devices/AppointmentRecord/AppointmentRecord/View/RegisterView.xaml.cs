using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using RegistroCitas.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace RegistroCitas.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class RegisterView : ContentPage {
        private PatientDAO patientDAO;
        public RegisterView()
        {
            InitializeComponent();
            SetValue(NavigationPage.BarBackgroundColorProperty, Color.Black);
            patientDAO = new PatientDAO(Config.Database);
        }

        private async void OK_Clicked(object sender, EventArgs e)
        {
            Patient p = new Patient(1, EntryDNI.Text, EntryName.Text, EntrySurnames.Text, EntryAdress.Text, EntryEmail.Text);
            try
            {
                patientDAO.insert(p);
                await DisplayAlert("Info", "Registrado Satisfactoriamente!", "Aceptar");
            }
            catch
            {
                await DisplayAlert("ERROR", "No se pudo registrar", "Aceptar");
            }

            await Navigation.PushAsync(new MenuView());
        }
    }
}