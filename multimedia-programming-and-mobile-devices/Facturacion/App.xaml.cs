using Facturacion.View;
using Facturacion.ViewModel;
using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Facturacion {
    public partial class App : Application {
        public App()
        {
            InitializeComponent();

            MainPage = new NavigationPage(new Menu_View
            {
                //BindingContext = new ClientList_ViewModel()
            });
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
