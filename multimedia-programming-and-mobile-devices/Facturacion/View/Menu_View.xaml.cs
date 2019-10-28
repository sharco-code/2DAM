using Facturacion.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Facturacion.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Menu_View : ContentPage {
        public Menu_View()
        {
            InitializeComponent();
        }


        private void ButtonClients_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new ClientList_View
            {
                BindingContext = new ClientList_ViewModel()
            });
        }

        private void ButtonArticles_Clicked(object sender, EventArgs e)
        { 
            Navigation.PushAsync(new ArticleList_View
            {
                BindingContext = new ArticleList_ViewModel()
            });
        }
    }
}