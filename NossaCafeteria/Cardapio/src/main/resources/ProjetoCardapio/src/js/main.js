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
            
            window.location.href = "index.html";
        } else {
            alert("Por favor, insira algum texto antes de continuar.");
        }
    }
});

// Chama os dados da API
// server.js
const express = require('express');
const app = express();
const port = 3000;

// Dados de exemplo dos salgados (você pode substituir pelos dados do seu banco de dados ou API)
const salgados = [
    { id: 1, nome: 'Coxinha', descricao: 'Deliciosa coxinha de frango', preco: 5.50 },
    { id: 2, nome: 'Esfirra', descricao: 'Esfirra de carne moída bem temperada', preco: 4.00 },
    { id: 3, nome: 'Quibe', descricao: 'Quibe recheado com carne', preco: 6.00 }
];

// Rota para retornar os dados dos salgados
app.get('/Salgado', (req, res) => {
    res.json(salgados);
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});