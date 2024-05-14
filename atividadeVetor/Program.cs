using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace atividadeVetor
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
            int nmrPrioridade = 0;
            string op = "0";
            Cliente[] clientes = new Cliente[10];
            while (true)
            {
                Console.WriteLine("Deseja cadastrar um novo cliente [1]\nDeseja atender um cliente [2]\nListar clientes na fila [3]\n Para fechar [q]");
                op = Console.ReadLine();
                switch (op)
                {
                    case "1":
                       if (i < 10)
                        {
                            string nome;
                            string prioritario;
                            bool bool_priori = false;
                            Cliente cliente;
                            Console.WriteLine("Digite o nome do cliente");
                            nome = Console.ReadLine();
                            Console.WriteLine("É prioritario? [S/N]");
                            prioritario = Console.ReadLine().ToUpper();
                            if (prioritario == "S")
                            {
                                nmrPrioridade++;
                                bool_priori = true;
                                cliente = new Cliente(nome, bool_priori);
                                for(int c = 10; c > nmrPrioridade; c++)
                                {
                                    
                                }

                            }
                            else if (prioritario == "N")
                            {
                                bool_priori = false;
                            }
                            cliente = new Cliente(nome, bool_priori);
                            clientes[i] = (cliente);
                            i++;
                        }
                        else
                        {
                            Console.WriteLine("A fila ta lotada");
                        }
                        break;

                    case "2":
                        for(int c = 0; c < 10; c++) { 
                            clientes[c] = clientes[c+1];
                        }
                        i--;
                        Console.WriteLine("Cliente atendido com sucesso");
                        break;

                    case "3":
                        for (int c = 0; c < 10; c++)
                        {
                            Console.WriteLine(clientes[c].nome);
                        }
                        break;
                    case "q":
                        break;
                }
                
            }
        }
    }
}
