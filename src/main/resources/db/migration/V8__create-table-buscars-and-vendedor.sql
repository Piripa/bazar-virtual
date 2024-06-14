CREATE TABLE buycars (
    id TEXT PRIMARY KEY,
    vestimenta_id UUID,
    usuario_id INT,
    datetime date NOT NULL,
    FOREIGN KEY (usuario_id) references usuarios(id),
    FOREIGN KEY (vestimenta_id) references  vestimentas(id)
);
CREATE TABLE vendedores (
    id TEXT PRIMARY KEY,
    usuariov_id INT ,
    vestimenta_id UUID,
    FOREIGN KEY (usuariov_id) references usuarios(id),
    FOREIGN KEY (vestimenta_id) references  vestimentas(id)
);

ALTER TABLE vestimentas ADD COLUMN vendedor_id TEXT;

ALTER TABLE vestimentas
ADD CONSTRAINT fk_vendedor_id
FOREIGN KEY (vendedor_id)
references vendedores(id);