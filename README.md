# Planetario
Simulador interativo de planetas com cálculos científicos e geração de relatórios em PDF, com front-end 3D em HTML/CSS/JS e back-end em Java conectado a MySQL.
https://gio0000.github.io/Planetario/


# 🌌 Planetário Interativo

Este projeto é um **simulador interativo de planetas**, permitindo aos usuários criar planetas, calcular propriedades físicas e atmosféricas e gerar relatórios em PDF.

---

## **📂 Estrutura do projeto**

- `banco.sql` → Script SQL para criar o banco de dados `simulador_planetas` com as tabelas:
  - `usuarios`
  - `planetas`
  - `calculos`
- `PlanetaApp.class` → Código Java que conecta ao banco, insere planetas, consulta dados e realiza cálculos científicos.
- `CriarPDF.class` → Código Java que gera relatórios em PDF com todos os parâmetros do planeta.
- `index.html` / `planeta.html` → Páginas web interativas para inserir e visualizar planetas.
- `style.css` → Estilos das páginas.
- `script.js` → Lógica interativa do frontend.
- `mysql-connector-j-9.4.0.jar` → Driver Java para MySQL.
- `itextpdf-5.5.13.3.jar` → Biblioteca Java para gerar PDFs.

---

## **⚙️ Configuração do Banco**

1. Instale MySQL na sua máquina.
2. Abra o terminal do MySQL e execute o script:
```sql
source caminho/para/banco.sql;
Isso criará o banco simulador_planetas e as tabelas necessárias.

Crie um usuário para acessar o banco (exemplo):

sql
Copy
Edit
CREATE USER 'giordana'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON simulador_planetas.* TO 'giordana'@'localhost';
FLUSH PRIVILEGES;
💻 Rodando o backend (Java)
1. Inserir e consultar planetas
Execute o PlanetaApp:

bash
Copy
Edit
java -cp ".;mysql-connector-j-9.4.0.jar" PlanetaApp
Isso conecta ao banco, insere planetas e realiza cálculos como gravidade, velocidade de escape e vida potencial.

2. Gerar PDF do planeta
Execute o CriarPDF:

bash
Copy
Edit
java -cp ".;itextpdf-5.5.13.3.jar" CriarPDF
Ele gera um relatório com todas as propriedades do planeta criado, incluindo:

Massa

Raio

Densidade

Gravidade

Velocidade de escape

Atmosfera

Superfície

Rotação

Inclinação

Temperatura

⚠️ Certifique-se de rodar PlanetaApp antes para que os dados do planeta estejam no banco.

🌐 Rodando o frontend (interativo)
Abra index.html ou planeta.html em um navegador moderno.

Você poderá:

Inserir propriedades do planeta

Visualizar animações 3D

Selecionar cálculos que deseja realizar

Exportar relatórios em PDF (chama CriarPDF localmente)

GitHub Pages serve apenas o frontend (HTML/CSS/JS). O backend Java precisa ser executado localmente.

📦 Dependências
MySQL Connector Java

iText PDF 5.5.13.3

Java JDK 8 ou superior

🔧 Comandos úteis
Compilar arquivos Java
bash
Copy
Edit
javac -cp ".;mysql-connector-j-9.4.0.jar;itextpdf-5.5.13.3.jar" PlanetaApp.java CriarPDF.java
Executar arquivos Java
bash
Copy
Edit
java -cp ".;mysql-connector-j-9.4.0.jar" PlanetaApp
java -cp ".;itextpdf-5.5.13.3.jar" CriarPDF
Executar script SQL
sql
Copy
Edit
source caminho/para/banco.sql;
📝 Funcionalidades
Inserção e consulta de planetas pelo usuário

Cálculos científicos automáticos

Exportação de relatórios em PDF

Frontend interativo com animação e visualização do planeta
