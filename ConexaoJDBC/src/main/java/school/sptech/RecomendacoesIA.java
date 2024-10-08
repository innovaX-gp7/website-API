package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class RecomendacoesIA {

    private Integer idRecomedacoes;
    private String unidadeFederativa;
    private String recomendacao;
    private Integer fk_dashboard;

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando construtor vazio
    public RecomendacoesIA() {
    }

    ;

    // Criando construtor com parâmetros
    public RecomendacoesIA(Integer idRecomedacoes, String unidadeFederativa, String recomendacao, Integer fk_dashboard, Conexao conexao, JdbcTemplate con) {
        this.idRecomedacoes = idRecomedacoes;
        this.unidadeFederativa = unidadeFederativa;
        this.recomendacao = recomendacao;
        this.fk_dashboard = fk_dashboard;
        this.conexao = conexao;
        this.con = con;
    }

    public Integer getIdRecomedacoes() {
        return idRecomedacoes;
    }

    public void setIdRecomedacoes(Integer idRecomedacoes) {
        this.idRecomedacoes = idRecomedacoes;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public Integer getFk_dashboard() {
        return fk_dashboard;
    }

    public void setFk_dashboard(Integer fk_dashboard) {
        this.fk_dashboard = fk_dashboard;
    }

    public Conexao getConexao() {
        return conexao;
    }

    public void setConexao(Conexao conexao) {
        this.conexao = conexao;
    }

    public JdbcTemplate getCon() {
        return con;
    }

    public void setCon(JdbcTemplate con) {
        this.con = con;
    }

    public String criarTabelaRecomendacoesIA() {
        String sql = "CREATE TABLE IF NOT EXISTS recomendacoesIA (\n" +
                "idRecomendacoes INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                "unidadeFederativa VARCHAR(50) NOT NULL,\n" +
                "recomendacao VARCHAR(100) NOT NULL,\n" +
                "fkDashboard INT,\n" +
                "CONSTRAINT fk_dashboard FOREIGN KEY(fkDashboard) REFERENCES dashboard(idDashboard)\n" +
                ")AUTO_INCREMENT=1000;";
        return sql;
    }

}
