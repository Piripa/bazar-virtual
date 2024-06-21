CREATE TABLE buycars (
    id SERIAL PRIMARY KEY,
    vestimenta_id UUID,
    usuario_id INT,
    datetime date NOT NULL,
    FOREIGN KEY (usuario_id) references usuarios(id),
    FOREIGN KEY (vestimenta_id) references  vestimentas(id)
);
CREATE TABLE vendedores (
    id SERIAL PRIMARY KEY,
    usuariov_id INT ,
    vestimenta_id UUID,
    FOREIGN KEY (usuariov_id) references usuarios(id),
    FOREIGN KEY (vestimenta_id) references  vestimentas(id)
);

ALTER TABLE vestimentas DROP COLUMN vendedor_id;

ALTER TABLE vestimentas ADD COLUMN  vendedores_id INT;

ALTER TABLE vestimentas
ADD CONSTRAINT fk_vendedor_id
FOREIGN KEY (vendedores_id)
references vendedores(id);