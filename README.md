# FACOMMERCE 📦

Bem-vindo ao FACOMMERCE, um site de e-commerce para venda de produtos de tecnologia! 🚀

## Funcionalidades Principais

- **Identificar-se (login)**
- **Cadastrar produtos**
- **Navegar por uma lista de produtos**
- **Buscar por produtos através do nome**
- **Visualizar detalhes de um produto**
- **Simular compra por meio de carrinho de compras e finalização de pedido/compra**

## Funcionalidades Bônus 

- **Criar categorias e permitir a navegação/filtro**
- **Avaliar produtos**
- **Receber recomendações de produtos**
- **Fazer buscas avançadas**
- **Se cadastrar para receber novidades**

## Tecnologias Utilizadas 💻

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf, JavaScript, Bootstrap

## Estrutura do Banco de Dados 🗄️

### Tabelas Principais

1. **Usuarios (usuarios)**
   - `id`: bigint, primary key
   - `cpf`: character varying(11)
   - `nome`: character varying(255)
   - `email`: character varying(255)
   - `senha`: character varying(255)
   - `data_nascimento`: date
   - `telefone`: character varying(20)
   - `tipo_usuario`: character varying(10)

2. **Produtos (produtos)**
   - `id`: bigint, primary key
   - `nome`: character varying(255)
   - `descricao`: text
   - `preco`: double precision
   - `quantidade_estoque`: integer
   - `categoria_id`: bigint, foreign key (categorias)
   - `imagem_url`: text

3. **Categorias (categorias)**
   - `id`: bigint, primary key
   - `nome`: character varying(255)

4. **Carrinhos (carrinhos)**
   - `id`: bigint, primary key
   - `usuario_id`: bigint, foreign key (usuarios)
   - `data_criacao`: timestamp

5. **Itens do Carrinho (itens_carrinho)**
   - `id`: bigint, primary key
   - `carrinho_id`: bigint, foreign key (carrinhos)
   - `produto_id`: bigint, foreign key (produtos)
   - `quantidade`: integer

6. **Pedidos (pedidos)**
   - `id`: bigint, primary key
   - `usuario_id`: bigint, foreign key (usuarios)
   - `data_pedido`: timestamp
   - `total`: double precision
   - `status`: character varying(10)

7. **Itens do Pedido (itens_pedido)**
   - `id`: bigint, primary key
   - `pedido_id`: bigint, foreign key (pedidos)
   - `produto_id`: bigint, foreign key (produtos)
   - `quantidade`: integer
   - `preco_unitario`: double precision

8. **Pagamentos (pagamentos)**
   - `id`: bigint, primary key
   - `pedido_id`: bigint, foreign key (pedidos)
   - `valor`: double precision
   - `data_pagamento`: timestamp
   - `metodo_pagamento`: character varying(10)

## Como Executar o Projeto 🚀

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/facommerce.git
   ```
2. **Navegue até o diretório do projeto**:
   ```bash
   cd facommerce
   ```
3. **Compile e execute o projeto**:
   ```bash
   mvn spring-boot:run
   ```

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções ou novas funcionalidades para este projeto. Caso tenha dúvidas ou sugestões, abra uma issue para discussão.

---

**Nota:** Este projeto foi desenvolvido como parte de um trabalho acadêmico na disciplina de Programação para Web. As funcionalidades foram implementadas com base em conceitos estudados em sala de aula.
