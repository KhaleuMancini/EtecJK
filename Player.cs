using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Security.Permissions;
using System.Text;
using System.Threading.Tasks;

namespace testeTamagotchi
{
    public class Player()
    {
        public string nome;
        public string img;
        public string raca;
        public int vida;
        public int dinheiro;
        public int fome;
        public DateTime data;
        public void Cadastro(string nome, string img, string raca, int vida, int dinheiro, int fome)
        {
            this.nome = nome;
            this.img = img;
            this.raca = raca;
            this.vida = vida;
            this.dinheiro = dinheiro;
            this.fome = fome;
        }
        public void Exibir(Form1 form)
        {
            
            form.lb_nome.Text = nome;
            form.lb_vida.Text = "Vida: " + vida;
            form.lb_raca.Text = raca;
            form.pic_animal.Load(img);
            
        }
    }
}
