using FacturacionRestful.Model;
using FacturacionRestful.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace FacturacionRestful.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ClientDetail_View : ContentPage {
        public CrudEvents Events = new CrudEvents();
        public ClientDetail_View()
        {
            InitializeComponent();
        }

        private async void Save_Clicked(object sender, EventArgs e)
        {
            bool nou = true;
            if(((ClientDetail_ViewModel)BindingContext).Client.ID != 0)
            {
                nou = false;
            }
            ((ClientDetail_ViewModel)BindingContext).SaveClient();

            if(nou) {
                Events.OnAdd(((ClientDetail_ViewModel)BindingContext).Client);
            } else
            {
                Events.OnUpdate(((ClientDetail_ViewModel)BindingContext).Client);
            }
            await Navigation.PopAsync();
        }

        private async void Delete_Clicked(object sender, EventArgs e)
        {
            ((ClientDetail_ViewModel)BindingContext).DeleteClient();
            Events.OnDelete(((ClientDetail_ViewModel)BindingContext).Client);
            await Navigation.PopAsync();
        }
    }
}
