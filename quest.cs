using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testeTamagotchi
{
    internal class quest
    {
        public string nome;
        public int valor;
        public bool veri;
        public int num;

        enum quests
        {
            GarimpoIlegal = 0,
            DestruiçãoDoMeioAmbiente,
            CausarUmaGuerra,
            sexo,
            drogas,
            joias,
            carros,
            potencia
        }
        public void gerador(todolist chamando)
        {
            Random rand = new Random();
            num = rand.Next(8);
            nome = ""+(quests)num;
            valor += rand.Next(10);
        }
        public void Verificacao(Form1 form)
        {
            switch(num)
            {
                case 0:
                    if (form.coelho == 1)
                    {
                        veri = true;
                        form.coelho = 0;
                        break;
                    }
                    else
                    {
                        veri = false;
                        break;
                    }
            }
            if(num != 0)
            {
                veri = true;
            }
            
        }

        public void criandoQuest(todolist lista, int seila)
        {
            File.Delete("C:/Users/khaleu/source/repos/WinFormsApp1/imgs/quests.txt");
            

            switch (seila) { 
                case 1:
                    lista.cb_quest1.Checked = false;
                    gerador(lista);
                    while (nome == lista.cb_quest2.Text | nome == lista.cb_quest3.Text)
                    {
                        gerador(lista);
                    }
                    lista.cb_quest1.Text = nome + " R$(" + valor + ")";
                    break;
                case 2:
                    lista.cb_quest2.Checked = false;
                    gerador(lista);
                    while (nome == lista.cb_quest1.Text | nome == lista.cb_quest3.Text)
                    {
                        gerador(lista);
                    }
                    lista.cb_quest2.Text = nome + " R$(" + valor + ")";
                    break;
                case 3:
                    lista.cb_quest3.Checked = false;
                    gerador(lista);
                    while (nome == lista.cb_quest2.Text | nome == lista.cb_quest1.Text)
                    {
                        gerador(lista);
                    }
                    lista.cb_quest3.Text = nome + " R$(" + valor + ")";
                    break;
            }
        }
    }
}
