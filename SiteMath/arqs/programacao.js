import { includeHTML, ola, deslizar, mostrarMenu } from "./js/util.js"
import { equacao1Grau, equacao2Grau, sistemasLineares, vMedia } from "./js/contas.js";

ola();

includeHTML('header', './arqs/htmls/menu.html').then(() => {
    const botao = document.getElementById('botaoMenu'); // Agora o botão já existe no DOM
    if (botao) mostrarMenu();
    else console.error('Botão #botaoMenu não encontrado no DOM.');
});

includeHTML("footer", "./arqs/htmls/rodape.html");

deslizar();

const botao1Grau = document.getElementById('botao1grau');
if (botao1Grau) botao1Grau.addEventListener('click', equacao1Grau);

const botao2Grau = document.getElementById('botao2grau');
if (botao2Grau) botao2Grau.addEventListener('click', equacao2Grau);

const botaoSistema = document.getElementById('botaoSistemas');
if (botaoSistema) botaoSistema.addEventListener('click', sistemasLineares);

const botaoVMedia = document.getElementById('botaoVMedia');
if (botaoVMedia) botaoVMedia.addEventListener('click', vMedia);