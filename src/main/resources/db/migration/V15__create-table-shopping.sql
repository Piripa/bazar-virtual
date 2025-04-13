CREATE TABLE shopping (
                         id SERIAL PRIMARY KEY,
                         vestimenta_id UUID,
                         usuario_id INT,
                         datetime date NOT NULL,
                         FOREIGN KEY (usuario_id) references usuarios(id),
                         FOREIGN KEY (vestimenta_id) references  vestimentas(id)
);