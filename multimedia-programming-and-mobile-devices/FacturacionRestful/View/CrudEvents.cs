using System;

namespace FacturacionRestful.View
{
    
    public class CrudEvents
    {
        public EventHandler<MyEventArgs> DeleteHandler;
        public EventHandler<MyEventArgs> AddHandler;
        public EventHandler<MyEventArgs> UpdateHandler;
        public void OnDelete(Object o)
        {
            if (DeleteHandler != null)
            {
                var arti = new MyEventArgs();
                arti.MyObject = o;
                DeleteHandler(this, arti);
            }
        }
        public void OnAdd(Object o)
        {
            if (AddHandler != null)
            {
                var arti = new MyEventArgs();
                arti.MyObject = o;
                AddHandler(this, arti);
            }
        }
        public void OnUpdate(Object o)
        {
            if (UpdateHandler != null)
            {
                var arti = new MyEventArgs();
                arti.MyObject = o;
                UpdateHandler(this, arti);
            }
        }
    }
}
