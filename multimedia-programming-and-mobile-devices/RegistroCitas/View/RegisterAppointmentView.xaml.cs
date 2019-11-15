using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using RegistroCitas.ViewModel;
using Rg.Plugins.Popup.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace RegistroCitas.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class RegisterAppointmentView : ContentPage {

        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        private AppointmentDAO appointmentDAO = new AppointmentDAO(Config.Database);
        private CompanyDAO companyDAO = new CompanyDAO(Config.Database);

        private string[] selections;
        
        public RegisterAppointmentView()
        {
            InitializeComponent();

            selections = new string[3];

            CompanyPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                CompanyPickerClicked();
            };
            SpecialtyPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                if(SpecialtyPicker.SelectedIndex != -1)
                {
                    SpecialtyPickerClicked();
                }
            };
            MedicPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                if (SpecialtyPicker.SelectedIndex != -1)
                {
                    MedicPickerClicked();
                }
            };
           
        }
        
        private void CompanyPickerClicked()
        {
            selections[0] = CompanyPicker.SelectedItem.ToString();
            SpecialtyPicker.SelectedIndex = -1;
            MedicPicker.SelectedIndex = -1;
            SpecialtyPicker.IsEnabled = true;
            MedicPicker.IsEnabled = false;
            CompanyPicker.Unfocus();
        }
        private void SpecialtyPickerClicked()
        {
            selections[1] = SpecialtyPicker.SelectedItem.ToString();
            MedicPicker.ItemsSource = medicDAO.getMedicNamesFiltered(selections[0], selections[1]);
            MedicPicker.IsEnabled = true;
            SpecialtyPicker.Unfocus();
        }
        private void MedicPickerClicked()
        {
            selections[2] = MedicPicker.SelectedItem.ToString();
            OKButton.IsEnabled = true;
            MedicPicker.Unfocus();
        }

        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }

        private async void OK_Clicked(object sender, EventArgs e)
        {
            try {
                appointmentDAO.insert(new Appointment(0, companyDAO.getIdByName(selections[0]), DateTime.Now.ToString("dd/MM/yyyy"), medicDAO.getIdByName(selections[2]), 1));
                await DisplayAlert("Info", "Cita Registrada", "Aceptar");
            } catch
            {
                await DisplayAlert("ERROR", "No se pudo registrar", "Aceptar");
            }
            
            await Navigation.PopAsync();
        }
    }
}