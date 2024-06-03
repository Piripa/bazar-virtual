CREATE TABLE usuarios (
                          id SERIAL PRIMARY KEY,
                          nome TEXT NOT NULL,
                          email TEXT NOT NULL,
                          senha TEXT NOT NULL,
                          telefone TEXT NOT NULL,
                          numero TEXT NOT NULL,
                          complemento TEXT,
                          bairro TEXT NOT NULL,
                          cep TEXT NOT NULL,
                          logradouro TEXT NOT NULL,
                          uf VARCHAR(2) NOT NULL,
                          cidade TEXT NOT NULL
);
