package br.gov.sp.cps.fatecipiranga.db;

import java.sql.PreparedStatement;

import br.gov.sp.cps.fatecipiranga.model.HistoricoAtaque;

public class HistoricoAtaqueDAO{

    public void cadastrar(HistoricoAtaque historico) throws Exception{    
    //1. Especificar o comando SQL
    var sql = "INSERT INTO tb_historico_ataque(personagem, armamento, armamentoUsos) VALUES(?, ?, ?)";
    //2. Obter uma conexão com o SGBD
    var conexao = ConnectionFactory.getConnection();
    //3. Preparar o comando
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    ps.setString(1, historico.getPersonagem());
    ps.setString(2, historico.getArmamento());
    ps.setInt(3, historico.getVezesUsouArma());
    //5. Executar o comando
    ps.execute();
    //6. Fechar os recursos
    ps.close();
    conexao.close();
  } 
  
}