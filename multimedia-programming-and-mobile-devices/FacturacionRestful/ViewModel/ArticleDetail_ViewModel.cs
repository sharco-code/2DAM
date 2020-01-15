
using FacturacionRestful.Model;
using FacturacionRestful.DAO;
using System;
using System.Collections.Generic;
using System.Text;

namespace FacturacionRestful.ViewModel {
    public class ArticleDetail_ViewModel {
        public Article Article { get; set; }

        private ArticleDAO articleDAO = new ArticleDAO();
        internal void SaveArticle()
        {
            articleDAO.Save(Article);
        }
        internal void DeleteArticle()
        {
            articleDAO.Delete(Article);
        }
    }
}
