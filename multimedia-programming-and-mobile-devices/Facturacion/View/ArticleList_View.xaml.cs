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
    public partial class ArticleList_View : ContentPage {
        public ArticleList_View()
        {
            InitializeComponent();
            //MenuItem1.IconImageSource = "add.png";
        }

        private void ArticleList_ItemTapped(object sender, ItemTappedEventArgs e)
        {
            var x = new ArticleDetail_View
            {
                BindingContext = new ArticleDetail_ViewModel
                {
                    Article = (Article)e.Item
                }
            };
            x.Events.DeleteHandler += DeleteArticle;
            x.Events.UpdateHandler += UpdateArticle;
            Navigation.PushAsync(x);
        }


        private void ToolbarItem_Clicked(object sender, EventArgs e)
        {

            var x = new ArticleDetail_View
            {
                BindingContext = new ArticleDetail_ViewModel
                {
                    Article = new Article()
                }
            };
            x.Events.AddHandler += SaveArticle;
            Navigation.PushAsync(x);

        }
        private void SaveArticle(object sender, MyEventArgs e)
        {
            ((ArticleList_ViewModel)BindingContext).ArticleList.Add((Article)e.MyObject);
            //((ArticleList_ViewModel)BindingContext).ArticleList.Add(e.Article);
        }

        private void UpdateArticle(object sender, MyEventArgs e)
        {
            var list = new ObservableCollection<Article>();
            var pos = 0;
            foreach (Article item in ((ArticleList_ViewModel)BindingContext).ArticleList)
            {
                if (item.ID == ((Article)e.MyObject).ID)
                {
                    list.Add((Article)e.MyObject);
                    //((ClientList_ViewModel)BindingContext).ClientList.Add((Client)e.MyObject);
                }
                else
                {
                    list.Add(((ArticleList_ViewModel)BindingContext).ArticleList[pos]);
                }
                pos++;
            }
            ((ArticleList_ViewModel)BindingContext).ArticleList = list;
            ((ArticleList_ViewModel)BindingContext).OnPropertyChanged("ArticleList");
        }

        private void DeleteArticle(object sender, MyEventArgs e)
        {
            ((ArticleList_ViewModel)BindingContext).ArticleList.Remove((Article)e.MyObject);
        }
    }
}