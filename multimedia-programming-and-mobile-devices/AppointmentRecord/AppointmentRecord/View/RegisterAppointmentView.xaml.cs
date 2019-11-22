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
    public partial class RegisterAppointmentView : ContentPage {

        private MedicDAO medicDAO = new MedicDAO(Config.Database);
        private AppointmentDAO appointmentDAO = new AppointmentDAO(Config.Database);
        private CompanyDAO companyDAO = new CompanyDAO(Config.Database);
        
        public RegisterAppointmentView()
        {
            InitializeComponent();
            SetValue(NavigationPage.BarBackgroundColorProperty, Color.Black);

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
 
            /*
            HourPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                if (HourPicker.SelectedIndex != -1)
                {
              
                    HourPickerClicked();
                }
            };
            MinutPicker.SelectedIndexChanged += (object sender, EventArgs e) =>
            {
                if (MinutPicker.SelectedIndex != -1)
                {

                    MinutPickerClicked();
                }
            };
            */
        }
        
        private void CompanyPickerClicked()
        {
            CompanyPicker.IsEnabled = false;
            SpecialtyPicker.IsEnabled = true;
            CompanyPicker.Unfocus();
        }
        private void SpecialtyPickerClicked()
        {
            MedicPicker.ItemsSource = medicDAO.getMedicNamesFiltered(CompanyPicker.SelectedItem.ToString(), SpecialtyPicker.SelectedItem.ToString());
            SpecialtyPicker.IsEnabled = false;
            MedicPicker.IsEnabled = true;
            SpecialtyPicker.Unfocus();
        }
        private void MedicPickerClicked()
        {
            MedicPicker.IsEnabled = false;
            DatePicker.IsEnabled = true;
            MedicPicker.Unfocus();
        }
        private void DatePickerClicked()
        {
            DatePicker.IsEnabled = false;
            //HourPicker.IsEnabled = true;
            //MinutPicker.IsEnabled = true;

            List<String> hours = new List<string>();
            hours.Add("9");
            hours.Add("10");
            hours.Add("11");
            hours.Add("12");
            hours.Add("13");
            //HourPicker.ItemsSource = hours;

            List<String> minuts = new List<string>();
            minuts.Add("00");
            minuts.Add("10");
            minuts.Add("20");
            minuts.Add("30");
            minuts.Add("40");
            minuts.Add("50");
            //MinutPicker.ItemsSource = minuts;

            MedicPicker.Unfocus();
        }
        private void HourPickerClicked()
        {
            //HourPicker.Unfocus();
        }
        private void MinutPickerClicked()
        {
            OKButton.IsEnabled = true;
            //MinutPicker.Unfocus();
        }
        private void CANCEL_Clicked(object sender, EventArgs e)
        {
            OKButton.IsEnabled = true;
            Navigation.PopAsync();
        }

        private async void OK_Clicked(object sender, EventArgs e)
        {
            try {
                //comprobaciones
                if(DatePicker.Date.Day.ToString() == DateTime.Now.Day.ToString()
                    && DatePicker.Date.Month.ToString() == DateTime.Now.Month.ToString()
                    && DatePicker.Date.Year.ToString() == DateTime.Now.Year.ToString()) {
                    await DisplayAlert("Info", "La cita tiene que ser a partir de mañana", "Aceptar");
                    return;
                }

                //              comrpobar si ya hay una cita a esa hora

                //lista con citas del MEDICO SELECCIONADO y el DIA SELECCIONADO
                IList < Appointment > list = appointmentDAO.GetAppointmentByMedicAndDate(medicDAO.getIdByName(MedicPicker.SelectedItem.ToString()), (DatePicker.Date.Day.ToString() + "/" + DatePicker.Date.Month.ToString() + "/" + DatePicker.Date.Year.ToString()));
                if ((list != null) || (list.Count != 0))
                {
                    //si entra es que este medico si tiene citas este dia
                    foreach(Appointment a in list)
                    {
                        string[] datex = a.Date.Split(' ');
                        string[] hour = datex[1].Split(':'); //hour[0] hora       || hour[1] minutos
                        //await DisplayAlert("Debug", "Hora de cita objtenida:"+ hour[0]+":"+ hour[1]+"\nHora seleccionada:"+HourPicker.SelectedItem.ToString()+":"+ MinutPicker.SelectedItem.ToString(), "OK");
                        if (hour[0] == HourPicker.SelectedItem.ToString()
                            && hour[1] == MinutPicker.SelectedItem.ToString())
                        {
                            await DisplayAlert("Info", "El medico tiene esa hora ocupada", "Aceptar");
                            return;
                        }
                    }
                }

                appointmentDAO.insert(new Appointment(0, companyDAO.getIdByName(CompanyPicker.SelectedItem.ToString()), (DatePicker.Date.Day.ToString()+"/"+ DatePicker.Date.Month.ToString()+ "/" + DatePicker.Date.Year.ToString() +" "+ HourPicker.SelectedItem.ToString()+":"+ MinutPicker.SelectedItem.ToString()), medicDAO.getIdByName(MedicPicker.SelectedItem.ToString()), 1));
                await DisplayAlert("Info", "Cita Registrada", "Aceptar");
            } catch
            {
                await DisplayAlert("ERROR", "No se pudo registrar", "Aceptar");
            }
            
            await Navigation.PopAsync();
        }

        private void REFRESH_Clicked(object sender, EventArgs e)
        {
            CompanyPicker.SelectedIndex = -1;
            CompanyPicker.IsEnabled = true;

            MinutPicker.SelectedIndex = -1;
            MinutPicker.IsEnabled = false;

            HourPicker.SelectedIndex = -1;
            HourPicker.IsEnabled = false;

            DatePicker.IsEnabled = false;

            MedicPicker.SelectedIndex = -1;
            MedicPicker.IsEnabled = false;

            SpecialtyPicker.SelectedIndex = -1;
            SpecialtyPicker.IsEnabled = false;
            
            OKButton.IsEnabled = false;
        }

        private void DatePickerSELECTED(object sender, DateChangedEventArgs e)
        {
            //TimePicker.IsEnabled = true;
            MinutPicker.IsEnabled = true;
            HourPicker.IsEnabled = true;

            OKButton.IsEnabled = true;
        }

        private void TimePickerSELECTED(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {

        }
    }
}