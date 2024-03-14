using System.Security.Cryptography.X509Certificates;
using System.Windows.Forms;

namespace testeTamagotchi
{
    public partial class Form1 : Form
    {
        string linha;
        public int salvo = 0;
        public int coelho = 0;
        public int primeiravez = 0;
        DateTime dataAgora = DateTime.Now;
        public Form1()
        {
            EscolherBichinho escolherBichinho = new EscolherBichinho();
            InitializeComponent();
            while (true)
            {
                StreamReader lendo = new StreamReader("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
                linha = lendo.ReadLine();
                lendo.Close();
                if (linha == null)
                {
                    escolherBichinho.ShowDialog();
                }
                else
                {
                    tFive.Enabled = true;
                    break;
                }
            }
            salvando();
        }
        Player player1;
        public void salvando()
        {
            StreamReader ler = new StreamReader("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            Player player = new Player();
            string[] inf = new string[6];

            for (int i = 0; i < inf.Length; i++)
            {
                inf[i] = ler.ReadLine(); ;
            }
            ler.Close();
            player.Cadastro(inf[0], inf[1], inf[2], int.Parse(inf[3]), int.Parse(inf[4]), int.Parse(inf[5]));
            player.Exibir(this);
            player1 = player;
            lb_dinheiro.Text = inf[4];
            lb_fome.Text = inf[5];
        }
        private void reset_Click(object sender, EventArgs e)
        {
            File.Delete("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            File.Create("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            this.Close();
        }
        public void morreu(Form form)
        {
            MessageBox.Show("Voce deixou seu bicho morrer");
            File.Delete("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            File.Create("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/salvando.txt");
            form.Close();
        }

        private void btn_todolist_Click(object sender, EventArgs e)
        {
            todolist todo = new todolist(this);
            todo.Show();
        }

        private void btn_coelho_Click(object sender, EventArgs e)
        {
            coelho += 1;
        }

        private void tFive_Tick(object sender, EventArgs e)
        {
            player1.fome--;
            lb_fome.Text = (player1.fome).ToString();
            if (player1.fome == 0)
            {
                morreu(this);
            }
        }
    }
}
