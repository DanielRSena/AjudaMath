export async function includeHTML(selector, file) {
  const response = await fetch(file);
  if (!response.ok) throw new Error(`Erro ao carregar ${file}`);
  const html = await response.text();
  document.querySelector(selector).innerHTML = html;
}

export function ola() {

  const diasSemana = ["domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado"];
  const meses = ["janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"];

  var hoje = new Date();

  var dia = hoje.getDate();
  var diasemana = hoje.getDay();

  var mes = hoje.getMonth() + 1;

  fim.innerHTML += ("Olá, e muito bem vindo ao SiteMath, o <em>site</em> do <a href='siteMath.html'>AjudaMath!</a> Hoje é " + diasSemana[diasemana] + ", dia  " + dia + " de " + meses[mes - 1] + " de " + hoje.getFullYear() + "<br><br>");
}

export function mostrarMenu() {
  const menuButton = document.getElementById("botaoMenu");
  const menu = document.getElementById("menu");
  const nav = document.querySelector("header");
  menuButton.addEventListener("click", function () {
    menu.classList.toggle("hidden");
    menu.classList.toggle("visible");

    if (menu.classList.contains("visible")) nav.classList.add("open");
    else nav.classList.remove("open");

    menuButton.classList.toggle("open");
    menuButton.innerHTML = (menu.classList.contains("visible")) ? '<i class="bi bi-x"></i>' : '<i class="bi bi-list"></i>';
  });
}

export function deslizar() {
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      e.preventDefault();
      document.querySelector(this.getAttribute('href')).scrollIntoView({
        behavior: 'smooth'
      });
    });
  });
}

export function aplicarTema(escuro) {
  const html = document.documentElement;
  
  // Adiciona classe para evitar piscadas durante a troca
  html.classList.add('no-transition');
  
  // Aplica o tema
  localStorage.setItem('tema', escuro ? 'dark' : 'light');
  html.setAttribute('data-theme', escuro ? 'dark' : 'light');
  
  // Atualiza ícone (se existir)
  const icone = document.getElementById('iconeTema');
  if (icone) {
      icone.className = escuro ? 'bi bi-moon-fill' : 'bi bi-brightness-high-fill';
      icone.classList.remove('rotate');
      void icone.offsetWidth; // Força reflow
      icone.classList.add('rotate');
  }
  
  // Remove a classe após um pequeno delay
  setTimeout(() => {
      html.classList.remove('no-transition');
  }, 10); // 10ms é suficiente para evitar conflitos
}

export function aplicarTemaInicial() {
  // 1. Verifica se o usuário já fez uma escolha manual (salva no localStorage)
  const temaSalvo = localStorage.getItem('tema');

  // 2. Se não tiver escolha salva, aí usa o do sistema
  const prefereEscuro = temaSalvo !== null
    ? temaSalvo === 'dark' // Prioriza o que foi salvo
    : window.matchMedia('(prefers-color-scheme: dark)').matches; // Fallback para o sistema

  aplicarTema(prefereEscuro);
}