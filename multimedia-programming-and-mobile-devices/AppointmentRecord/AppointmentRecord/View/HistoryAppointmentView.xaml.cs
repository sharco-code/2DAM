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
        public HistoryAppointmentView()
        {
            InitializeComponent();
        }

        private void Appointment_ItemTapped(object sender, ItemTappedEventArgs e)
        {

        }

        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }
    }
}