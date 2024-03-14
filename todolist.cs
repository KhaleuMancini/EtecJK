using System;
using System.Collections;
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
    public partial class todolist : Form
    {
        
        quest missao = new quest();
        quest missao2 = new quest();
        quest missao3 = new quest();
        Form1 telaPrincipal;
        public int dinheiro;
        public todolist(Form1 form)
        {   
            this.telaPrincipal = form;
            InitializeComponent();
            dinheiro = int.Parse(telaPrincipal.lb_dinheiro.Text);
            if (form.primeiravez == 0)
            {
                StreamReader lendo = new StreamReader("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
                string[] questSalva = new string[9];
                for (int i = 0; i < 9; i++)
                {
                    questSalva[i] = lendo.ReadLine();
                }
                lendo.Close();
                cb_quest1.Text = questSalva[0];
                cb_quest2.Text = questSalva[1];
                cb_quest3.Text = questSalva[2];
                missao.valor = int.Parse(questSalva[3]);
                missao2.valor = int.Parse(questSalva[4]);
                missao3.valor = int.Parse(questSalva[5]);
                missao.num = int.Parse(questSalva[6]);
                missao2.num = int.Parse(questSalva[7]);
                missao3.num = int.Parse(questSalva[8]);
            }
            else
            {
                
            }
           
        }

        private void cb_quest1_Click(object sender, EventArgs e)
        {
            missao.Verificacao(telaPrincipal);
            if (missao.veri == true) {
                dinheiro += missao.valor;
                string din = dinheiro.ToString();
                lb_dinheiro.Text = din;
                Thread.Sleep(200);
                missao.criandoQuest(this, 1);
                StreamWriter escrever = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
                escrever.WriteLine(cb_quest1.Text +"\r\n"+ cb_quest2.Text+"\r\n" + cb_quest3.Text);
                escrever.WriteLine(missao.valor + "\r\n" + missao2.valor + "\r\n" + missao3.valor);
                escrever.WriteLine(missao.num + "\r\n" + missao2.num+ "\r\n" + missao3.num);
                escrever.Close();
            }
            else
            {
                MessageBox.Show("ERRADO");
            }
        }

        private void cb_quest2_Click(object sender, EventArgs e)
        {
            dinheiro += missao2.valor;
            string din = dinheiro.ToString();
            lb_dinheiro.Text = din;
            Thread.Sleep(200);
            missao2.criandoQuest(this, 2);
            StreamWriter escrever = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
            escrever.WriteLine(cb_quest1.Text + "\r\n" + cb_quest2.Text + "\r\n" + cb_quest3.Text);
            escrever.WriteLine(missao.valor + "\r\n" + missao2.valor + "\r\n" + missao3.valor);
            escrever.WriteLine(missao.num + "\r\n" + missao2.num + "\r\n" + missao3.num);
            escrever.Close();
        }

        private void cb_quest3_Click(object sender, EventArgs e)
        {
            dinheiro += missao3.valor;
            string din = dinheiro.ToString();
            lb_dinheiro.Text = din;
            Thread.Sleep(200);
            missao3.criandoQuest(this, 3);
            StreamWriter escrever = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
            escrever.WriteLine(cb_quest1.Text + "\r\n" + cb_quest2.Text + "\r\n" + cb_quest3.Text);
            escrever.WriteLine(missao.valor + "\r\n" + missao2.valor + "\r\n" + missao3.valor);
            escrever.WriteLine(missao.num + "\r\n" + missao2.num + "\r\n" + missao3.num);
            escrever.Close();
        }

        public void btn_salvar_Click(object sender, EventArgs e)
        {
            StreamReader ler = new StreamReader("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            string[] inf = new string[5];
            for (int i = 0; i < 5; i++)
            {
                inf[i] = ler.ReadLine();
            }
            ler.Close();
            StreamWriter escrever = new StreamWriter("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            for (int i = 0;i<4 ; i++)
            {
                escrever.WriteLine(inf[i]);
            }
            escrever.WriteLine(dinheiro);
            escrever.Close();
            telaPrincipal.lb_dinheiro.Text = (dinheiro).ToString();
            this.Close();
        }
    }
}
