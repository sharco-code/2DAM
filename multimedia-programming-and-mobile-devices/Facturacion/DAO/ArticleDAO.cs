using Facturacion.Model;
using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace Facturacion.DAO {
    public class ArticleDAO {
        private SQLiteAsyncConnection connection;
        public ArticleDAO(string dbpath)
        {
            connection = new SQLiteAsyncConnection(dbpath);
            connection.CreateTableAsync<Article>().Wait();
        }

        internal void Save(Article article)
        {
            if (article.ID != 0)
            {
                connection.UpdateAsync(article);
            }
            else
            {
                connection.InsertAsync(article);
            }
        }
        internal void Delete(Article Article)
        {
            connection.DeleteAsync(Article).Wait();
        }
        public ObservableCollection<Article> GetArticles()
        {
            var l = connection.Table<Article>().ToListAsync().Result;
            return new ObservableCollection<Article>(l);
        }
    }
}

