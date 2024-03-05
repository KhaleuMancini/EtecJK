<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">

    <title>Olá, mundo!</title>
    
  </head>
  <body>
    <main>
        <div class="escolhaPrinc">
            <h2>CADASTRAR</h2>
            <div class="botoes">
                <button class="btn" id="funcionario">FUNCIONARIO</button>
                <button class="btn" id="cliente">CLIENTE</button>
            </div>
        </div>

        <div class="cadClient">
            <form method="POST" id="formCliente">
                <h2>CADASTRO FUNCIONARIOS</h2>
                <div class="linhas">
                    <label>Nome: </label>
                    <input type="text" id="Nome" name="NomeC" >
                    <label>Data de Nascimento: </label>
                    <input type="date" name="DataNasc" id="Data">
                </div>
                <div class="linhas">
                    <label>Endereço: </label>
                    <input type="text" name="Endereco" id="End">
                </div>
                <div class="linhas">
                    <label>Tel: </label>
                    <input type="tel" name="Telefone" id="Tel">
                    <label>Email: </label>
                    <input type="text" name="Email" placeholder="Email" id="Email">
                </div>
                <div class="linhas">
                    <label>RG: </label>
                    <input type="text" name="RG" id="RG">
                    <label>CPF: </label>
                    <input type="text" name="CPF" id="CPF">
                </div>
                <div class="linhas">
                    <label>Telefone Celular: </label>
                    <input type="tel" name="TelC" id="TelC">
                    <label>Whatsapp: </label>
                    <input type="tel" name="Whats" id="Whats">
                    <label>Redes sociais: </label>
                    <input type="text" name="Redes" id="Redes">
                </div>
                <div class="linhas">
                    <br>
                    <input type="button" id="botao" class="btn subc" value="enviar" />
                </div>
            </form>
        </div>

        <div class="cadFuncionario">
            <form method="POST" id="formFuncionario">
                <h2>CADASTRO CLIENTES</h2>
                <div class="linhas">
                    <label>Nome: </label>
                    <input type="text" id="Nome" name="NomeC" >
                    <label>Data de Nascimento: </label>
                    <input type="date" name="DataNasc" id="Data">
                </div>
                <div class="linhas">
                    <label>Endereço: </label>
                    <input type="text" name="Endereco" id="End">
                </div>
                <div class="linhas">
                    <label>Tel: </label>
                    <input type="tel" name="Telefone" id="Tel">
                    <label>Email: </label>
                    <input type="text" name="Email" placeholder="Email" id="Email">
                </div>
                <div class="linhas">
                    <label>RG: </label>
                    <input type="text" name="RG" id="RG">
                    <label>CPF: </label>
                    <input type="text" name="CPF" id="CPF">
                </div>
            </form>
        </div>
    </main>
    
    <?php
        class Cliente{
            var $nome;
            var $DataNasc;
            var $End;
            var $Tel;
            var $Email;
            var $RG;
            var $CPF;
            var $TelC;
            var $Whats;
            var $Redes;

            function __construct($nome, $DataNasc, $End, $Tel, $Email, $RG, $CPF, $TelC, $Whats, $Redes){
                $this->nome=$nome;
                $this->DataNasc=$DataNasc;
                $this->End=$End;
                $this->Tel=$Tel;
                $this->Email=$Email;
                $this->RG=$RG;
                $this->CPF=$CPF;
                $this->TelC=$TelC;
                $this->Whats=$Whats;
                $this->Redes=$Redes;
            }
            function ExibirTudo(){
                echo "Nome: $this->nome \nData de Nascimento: $this->DataNasc \nEndereço: $this->End \nTelefone: $this->Tel \nEmail: $this->Email\n";
                echo "RG: $this->RG \nCPF: $this->CPF \nTelefone Celular: $this->TelC \nWhatsapp: $this->Whats \nRedes Sociais: $this->Redes";
            }
        }
        $nome = filter_input(INPUT_POST, 'NomeC');
        if($nome){
            $cliente1 = new Cliente(filter_input(INPUT_POST, 'NomeC'), filter_input(INPUT_POST, 'DataNasc'), filter_input(INPUT_POST, 'Endeco'), filter_input(INPUT_POST, 'Telefone'), filter_input(INPUT_POST, 'Email'), filter_input(INPUT_POST, 'RG'), filter_input(INPUT_POST, 'CPF'), filter_input(INPUT_POST, 'TelC'), filter_input(INPUT_POST, 'Whats'), filter_input(INPUT_POST, 'Redes'));
            $cliente1->ExibirTudo();
        }
    ?>




    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <script>
        $(document).ready(function(){
            $("#cliente").click(function(){
                $(".escolhaPrinc").hide();
                $(".cadClient").show();
            });
            $("#funcionario").click(function(){
                $(".escolhaPrinc").hide();
                $(".cadFuncionario").show();
            })
        });
      
        $(document).ready(function(){
            var tudo = [$("#Nome"), $("#End"), $("#Data"), $("#End"), $("#Tel"), $("#Email"), $("#RG"), $("#CPF"), $("#TelC"), $("#Whats"), $("#Redes")];
            var cont = 0;
            var submitad = 0;
            $("#formCliente").submit(function(){
                submitad += 1;
                alert("submitado")
            })
            $("#botao").click(function(){
                for(var i=0; i< tudo.length; i++){
                    if(tudo[i].val() == ""){
                        cont = 1;
                    }
                }
                if (cont == 1){
                    alert("insira todos os dados");
                    cont = 0;
                }
                else{
                    $("#formCliente").submit();
                }
            });
            if(submitad == 1){
                $(".escolhaPrinc").hide();
                submitad = 0;
            }
        });

    </script>

  </body>
</html>