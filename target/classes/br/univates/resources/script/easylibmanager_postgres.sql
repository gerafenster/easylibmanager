CREATE DATABASE easylib_manager;

\connect easylib_manager;

CREATE TABLE usuario (
id BIGSERIAL NOT NULL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR(50) NOT NULL,
login VARCHAR(50) NOT NULL,
senha VARCHAR(50) NOT NULL,
cpf VARCHAR(14) NOT NULL
);

CREATE TABLE cliente (
id BIGSERIAL NOT NULL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR(50) NOT NULL,
cpf VARCHAR(14) NOT NULL,
email VARCHAR(150),
telefone VARCHAR(14),
celular VARCHAR(15)
);

CREATE TABLE autor (
id BIGSERIAL NOT NULL PRIMARY KEY,
nome_completo VARCHAR(150) NOT NULL
);

CREATE TABLE editora (
id BIGSERIAL NOT NULL PRIMARY KEY,
nome VARCHAR(50) NOT NULL
);

CREATE TABLE categoria (
id BIGSERIAL NOT NULL PRIMARY KEY,
nome VARCHAR(50) NOT NULL
);

CREATE TABLE livro (
id BIGSERIAL NOT NULL PRIMARY KEY,
isbn VARCHAR(13) NOT NULL,
ano INT NOT NULL,
titulo VARCHAR(150) NOT NULL,
is_disponivel BOOLEAN NOT NULL,
autor_id BIGINT REFERENCES autor (id),
editora_id BIGINT REFERENCES editora (id),
categoria_id BIGINT REFERENCES categoria (id)
);

CREATE TABLE emprestimo (
id BIGSERIAL NOT NULL PRIMARY KEY,
data_emprestimo DATE NOT NULL,
data_devolucao DATE NOT NULL,
usuario_id BIGINT REFERENCES usuario (id),
cliente_id BIGINT REFERENCES cliente (id),
livro_id BIGINT REFERENCES livro (id)
);

INSERT INTO categoria (nome) VALUES ('Biografias') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Coleções') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Comportamento') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Contos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Crítica Literária') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Ficção Científica') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Folclore') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Genealogia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Humor') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Infantojuvenis') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Jogos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Jornais') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Literatura Brasileira') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Literatura Estrangeira') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Livros Raros') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Manuscritos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Poesia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Outros Assuntos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Administração') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Agricultura') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Antropologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Arqueologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Arquitetura') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Artes') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Astronomia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Biologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Botânica') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Brasil') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Ciência Política') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Ciências Exatas') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Cinema') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Comunicação') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Contabilidade') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Decoração') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Dicionários') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Didáticos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Direito') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Documentos') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Ecologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Economia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Engenharia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Enciclopédias') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Ensino de Idiomas') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Filosofia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Fotografia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Geografia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Guerra') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('História do Brasil') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('História Geral') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Informática') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Linguística') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Medicina') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Moda') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Música') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Pecuária') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Pedagogia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Pintura') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Psicologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Saúde') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Sociologia') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Teatro') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Turismo') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Artesanato') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Auto ajuda') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Culinária') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Esoterismo') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Esportes') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Hobbies') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Religião') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Sexualidade') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Revistas') ON CONFLICT DO NOTHING;
INSERT INTO categoria (nome) VALUES ('Gibis') ON CONFLICT DO NOTHING;

INSERT INTO usuario VALUES ('1','null', 'null', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'null');