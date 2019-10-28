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
    public partial class ArticleDetail_View : ContentPage {
        public CrudEvents Events = new CrudEvents();
        public ArticleDetail_View()
        {
            InitializeComponent();
        }

        private async void Save_Clicked(object sender, EventArgs e)
        {
            bool nou = true;
            if (((ArticleDetail_ViewModel)BindingContext).Article.ID != 0)
            {
                nou = false;
            }
            ((ArticleDetail_ViewModel)BindingContext).SaveArticle();

            if (nou)
            {
                Events.OnAdd(((ArticleDetail_ViewModel)BindingContext).Article);
            }
            else
            {
                Events.OnUpdate(((ArticleDetail_ViewModel)BindingContext).Article);
            }
            await Navigation.PopAsync();
            /*
            ((ArticleDetail_ViewModel)BindingContext).SaveArticle();
            if (SaveArticleHandler != null)
            {
                var x = new ArticleEventArgs();
                x.Article = ((ArticleDetail_ViewModel)BindingContext).Article;
                SaveArticleHandler(this, x);
            }
            await Navigation.PopAsync();
            */
        }

        private async void Delete_Clicked(object sender, EventArgs e)
        {
            ((ArticleDetail_ViewModel)BindingContext).DeleteArticle();
            Events.OnDelete(((ArticleDetail_ViewModel)BindingContext).Article);
            await Navigation.PopAsync();
            /*
            ((ArticleDetail_ViewModel)BindingContext).DeleteArticle();
            if (DeleteArticleHandler != null)
            {
                var x = new ArticleEventArgs();
                x.Article = ((ArticleDetail_ViewModel)BindingContext).Article;
                DeleteArticleHandler(this, x);
            }
            await Navigation.PopAsync();
            */
        }
    }
}

