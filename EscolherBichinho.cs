using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace testeTamagotchi
{
    public partial class EscolherBichinho : Form
    {
        public EscolherBichinho()
        {
            InitializeComponent();
        }
        int teste = -1;
        enum Raca
        {
            Ovelha = 0,
            Gato,
            Cachorro
        }
        string[] listaImgs = new string[3] { "C:/Users/khaleu/source/repos/WinFormsApp1/imgs/ovelha.jpeg", "C:/Users/khaleu/source/repos/WinFormsApp1/imgs/gato.JPG", "C:/Users/khaleu/source/repos/WinFormsApp1/imgs/cachorro.PNG" };

        private void btn_proximo_Click(object sender, EventArgs e)
        {
            if (teste < 2)
            {
                teste += 1;
            }
            else
            {
                teste = 0;
            };
            pic_bichinhos.Load(listaImgs[teste]);
        }

        private void btn_anterior_Click(object sender, EventArgs e)
        {
            if (teste > 0)
            {
                teste -= 1;
            }
            else
            {
                teste = 2;
            }
            pic_bichinhos.Load(listaImgs[teste]);
        }

        private void btn_start_Click(object sender, EventArgs e)
        {
            if (teste != -1)
            {
                DateTime data_criada = DateTime.Now;
                StreamWriter Salva = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
                Salva.WriteLine(tb_nome.Text);
                Salva.WriteLine(listaImgs[teste]);
                Salva.WriteLine((Raca)teste);
                Salva.WriteLine(500);
                Salva.WriteLine(0);
                Salva.WriteLine(500);
                Salva.WriteLine(data_criada);
                Salva.Close();
                StreamWriter Quests = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
                Quests.WriteLine("Clique aqui para ativar sua primeira tarefa");
                Quests.WriteLine("Clique aqui para ativar sua segunda tarefa");
                Quests.WriteLine("Clique aqui para ativar sua terceira tarefa");
                for (int i = 0; i < 7; i++)
                {
                    Quests.WriteLine(0);
                }
                Quests.Close();
                this.Close();
            }
        }
    }
}
