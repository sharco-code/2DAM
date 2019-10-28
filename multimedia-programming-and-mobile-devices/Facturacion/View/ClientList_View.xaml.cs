using Facturacion.Model;
using Facturacion.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Facturacion.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ClientList_View : ContentPage {
        public ClientList_View() {
            InitializeComponent();
            MenuItem1.IconImageSource = "add.png";
        }


        private void ClientList_ItemTapped(object sender, ItemTappedEventArgs e) {
            var x = new ClientDetail_View
            {
                BindingContext = new ClientDetail_ViewModel
                {
                    Client = (Client)e.Item
                }
            } ;
            x.Events.DeleteHandler += DeleteClient;
            x.Events.UpdateHandler += UpdateClient;
            Navigation.PushAsync(x);
        }

        
        private void ToolbarItem_Clicked(object sender, EventArgs e) {

            var x = new ClientDetail_View
            {
                BindingContext = new ClientDetail_ViewModel
                {
                    Client = new Client()
                }
            };
            x.Events.AddHandler += SaveClient;
            Navigation.PushAsync(x);

        }
        private void SaveClient(object sender, MyEventArgs e)
        {
            ((ClientList_ViewModel)BindingContext).ClientList.Add((Client)e.MyObject);
        }
        private void UpdateClient(object sender, MyEventArgs e)
        {
            var list = new ObservableCollection<Client>();
            var pos = 0;
            foreach(Client item in ((ClientList_ViewModel)BindingContext).ClientList)
            {
                if(item.ID == ((Client)e.MyObject).ID)
                {
                    list.Add((Client)e.MyObject);
                    //((ClientList_ViewModel)BindingContext).ClientList.Add((Client)e.MyObject);
                } else
                {
                    list.Add(((ClientList_ViewModel)BindingContext).ClientList[pos]);
                }
                pos++;
            }
            ((ClientList_ViewModel)BindingContext).ClientList = list;
            ((ClientList_ViewModel)BindingContext).OnPropertyChanged("ClientList");
        }
        private void DeleteClient(object sender, MyEventArgs e)
        {
            ((ClientList_ViewModel)BindingContext).ClientList.Remove((Client)e.MyObject);
        }
    }
}
