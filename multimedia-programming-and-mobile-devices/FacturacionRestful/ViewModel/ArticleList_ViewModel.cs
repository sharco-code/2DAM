using FacturacionRestful.DAO;
using FacturacionRestful.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace FacturacionRestful.ViewModel {
    class ArticleList_ViewModel : ViewModelBase {
        public ObservableCollection<Article> ArticleList { get; set; }

        private ArticleDAO articleDAO = new ArticleDAO();
        public ArticleList_ViewModel()
        {

            ArticleList = articleDAO.GetAll();

        }
    }
}
