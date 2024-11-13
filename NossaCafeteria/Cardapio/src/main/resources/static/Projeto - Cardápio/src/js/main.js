function digitar(tecla) {
    const display = document.getElementById("display");
    display.innerText += tecla;
}

// Função para apagar o último caractere
function apagar() {
    const display = document.getElementById("display");
    display.innerText = display.innerText.slice(0, -1);
}

// Função para limpar o display
function limpar() {
    const display = document.getElementById("display");
    display.innerText = "";
}

// Seleciona a caixa de entrada
const display = document.getElementById("display");

// Adiciona o evento para detectar a tecla "Enter"
display.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // Evita o comportamento padrão (caso esteja dentro de um formulário)
        const text = display.value; // Obtém o texto digitado

        // Verifica se o campo não está vazio antes de redirecionar
        if (text.trim() !== "") {
            // Redireciona para a página desejada (substitua "pagina-destino.html" pelo link desejado)
            window.location.href = "menu.html";
        } else {
            alert("Por favor, insira algum texto antes de continuar.");
        }
    }
});

// Função para enviar o texto do display
function sendText() {
    const text = display.innerText;
    alert("Texto enviado: " + text);
    display.innerText = ""; // Limpa o display após enviar
}

// Seleciona a caixa de entrada
const inputBox = document.getElementById("inputBox");

// Adiciona o evento para detectar a tecla "Enter"
inputBox.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // Evita o comportamento padrão (caso esteja dentro de um formulário)
        const text = inputBox.value; // Obtém o texto digitado

        // Verifica se o campo não está vazio antes de redirecionar
        if (text.trim() !== "") {
            // Redireciona para a página desejada (substitua "pagina-destino.html" pelo link desejado)
            window.location.href = "menu.html";
        } else {
            alert("Por favor, insira algum texto antes de continuar.");
        }
    }
});