# 🏬 Catálogo de Produtos

Sistema web para gerenciamento de produtos com CRUD completo, interface moderna e webhook de entrega. Desenvolvido com Spring Boot, MySQL e Docker.

## 🚀 Acesse a aplicação
**http://20.15.110.201:8080**

## 📋 Funcionalidades

- Cadastrar produto (código, nome, preço, estoque)
- Listar produtos em tabela
- Editar produto
- Excluir produto
- API REST para integração
- Webhook para notificar professor sobre entrega do desafio

## 🛠️ Tecnologias

- Spring Boot 3.2.2 (Java 17)
- Spring Data JPA + MySQL 8.0
- HTML5, CSS3, JavaScript (Fetch API)
- Docker + Docker Compose
- VM Ubuntu 22.04 na Azure

## 🎨 Cores do layout

- Principal: `#2E6C7B` (azul petróleo)
- Destaque: `#F4A261` (laranja)

## 🐳 Como executar (local ou VM)

```bash
git clone https://github.com/PhietroSolonoo/DevopsPortalWeb.git
cd DevopsPortalWeb
docker-compose up --build -d
Acesse http://localhost:8080.

📡 Endpoints da API
Método	Endpoint	Descrição
GET	/produtos	Lista todos
GET	/produtos/{codigo}	Busca por código
POST	/produtos	Cria novo
PUT	/produtos/{codigo}	Atualiza
DELETE	/produtos/{codigo}	Remove
POST	/entregas	Envia dados ao webhook
Exemplos curl
bash
# Criar produto
curl -X POST http://20.15.110.201:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"codigo":"P001","nome":"Teclado","preco":150.00,"quantidadeEstoque":10}'

# Listar produtos
curl http://20.15.110.201:8080/produtos

# Enviar entrega
curl -X POST http://20.15.110.201:8080/entregas \
  -H "Content-Type: application/json" \
  -d '{"nome":"João","rm":"RM123","turma":"2ADS"}'
📨 Webhook
O endpoint /entregas envia os dados para a URL definida em APP_WEBHOOK_URL no docker-compose.yml. Para alterar, edite o arquivo e rode docker-compose down && docker-compose up -d.

🛠️ Comandos úteis
bash
docker ps                      # ver containers
docker logs portal-app         # logs da aplicação
docker-compose down            # parar
docker-compose up --build -d   # recriar e subir
✅ Status
Containerização funcionando

CRUD de produtos via web e API

Webhook ativo

Interface responsiva

Desenvolvido por Phietro Solon Oliveira
Repositório: https://github.com/PhietroSolonoo/DevopsPortalWeb
