import java.io.*;
import java.util.*; 
import java.util.Scanner;
public class Tudo{
	
	//função de ler apenas numeros inteiros
        public int leiaInt(String n1){
                int veri = 0;
                for (int i = 0; i<n1.length();i++){
                        char ltr = n1.charAt(i);
                        if(Character.isDigit(ltr)){
                                veri ++;
                        }
                }
                if(veri == n1.length()){
                        int num = Integer.parseInt(n1);
                        return num;
                }
                else{
                        return -1;
                }
        }
 
	//funçãoa primeira questão
	public void primeiro(int n1, int n2, int n3, int n4){
		int[] nums = new int[]{n1,n2,n3,n4}; 
		int ma = 0;
		int me = n1;
		int reserva;	
		for(int i =0; i<4; i++){
			if (nums[i]> ma){
				ma = nums[i]; 
			}
			if (nums[i] < me){
				me = nums[i];  
			} 
		}
		while(ma != nums[0] || me != nums[3]){
			int c = 0;
			for (int i = 0; i <nums.length; i++){
				if(nums[i] < nums[i+1]){
					reserva = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = reserva;
				}
				if (i == 2){
					break;
				}	
			}
		}
		
		System.out.println("\nSequencia em ordem decrescente \n"); 
		for(int i = 0; i<4;i++){
			System.out.println(nums[i]);
		}					
	}




	//programa principal 
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		Random gerar = new Random(); 
		Tudo atividades = new Tudo();
		int opc;			
		System.out.println("Qual Atividade deseja ver?");
		while(true){
			System.out.println("\n\n1 - Ordenar Numeros\n2 - Achar codigo\n3 - Reajuste Salarial\n4 - Media entre numeros\n5 - Registro de Pessoas\n6 - Temperatura\n7 - Mercado\n8 - Nota Alunos\n9 - Registro Candidatos");
			opc = ler.nextInt();
		
			switch(opc){
				case 1: //Questão  - Codigo para mandar para metodo 1 
					System.out.println("Digite os 4 numeros: ");
					int dig = 0;
					int[] nums = new int[4];  
					for (int i=0; i < 4; i++){ 
						String n2 = ler.next();
						int n1 = atividades.leiaInt(n2);
						if(n1 == -1){
							System.out.println("Digite um numero positivo e nao uma letra ou numero negativo"); 
							dig=1; 
							break;	
						} 
						for( int c=0; c <nums.length; c++){
							if (n1 == nums[c] || n1<0){
								System.out.println("Digite numeros distintos e positivos");
								dig =1; 
								break;
							} 
						}
						if (dig==1){
							break; 
						} 
						else{
							nums[i]=n1;
						} 
					} 
					if(dig==1){
						break;
					} 
					atividades.primeiro(nums[0],nums[1],nums[2],nums[3]);
					break; 
				case 2: //Questão 2
					ArrayList<Integer> vetorCod = new ArrayList<Integer>();
					while(true){
						System.out.println("\nDigite o numero a ser adicionado no vetor"); 
						String n2 = ler.next(); 
						int n1 = atividades.leiaInt(n2);
						if(n1 == -1){
							System.out.println("Só são aceitos numeros");
							break;
						}
						vetorCod.add(n1);
						String conti = "s"; 
						while(true){
							System.out.println("\nDeseja continuar a colocar numeros?[S/N]");
	        				      	conti = ler.next().toLowerCase();
							if(conti.equals("s") || conti.equals("n")){
								break;
							} 
						}
						if (conti.equals("n")){
							break;
						} 
					}
					System.out.println("\nDigite qual numero deseja procurar");
					String procurarPor = ler.next();	
					int procurando = atividades.leiaInt(procurarPor);
                                        while(procurando == -1){
                                        	System.out.println("Só são aceitos numeros");
						procurarPor = ler.next();
                                        	procurando = atividades.leiaInt(procurarPor);
                                        }
					int achou = 0;		
					for(int i = 0; i<vetorCod.size();i++){
						if(vetorCod.get(i) == procurando){
							System.out.println("\nO numero " + procurando + " foi adicionado como " + (i+1) + " numero\n");
							achou =1; 
							break;
						}
					}
					if(achou == 0){
						System.out.println("Esse codigo nao nao foi encontrado"); 
					}    
					break;
					
				case 3:
					ArrayList<Double> salario = new ArrayList<Double>();
					ArrayList<Integer> codFunc = new ArrayList<Integer>();
					ArrayList<Double> novoSalario = new ArrayList<Double>();
					while(true){
						System.out.println("Digite o codigo do funcionario"); 
						String codFuncionario = ler.next();
						int codIntFuncionario = atividades.leiaInt(codFuncionario);
						if (codIntFuncionario == -1){
							System.out.println("Invalido");
							break;
						}
						else if (codIntFuncionario == 999){
							break;
						}
 
						codFunc.add(atividades.leiaInt(codFuncionario));
						System.out.println("\nDigite o salario do funcionario"); 
 						double sal = ler.nextDouble();
						salario.add(sal); 
					}
					for (double i : salario){
						if (i < 500){
							novoSalario.add((i*115/100));
						}
						else if(i >=500 && i<=1000){
							novoSalario.add((i*110/100));
						}
						else{
							novoSalario.add((i*105/100));
						}	
					}
					for(int i=0; i<codFunc.size();i++){
						System.out.println("O funcionario " + codFunc.get(i) + " agora recebe " + novoSalario.get(i));
					}
					break;

				case 4: 
					ArrayList<Integer> valores = new ArrayList<Integer>();
                                        String n2;
                                        int n1;
					int media=0;
					String conti;
					int passou = 0; 
					while(true){ 
						while(true){ 
							System.out.println("Digite um número positivo");
							n2 = ler.next();
							n1 = atividades.leiaInt(n2);
							if(n1 <= -1){
								System.out.println("Deve digitar um numero inteiro positivo");
							}
							else{
								break;
							}
						}
						valores.add(n1);
						media += n1;
						while(true){ 
							System.out.println("Deseja adicionar outro numero? [S/N]");
							conti = ler.next().toLowerCase();
							if (conti.equals("s") || conti.equals("n")){
								break;
							}
						}
						if(conti.equals("n")){
							break;
						}
					} 
					media = media / valores.size();
					System.out.println("A media e " + media); 
					for(int i : valores){
						if(i > media){
							System.out.println("O numero " + i + " ultrapassa a media");
							passou =1; 
						}
					}
					if(passou == 0){
						System.out.println("Nenhum numero e acima da media"); 
					}
					break;

				case 5:
					ArrayList<String> nomes = new ArrayList<String>();
					ArrayList<Integer> idades = new ArrayList<Integer>();
					int idade = -1;
					int mediaIdades = 0;
					int primeiraP; 
					while(true){
						System.out.println("Qual o nome da pessoa?");
						String nome = ler.next(); 
						while(idade==-1){
							System.out.println("Qual a idade?"); 
							String idadeVeri = ler.next();
							idade = atividades.leiaInt(idadeVeri);
						}
						nomes.add(nome); 
						idades.add(idade); 
						mediaIdades += idade;
						while(true){
                                                        System.out.println("Deseja adicionar outro numero? [S/N]");
                                                        conti = ler.next().toLowerCase();
                                                        if (conti.equals("s") || conti.equals("n")){
                                                                break;
                                                        }
                                                }
                                                if(conti.equals("n")){
                                                        break;
                                                }
						idade = -1; 
					}
					mediaIdades = mediaIdades / idades.size();
					primeiraP=idades.get(0); 
					for(int i = 0; i<idades.size();i++){
						if (idades.get(i) > primeiraP){
							System.out.println(nomes.get(i) + " e mais velho que " + nomes.get(0));
						} 
						if (idades.get(i) > mediaIdades){
							System.out.println(nomes.get(i) + " mais velho que a media (" + mediaIdades + ")");
						}
						if (idades.get(i) >= 18){
							System.out.println(nomes.get(i) + " maior de idade");
						}
						else{
							System.out.println(nomes.get(i) + " menor de idade");
						}
					}
					break; 
			
				case 6:
					int temp;
					int menorTemp=41;
					int maiorTemp=0;
					int somaTemp = 0;
					int menorMedia = 0; 
					int[] temperaturas = new int[121];
					for (int i = 0; i<temperaturas.length; i++){
						while (true){
							temp = gerar.nextInt(41);
							if (temp >=15){
								break;
							}
						} 
						if (menorTemp>temp){
							menorTemp = temp;
						}
						if (maiorTemp<temp){
							maiorTemp = temp;
						}
						somaTemp += temp; 
						temperaturas[i] = temp;
					}
					somaTemp = somaTemp / temperaturas.length;
					for (int i = 0; i<temperaturas.length; i++){
						if(temperaturas[i] < somaTemp){
							menorMedia ++;
						}
					}
					System.out.println("A menor temperatura foi " + menorTemp);
					System.out.println("A maior temperatura foi " + maiorTemp);
					System.out.println("A temperatura media foi " + somaTemp);
					System.out.println("A temperatura foi menor que a media em " + menorMedia + " dias");
					break; 
		
				case 7:
					int[] mercadorias = new int[3];
					int[] estoque = new int[3];
					double[] preco = new double[3];  
				
					int[] vendidas = new int[3];
					double faturamento = 0; 
					for (int i = 0; i<mercadorias.length;i++){
						mercadorias[i]= (i);
						System.out.println("Insira o valor da mercadoria " + (mercadorias[i]+1)); 
						preco[i] = ler.nextDouble();
						System.out.println("\nInsira quanto tem no estoque da mercadoria " + (mercadorias[i]+1));
						estoque[i] = ler.nextInt();  
					}
					for (int i = 0; i<mercadorias.length;i++){
						if (estoque[i] == 0){
							vendidas[i]=0;	
						}
						else{
							System.out.println("Quantidade vendida da mercadoria " + (mercadorias[i]+1));
							vendidas[i] = ler.nextInt();
							if(vendidas[i] > estoque[i]){
								System.out.println("\n\nQuantidade vendida maior que a que havia no estoque, vai ser arredondada para a quantia que existe no estoque\n\n");
								vendidas[i] = estoque[i];	
							} 
						}
					}
					for(int i = 0; i<vendidas.length; i++){
						faturamento = faturamento + vendidas[i]*preco[i];
					}
					System.out.println("O faturamento foi de " + faturamento); 
					break;
				
				case 8:
					int numAlunos; 
					int numProvas;	
					while(true){
						System.out.println("Quantos alunos tem na turma? (maximo de 80)");	
						numAlunos = ler.nextInt();
						if (numAlunos <= 80){ 
							break;
						}
					}
					while(true){
						System.out.println("Quantas provas foram dadas? (maximo de 4)");
						numProvas = ler.nextInt();
						if (numProvas <=4){
							break;
						}
					}
                                        String[] nomesAlunos = new String[numAlunos]; 
					double[] medias = new double[numAlunos]; 
					for (int i = 0; i<nomesAlunos.length; i++){ 
						medias[i] = 0;	
						System.out.println("Fale o nome do aluno " + i);
						nomesAlunos[i]= ler.next(); 
						for (int n = 0; n<numProvas; n++){
							System.out.println("Fale a " + n + " nota do aluno " + nomesAlunos[i]);
							medias[i] += ler.nextDouble();
						}
						medias[i] = medias[i]/numProvas; 
					}
					for(int i= 0; i<numAlunos; i++){
						System.out.println("A media do aluno " + nomesAlunos[i] + " foi " + medias[i]);
					}
					break;
				
				case 9: 
					int numInscricao = 0;
					int idadeGeral;
					String sexo;
					int numHomens =0;
					int numMulheres =0;
					int mediaIdadeH = 0;
					int numHomensServi = 0;
					String experiencia;	
					int percentual = 0;
					int maisNova = 9999;
					String querConti; 
					while(numInscricao !=200){
						numInscricao +=1;
						System.out.println("Qual a idade do candidato " + numInscricao);
						idadeGeral = ler.nextInt();
						while (true){ 
							System.out.println("\nQual o seu genero? [M/F]");
							sexo = ler.next().toLowerCase();
							if(sexo.equals("m") || sexo.equals("f")){
								break;
							}
						} 
						while(true){
							System.out.println("\nTem experiencia? [S/N]");
							experiencia = ler.next().toLowerCase();
							if(experiencia.equals("s") || experiencia.equals("n")){
								break;
							}
						} 
						if (sexo.equals("m")){
							numHomens +=1;
							if (experiencia.equals("s")){
								numHomensServi +=1;	
								mediaIdadeH += idadeGeral;
								if (idadeGeral <35){
									percentual++;
								}
							}
							else{
								if(idadeGeral > 45){
									percentual++;
								}
							}
						}
						else{
							numMulheres +=1;
							if(experiencia.equals("s")){
								if(maisNova>idadeGeral){
									maisNova = idadeGeral;
								}
							}
						}
						System.out.println("Quer continuar ?");
						querConti = ler.next();
						if(querConti.equals("n")){
							break;
						} 
					}
					mediaIdadeH = mediaIdadeH /numHomensServi; 
					percentual = percentual*100/numHomens;	
					System.out.println("O numero de candidatos homens foi " + numHomens + "\nO numero de candidatas mulheres foi " + numMulheres);
					System.out.println("A idade media de homens com experiencia foi " + mediaIdadeH);
					System.out.println("O percentual de homens com mais de 35 anos experiencia no servico ou de homens com mais de 45 anos foi " +percentual);
					System.out.println("A idade da mulher mais nova com experiencia no servico foi " + maisNova);
					break;
		
				case 0:  
					System.exit(0); 
			}
		}	
	}
} 
