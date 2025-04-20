import { includeHTML, ola, deslizar, mostrarMenu, aplicarTema, aplicarTemaInicial } from "./js/util.js"
import { equacao1Grau, equacao2Grau, sistemasLineares, vMedia, circunferencia, areaCirculo, comprimentoArco } from "./js/contas.js";

ola();

includeHTML('header', './arqs/htmls/menu.html').then(() => {
  const botao = document.getElementById('botaoMenu');
  if (botao) mostrarMenu();

  aplicarTemaInicial(); // Carrega o tema salvo ou do sistema

  const toggleTema = document.getElementById('toggleTema');
  toggleTema.addEventListener('click', () => {
    const temaAtual = document.documentElement.getAttribute('data-theme');
    const escuro = temaAtual !== 'dark'; // Inverte o tema atual
    aplicarTema(escuro);
  });
});

includeHTML("footer", "./arqs/htmls/rodape.html");

deslizar();


document.addEventListener('DOMContentLoaded', () => {
    let ultimoScroll = 0;
    const navbar = document.querySelector('header');

    if (!navbar) return;

    window.addEventListener('scroll', () => {
        const scrollAtual = window.scrollY;

        if (scrollAtual > ultimoScroll) {
            navbar.classList.add('menuPrincipal-escondido');
        } else {
            navbar.classList.remove('menuPrincipal-escondido');
        }

        ultimoScroll = scrollAtual;
    });
});

const botao1Grau = document.getElementById('botao1grau');
if (botao1Grau) botao1Grau.addEventListener('click', equacao1Grau);

const botao2Grau = document.getElementById('botao2grau');
if (botao2Grau) botao2Grau.addEventListener('click', equacao2Grau);

const botaoSistema = document.getElementById('botaoSistemas');
if (botaoSistema) botaoSistema.addEventListener('click', sistemasLineares);

const botaoVMedia = document.getElementById('botaoVMedia');
if (botaoVMedia) botaoVMedia.addEventListener('click', vMedia);

const botaoCircunferencia = document.getElementById('botaoCircunferencia');
if (botaoCircunferencia) botaoCircunferencia.addEventListener('click', circunferencia);

const botaoAreaCirculo = document.getElementById('botaoAreaCirculo');
if (botaoAreaCirculo) botaoAreaCirculo.addEventListener('click', areaCirculo);

const botaoComprimento = document.getElementById('botaoComprimento');
if (botaoComprimento) botaoComprimento.addEventListener('click', comprimentoArco);