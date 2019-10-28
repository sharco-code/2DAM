using Facturacion.DAO;
using Facturacion.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace Facturacion.ViewModel {
    class ArticleList_ViewModel : ViewModelBase {
        public ObservableCollection<Article> ArticleList { get; set; }

        private ArticleDAO articleDAO = new ArticleDAO(Config.Database);
        public ArticleList_ViewModel()
        {

            ArticleList = articleDAO.GetArticles();

        }
    }
}
