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
    public partial class RegisterAppointmentView : ContentPage {

        public CrudEvents Events = new CrudEvents();
        public RegisterAppointmentView()
        {
            InitializeComponent();
            CompanyPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                CompanyPickerClicked();
            };
            SpecialtyPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                SpecialtyPickerClicked();
            };
        }
        
        private void CompanyPickerClicked()
        {
            SpecialtyPicker.IsEnabled = true;
            CompanyPicker.Unfocus();
        }
        private void SpecialtyPickerClicked()
        {
            //MedicPicker.ItemsSource = get medics
            MedicPicker.IsEnabled = true;
            SpecialtyPicker.Unfocus();
        }
        private void OK_Clicked(object sender, EventArgs e)
        {

        }

        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }
    }
}