using FacturacionRestful.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace FacturacionRestful.DAO {
    public class ArticleDAO : DAOInterface<Article> {
        public void Delete(Article article)
        {
        }

        public ObservableCollection<Article> GetAll()
        {
            return null;
        }
        public void Save(Article article)
        {
        }
    }
}