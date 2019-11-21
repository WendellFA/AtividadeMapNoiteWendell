
package br.edu.map.CadastroProdutos.model;

/**
 *
 * @author Wendell 18/11/2019
 */
public class ProdutoModel {
    
    private int cod;
    private String nome;
    private float preco;
    private EspecificacaoModel especif;

    public ProdutoModel(int codigo, String nome, float preco, EspecificacaoModel especificacao) {
        this.cod = codigo;
        this.nome = nome;
        this.preco = preco;
        this.especif = especificacao;
    }

    public ProdutoModel() {

    }

    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int codigo) {
        this.cod = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public EspecificacaoModel getEspecificacao() {
        return especif;
    }

    public void setEspecificacao(EspecificacaoModel especificacao) {
        this.especif = especificacao;
    }

    @Override
    public String toString() {
        final StringBuilder strbd = new StringBuilder("Produto{");
        strbd.append("codigo=").append(cod)
                  .append(", nome='").append(nome).append('\'')
                  .append(", preco=").append(preco)
                  .append(", especificacao=").append(especif)
                  .append('}');
        return strbd.toString();
    }
    
}
