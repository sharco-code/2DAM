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
    public partial class MenuView : ContentPage {
        public MenuView()
        {
            InitializeComponent();
        }

        private void REGISTER_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new RegisterAppointmentView
            {
                BindingContext = new RegisterAppointmentViewModel()
            });

        }

        private void MANAGE_Clicked(object sender, EventArgs e)
        {

        }
    }
}