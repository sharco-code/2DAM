using RegistroCitas.config;
using RegistroCitas.DAO;
using RegistroCitas.Model;
using RegistroCitas.View;
using SQLite;
using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace RegistroCitas {
    public partial class App : Application {
        private SQLiteAsyncConnection connection;
        private PatientDAO patientDAO;
        public App()
        {
            InitializeComponent();

            //Crear las tablas de base de datos a partir de los modelos
            connection = new SQLiteAsyncConnection(Config.Database);
            connection.CreateTableAsync<Appointment>().Wait();
            connection.CreateTableAsync<Medic>().Wait();
            connection.CreateTableAsync<MedicPertain>().Wait();
            connection.CreateTableAsync<Company>().Wait();
            connection.CreateTableAsync<Specialty>().Wait();
            connection.CreateTableAsync<Patient>().Wait();

            patientDAO = new PatientDAO(Config.Database);

            if(patientDAO.hasPatient())
            {
                MainPage = new NavigationPage(new MenuView());
            } else
            {
                MainPage = new NavigationPage(new RegisterView());
            }
           
        }

        protected override void OnStart()
        {
            // Handle when your app starts
        }

        protected override void OnSleep()
        {
            // Handle when your app sleeps
        }

        protected override void OnResume()
        {
            // Handle when your app resumes
        }
    }
}
