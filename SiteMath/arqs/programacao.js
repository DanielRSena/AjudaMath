
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
    fetch('arqs/htmls/menu.html').then(response => response.text())
    .then(data => {
        document.getElementById('navegador').innerHTML = data;
    })
    .catch(error => console.error('Error loading navegador:', error));
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
    if (menuRespons.classList.contains('open'))  menuRespons.classList.remove('open'); 
    else menuRespons.classList.add('open');
}

//Rodapé da página
function fimPagina() {
    fetch('arqs/htmls/rodape.html').then(response => response.text())
    .then(data => {
        document.getElementById('rodapeh').innerHTML = data;
    })
    .catch(error => console.error('Error loading rodapé:', error));
}

function deslizar() { 
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});
}



//2. Funções para as ferramentas matemáticas

//verifica se os valores digitados nas ferramentas realmente são números
function valida() {
    erro = false;
    for (let i = 0; i < arguments.length; i++) 
        if (isNaN(arguments[i])) erro = true;
    return erro;
}

//equação de 1ºgrau
function equação_1_grau() {

    var a = parseFloat(var_a.value);
    var b = parseFloat(var_b.value);
    var vIgualdade = parseFloat(igualdade.value);

    if (isNaN(a) == true) f1grau.innerHTML = "<br> O 'a' deve ser um número"
    else if (isNaN(b) == true) f1grau.innerHTML = "<br> O 'b' deve ser um número"
    else if (isNaN(vIgualdade) == true) f1grau.innerHTML = "<br> O valor da igualdade deve ser um número"
    else {
        if (a == 0) f1grau.innerHTML = "<br><br>Erro! o 'a' deve ser diferente de 0.<br><br>"
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

    if (teste == true) resultado.innerHTML = "<br><br> Erro! Todos os valores devem ser números";
    else if(a == 0){ resultado.innerHTML = "<br>Erro! O 'a' deve ser diferente de 0<br><br>";
    }
    else {
        c += (vIgualdade * (-1));

        resultado.innerHTML = "<br><br>a = " + a + ", b = " + b + ", c = " + c + " <br><br>";

        resultado.innerHTML += "<h2> Resultado </h2><br>Equação base: " + a + "x<sup>2</sup> + " + b + "x + " + c + " = 0 <br><br><br>"

        resultado.innerHTML += "&Delta; = " + b + "<sup>2</sup> - 4 . " + a + " . " + c + "<br><br> &Delta; = " + (b * b) + " - " + (4 * a * c) + "<br><br>";

        delta = (b * b) - (4 * a * c);

        resultado.innerHTML += "&Delta; = " + delta + "<br><br>";

        if (delta < 0) resultado.innerHTML += "&Delta; = " + delta + ", portanto não tem raízes reais";
        else if (delta == 0) resultado.innerHTML += "O x tem valor único, que é " + ((-b) / (2 * a));
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

    if (teste == true) sistemas.innerHTML = "<br><br>Todos os valores devem ser números!"
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