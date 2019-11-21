
package br.edu.map.CadastroProdutos.model;
// Professor eu n tava conseguindo subir para o git do jeito que vc seninou
//Então eu crirei outro projeto e movi os meus pacotes para ele, por isso no codigo ta "CadastroProdutos" e nesse projeto ta "CadastroDeProdutos" 

/*
 * @author Wendell 18/11/2019
 */
public class EspecificacaoModel {
    
     private int cod;
    private String fabricante;
    private String cor;
    private String sistem;
    private String detalhes;

    public EspecificacaoModel(int codigo, String nome, String fabricante, String cor, String sistema, String detalhes) {
        this.cod = codigo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.sistem = sistema;
        this.detalhes = detalhes;
    }

    public EspecificacaoModel() {

    }

    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int codigo) {
        this.cod = codigo;
    }



    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSistema() {
        return sistem;
    }

    public void setSistema(String sistema) {
        this.sistem = sistema;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        final StringBuilder strbd = new StringBuilder("Especificacao{");
        strbd.append("codigo=").append(cod)
                .append(", fabricante='").append(fabricante).append('\'')
                .append(", cor='").append(cor).append('\'')
                .append(", sistema='").append(sistem).append('\'')
                .append(", detalhes='").append(detalhes).append('\'')
                .append('}');
        return strbd.toString();
    }
    
}
