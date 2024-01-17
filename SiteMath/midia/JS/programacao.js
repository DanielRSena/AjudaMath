
//Coleta de dados por ID
document.getElementById(var_a.value);
document.getElementById(var_b.value);
document.getElementById(var_c.value);
document.getElementById(igualdade.value);
document.getElementById(nx_1.value);
document.getElementById(ny_1.value);
document.getElementById(n_1.value);
document.getElementById(nx_2.value);
document.getElementById(ny_2.value);
document.getElementById(n_2.value);


//1. Funções para o funcionamento do site

//Barra de menu
function navega() {
    navegador.innerHTML += "<header> <nav><div id='logo'><a href='index.html' id='logo'> <img src='midia/imagens/favicon.ico' alt=''></a> </div><div class='menu'><ul><li class='abas'><a href=''>Materiais</a><div class='menuBaixo'><a href='matEqua1grau.html'>Equação de 1º grau</a><a href='matEqua2grau.html'>Equação de 2º grau</a><a href='matSistemas.html'>Sistemas Lineares</a> </div> </li> <li class='abas'> <a href=''>Ferramentas</a> <div class='menuBaixo'> <a href='ferEqua1grau.html'>Equação de 1º grau</a>   <a href='ferEqua2grau.html'>Equação de 2º grau</a> <a href='ferSistemas.html'>Sistemas Lineares</a> </div>  </li> <li class='abas'>  <a href='siteMath.html'>SiteMath</a>  </li>  </ul> </div> <div class='iconResponsivo'>  <button onclick='mostraMenu()'><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-list' viewBox='0 0 16 16'> <path fill-rule='evenodd' d='M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5' /></svg></button> </div> </nav> <div class='menuResponsivo'> <br><br>  <h2>Materiais</h2><br><a href='matEqua1grau.html'>Equação de 1º grau</a><br><br> <a href='matEqua2grau.html'>Equação de 2º grau</a> <br><br> <a href='matSistemas.html'>Sistemas Lineares</a> <br><br><h2>Ferramentas</h2> <br><a href='ferEqua1grau.html'>Equação de 1º grau</a> <br><br> <a href='ferEqua2grau.html'>Equação de 2º grau</a> <br><br><a href='ferSistemas.html'>Sistemas Lineares</a> <br><br> <h2>SiteMath</h2><br> <a href='siteMath.html'>O que é o SiteMath</a><br><br></div></header>"
}

//Mensagem de boas vindas do site, junto com a data
function ola() {
    var hoje = new Date();
    var diasemana = hoje.getDay();
    var nomesemana = "";

    var mes = hoje.getMonth() + 1;
    var ano = hoje.getFullYear();
    var dia = hoje.getDate();

    switch (diasemana) {
        case 0:
            nomesemana = "Domingo";
            break;
        case 1:
            nomesemana = "segunda-feira";
            break;
        case 2:
            nomesemana = "terça-feira";
            break;
        case 3:
            nomesemana = "quarta-feira";
            break;
        case 4:
            nomesemana = "quinta-feira";
            break;
        case 5:
            nomesemana = "sexta-feira";
            break;
        case 6:
            nomesemana = "sábado";

    }
    switch (mes) {
        case 1:
            mes = "janeiro";
            break;
        case 2:
            mes = "fevereiro";
            break;
        case 3:
            mes = "março";
            break;
        case 4:
            mes = "abril";
            break;
        case 5:
            mes = "maio";
            break;
        case 6:
            mes = "junho";
            break;
        case 7:
            mes = "julho";
            break;
        case 8:
            mes = "agosto";
            break;
        case 9:
            mes = "setembro";
            break;
        case 10:
            mes = "outubro";
            break;
        case 11:
            mes = "novembro";
            break;
        case 12:
            mes = "dezembro";
            break;
    }
    fim.innerHTML += ("Olá, e muito bem vindo ao SiteMath, o <em>site</em> do <a href='siteMath.html'>AjudaMath!</a> Hoje é " + nomesemana + ", dia  " + dia + " de " + mes + " de " + ano + "<br><br>");
}

//Habilitar menu responsivo
function mostraMenu() {
    let menuRespons = document.querySelector('.menuResponsivo');
    if (menuRespons.classList.contains('open')) {
        menuRespons.classList.remove('open');
    }
    else {
        menuRespons.classList.add('open');
    }
}

//Rodapé da página
function fimPagina() {
    rodapeh.innerHTML = "<div class='rodape'> <div id='logo'> <img src='midia/imagens/minha_foto.png' alt='minha_foto'> </div> <div id='logo'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div> <div class='rConteudo'> <strong>DANIEL RAMOS SENA</strong> <br> Idealizador do AjudaMath<br><br> <a href='https://instagram.com/odanielrsena' target='_blank' rel='nofollow'><img src='midia/imagens/insticon.png' alt=''></a> &nbsp; <a href='https://github.com/DanielRSena' target='_blank' rel='external'> <img src='midia/imagens/giticon.png' alt=''></a> &nbsp; <a href='https://www.linkedin.com/in/daniel-ramos-sena-84226724a/' target='_blank' rel='external'><img src='midia/imagens/linkicon.png' alt=''></a> <br><br> Muito obrigado por visitar esse site :) <br><br> Quer sugerir ou comentar algo? Envie para danielsena20@hotmail.com</div> </div>";
}


//2. Funções para as ferramentas matemáticas

//verifica se os valores digitados nas ferramentas realmente são números
function valida() {
    erro = false;
    for (let i = 0; i < arguments.length; i++) {
        if (isNaN(arguments[i]))
            erro = true;
    }

    return erro;

}

//equação de 1ºgrau
function equação_1_grau() {

    var a = parseFloat(var_a.value);
    var b = parseFloat(var_b.value);
    var vIgualdade = parseFloat(igualdade.value);

    if (isNaN(a) == true)
        f1grau.innerHTML = "<br> O 'a' deve ser um número"
    else if (isNaN(b) == true)
        f1grau.innerHTML = "<br> O 'b' deve ser um número"
    else if (isNaN(vIgualdade) == true)
        f1grau.innerHTML = "<br> O valor da igualdade deve ser um número"
    else {
        if (a == 0)
            f1grau.innerHTML = "<br><br>Erro! o 'a' deve ser diferente de 0.<br><br>"
        else {
            f1grau.innerHTML = "<br><br>" + a + "x + " + b + " = " + vIgualdade + "<br><br>" + a + "x = " + vIgualdade + " - " + b + "<br><br>";

            b = b * (-1) + vIgualdade;

            f1grau.innerHTML += a + "x = " + b + "<br><br> x = " + b + " / " + a + "<br><br>";

            var resultado = b / a;

            f1grau.innerHTML += "<strong>x = " + resultado + "</strong><br><br>";
        }
    }
}

//equação de 2º grau
function equação_2_grau() {

    var a = parseFloat(var_a.value);
    var b = parseFloat(var_b.value);
    var vIgualdade = parseFloat(igualdade.value);
    var c = parseFloat(var_c.value);
    var delta, x1, x2;

    var teste = valida(a, b, c, vIgualdade)

    if (teste == true)
        resultado.innerHTML = "<br><br> Erro! Todos os valores devem ser números";
    else if(a == 0){
        resultado.innerHTML = "<br>Erro! O 'a' deve ser diferente de 0<br><br>";
    }
    else {
        c += (vIgualdade * (-1));

        resultado.innerHTML = "<br><br>a = " + a + ", b = " + b + ", c = " + c + " <br><br>";

        resultado.innerHTML += "<h2> Resultado </h2><br>Equação base: " + a + "x<sup>2</sup> + " + b + "x + " + c + " = 0 <br><br><br>"

        resultado.innerHTML += "&Delta; = " + b + "<sup>2</sup> - 4 . " + a + " . " + c + "<br><br> &Delta; = " + (b * b) + " - " + (4 * a * c) + "<br><br>";

        delta = (b * b) - (4 * a * c);

        resultado.innerHTML += "&Delta; = " + delta + "<br><br>";

        if (delta < 0)
            resultado.innerHTML += "&Delta; = " + delta + ", portanto não tem raízes reais";
        else if (delta == 0)
            resultado.innerHTML += "O x tem valor único, que é " + ((-b) / (2 * a));
        else {

            delta = Math.sqrt(delta);
            delta = delta.toFixed(2);
            delta = parseFloat(delta);


            resultado.innerHTML += "&#8730; &Delta; = " + delta + "<br><br><br>"

            //x1

            resultado.innerHTML += "<strong>x1</strong> = (" + (-b) + " + " + delta + ") / ( " + 2 + " . " + a + ")<br><br>";

            x1 = (-b) + delta;
            x1 = x1.toFixed(2);

            resultado.innerHTML += "<strong>x1</strong> = " + x1 + " / " + (2 * a) + "<br><br><strong>x1</strong> = " + (x1 / (2 * a)) + "<br><br><br>";

            //x2

            resultado.innerHTML += "<strong>x2</strong> = (" + -b + " - " + delta + ") / ( " + 2 + " . " + a + ")<br><br>";

            x2 = ((-b) - delta);

            resultado.innerHTML += "<strong>x2</strong> = " + x2 + " / " + (2 * a) + "<br><br><strong>x2</strong> = " + ((-b) - delta) / (2 * a) + "<br><br>";

        }
    }

}

//sistemas lineares
function sistemasLineares() {

    var x, y;
    var nx1 = parseFloat(nx_1.value);
    var ny1 = parseFloat(ny_1.value);
    var n1 = parseFloat(n_1.value);
    var nx2 = parseFloat(nx_2.value);
    var ny2 = parseFloat(ny_2.value);
    var n2 = parseFloat(n_2.value);
    var aux = ny1;
    var aux2 = n1;

    teste = valida(nx1, ny1, n1, nx2, ny2, n2) //faz um teste para ter certeza de que todas as variáveis são números

    if (teste == true) //verifica se o método retornou erro
        sistemas.innerHTML = "<br><br>Todos os valores devem ser números!"
    else {
        aux = ny1;
        ny1 *= nx2;
        aux2 = n1;
        n1 *= nx2;

        ny2 = ny2 * (-nx1);
        n2 = n2 * (-nx1);

        ny2 += ny1;
        n2 += n1;

        y = n2 / ny2;

        y = parseFloat(y.toFixed(2));

        x = (aux2 - (aux * y)) / nx1;

        x = parseFloat(x.toFixed(2))

        sistemas.innerHTML = "<br><br> X = " + x + "<br>Y = " + y;
    }


}
