﻿using RegistroCitas.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace RegistroCitas.View {
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class RegisterView : ContentPage {
        public RegisterView()
        {
            InitializeComponent();
        }

        private void OK_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new MenuView());
        }
    }
}