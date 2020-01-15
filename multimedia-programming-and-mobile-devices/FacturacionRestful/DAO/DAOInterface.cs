using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace FacturacionRestful.DAO {
    interface DAOInterface<T> {
        void Save(T t);
        void Delete(T t);
        ObservableCollection<T> GetAll();
    }
}
