using Facturacion.DAO;
using Facturacion.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Facturacion.ViewModel {
    public class ArticleDetail_ViewModel {
        public Article Article { get; set; }
        private ArticleDAO articleDao = new ArticleDAO(Config.Database);
        internal void SaveArticle()
        {
            articleDao.Save(Article);
        }
        internal void DeleteArticle()
        {
            articleDao.Delete(Article);
        }
    }
}
