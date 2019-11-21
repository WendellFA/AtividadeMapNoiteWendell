
package br.edu.map.CadastroProdutos.dao;


import br.edu.map.CadastroProdutos.model.EspecificacaoModel;
import br.edu.map.CadastroProdutos.model.ProdutoModel;
import br.edu.map.CadastroProdutos.util.ConnectionF;


/**
 *
 * @author Wendell 18/11/2019
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
   
    private Connection conect;
    private String sql;
    private PreparedStatement state;
    private ResultSet resul;

    public void inserir(ProdutoModel produto) throws Exception {
        conect = ConnectionF.getConnection();

        
        sql = "insert into CadastroDeProdutos.especificacoes (fabricante, cor, sistema, detalhes) values (?,?,?,? )";

        
        state = conect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        state.setString(1, produto.getEspecificacao().getFabricante());
        state.setString(2, produto.getEspecificacao().getCor());
        state.setString(3, produto.getEspecificacao().getSistema());
        state.setString(4, produto.getEspecificacao().getDetalhes());

        state.executeUpdate();

        resul = state.getGeneratedKeys();

        int codigoEspecificacao = 0;

        if (resul.next()) {
            codigoEspecificacao = resul.getInt(1);
        }


        sql = "insert into CadastroDeProdutos.produtos (nome, preco, especificacao) values (?,?,?)";

        state = conect.prepareStatement(sql);

        state.setString(1, produto.getNome());
        state.setDouble(2, produto.getPreco());

        state.setInt(3, codigoEspecificacao);

        state.executeUpdate();

        conect.close();
    }

    public List<ProdutoModel> listar() throws Exception {
        List<ProdutoModel> produtos = new ArrayList<>();
        conect = ConnectionF.getConnection();
        sql = "select p.*, e.* from CadastroDeProdutos.produtos p, CadastroDeProdutos.especificacoes e where p.especificacao = e.codigo";
        state = conect.prepareStatement(sql);
        ResultSet rs = state.executeQuery();
        while (rs.next()) {
            ProdutoModel p = new ProdutoModel();
            p.setEspecificacao(new EspecificacaoModel());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getInt("preco"));

            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));

            produtos.add(p);
        }
        conect.close();
        return produtos;
    }

    public ProdutoModel buscar(int codigo) throws Exception {
        ProdutoModel p = null;
        conect = ConnectionF.getConnection();
        sql = "select p.*, e.* from CadastroDeProdutos.produtos p, CadastroDeProdutos.especificacoes e where p.codigo = ? and p.especificacao = e.codigo";
        state = conect.prepareStatement(sql);
        state.setInt(1, codigo);
        ResultSet rs = state.executeQuery();
        if (rs.next()) {
            p = new ProdutoModel();
            p.setEspecificacao(new EspecificacaoModel());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getInt("preco"));

            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));
        }
        conect.close();
        return p;
    }


    public void remover(ProdutoModel produto) throws Exception {
        conect = ConnectionF.getConnection();

        sql = "delete from CadastroDeProdutos.produtos where codigo = ?";

        state = conect.prepareStatement(sql);

        state.setInt(1, produto.getCodigo());

        state.executeUpdate();

        conect.close();
    }

    public void editar(ProdutoModel produto) throws Exception{
        conect = ConnectionF.getConnection();

        sql = "update CadastroDeProdutos.produtos set nome = ?, preco = ? where codigo = ?";

        state = conect.prepareStatement(sql);

        state.setString(1, produto.getNome());
        state.setFloat(2, produto.getPreco());
        state.setInt(3, produto.getCodigo());

        state.executeUpdate();

        sql = "update CadastroDeProdutos.especificacoes set fabricante = ?, cor = ?, sistema = ?, detalhes = ? where codigo = ?";

        state = conect.prepareStatement(sql);

        state.setString(1, produto.getEspecificacao().getFabricante());
        state.setString(2, produto.getEspecificacao().getCor());
        state.setString(3, produto.getEspecificacao().getSistema());
        state.setString(4, produto.getEspecificacao().getDetalhes());
        state.setInt(5, produto.getEspecificacao().getCodigo());
        state.executeUpdate();

        conect.close();
    }
    
}
