function valida() {
    var erro = false;

    for (let i = 0; i < arguments.length; i++)
        if (isNaN(arguments[i])) erro = true;

    if (erro == true) window.alert("Todos os valores devem ser números!");
    return erro;
}

function verificarNumero(id) {
    const num = document.getElementById(id);
    const valor = num.value.trim();
    const numero = parseFloat(valor.replace(',', '.'));
    return numero;
}

//equação de 1º grau
export function equacao1Grau() {

    f1grau.innerHTML = "";

    var a = verificarNumero("var_a");
    var b = verificarNumero("var_b");
    var vIgualdade = verificarNumero("igualdade");

    if (a == 0) document.getElementById("f1grau").innerHTML = "<br><br>Erro! o 'a' deve ser diferente de 0.<br><br>";
    if (!isNaN(a) && !isNaN(b) && !isNaN(vIgualdade)) {
        f1grau.innerHTML = "<br><br>" + a + "x + " + b + " = " + vIgualdade + "<br><br>" + a + "x = " + vIgualdade + " - " + b + "<br><br>";

        b = b * (-1) + vIgualdade;

        f1grau.innerHTML += a + "x = " + b + "<br><br> x = " + b + " / " + a + "<br><br>";

        var resultado = b / a;

        f1grau.innerHTML += "<strong>x = " + resultado + "</strong><br><br>";
    }
}

//equação de 2º grau
export function equacao2Grau() {

    var a = verificarNumero("var_a");
    var b = verificarNumero("var_b");
    var c = verificarNumero("var_c");
    var vIgualdade = verificarNumero("igualdade");
    var delta, x1, x2;

    if (valida(a, b, c, vIgualdade) != true) {

        if (a == 0) resultado.innerHTML = "<br><br>Erro! o 'a' deve ser diferente de 0.<br><br>";
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
}

//sistemas lineares
export function sistemasLineares() {

    var x, y;
    var nx1 = verificarNumero("nx_1");
    var ny1 = verificarNumero("ny_1");
    var n1 = verificarNumero("n_1");
    var nx2 = verificarNumero("nx_2");
    var ny2 = verificarNumero("ny_2");
    var n2 = verificarNumero("n_2");
    var aux = ny1;
    var aux2 = n1;

    var teste = valida(nx1, ny1, n1, nx2, ny2, n2) //faz um teste para ter certeza de que todas as variáveis são números

    if (!teste == true) {

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

//velociade média
export function vMedia() {

    document.getElementById("velocidade").value = "";

    var distancia = verificarNumero("distancia");
    var tempo = verificarNumero("tempo");

    if (valida(distancia, tempo) != true) {
        var resultado = distancia / tempo;
        resultado = parseFloat(resultado.toFixed(2));
        document.getElementById("velocidade").value = resultado;
    }
}

export function circunferencia() {
    var raio = verificarNumero(window.innerWidth <= 725 ? "raio-mobile" : "raio-desktop");

    if (valida(raio) != true) {
        var circunferencia = 2 * Math.PI * raio;
        circunferencia = parseFloat(circunferencia.toFixed(2));
        circunferenciaResult.innerHTML = circunferencia;
        document.getElementById("circunferencia").value = circunferencia;
    }
    else document.getElementById("circunferencia").value = "?";
}

export function areaCirculo() {

    var raio = verificarNumero(window.innerWidth <= 725 ? "raioArea-mobile" : "raioArea-desktop");

    if (valida(raio) != true) {
        var area = Math.PI * raio * raio;
        area = parseFloat(area.toFixed(2));
        areaResult.innerHTML = area;
        document.getElementById("areaResult-mobile").value = area
    }
    else areaResult.innerHTML = "?";
}

export function comprimentoArco() {

    var raio = verificarNumero(window.innerWidth <= 725 ? "raioComprimento-mobile" : "raioComprimento-desktop");
    var angulo = verificarNumero(window.innerWidth <= 725 ? "anguloComprimento-mobile" : "anguloComprimento-desktop");

    if (valida(raio, angulo) != true) {
        var comprimento = 2 * Math.PI * raio * angulo / 360;
        comprimento = parseFloat(comprimento.toFixed(2));
        comprimentoResult.innerHTML = comprimento;
        document.getElementById("comprimento").value = comprimento;
    }
    else comprimentoResult.innerHTML = "?";
}