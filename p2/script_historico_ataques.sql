-- Active: 1763488262353@@pg-274380a2-ruanvictor-c151.l.aivencloud.com@23212@defaultdb
CREATE TABLE tb_historico_ataque( 
codigo SERIAL PRIMARY KEY, 
personagem VARCHAR(200) NOT NULL, 
armamento VARCHAR(200) NOT NULL, 
armamentoUsos INT NOT NULL
);

select * from tb_historico_ataque;

drop table tb_historico_ataque;

INSERT INTO tb_historico_ataque(personagem, armamento, armamentoUsos) VALUES('robo', 'faca', 5);

delete from tb_historico_ataque;