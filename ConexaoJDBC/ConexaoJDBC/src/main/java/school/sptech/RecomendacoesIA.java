package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class RecomendacoesIA {

    private Integer id;
    private String unidadeFederativa;
    private String recomendacao;
    private Integer fk_dashboard;

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando construtor vazio
    public RecomendacoesIA(){};

    // Criando construtor com parâmetros
    public RecomendacoesIA(Integer id, String unidadeFederativa, String recomendacao, Integer fk_dashboard, Conexao conexao, JdbcTemplate con) {
        this.id = id;
        this.unidadeFederativa = unidadeFederativa;
        this.recomendacao = recomendacao;
        this.fk_dashboard = fk_dashboard;
        this.conexao = conexao;
        this.con = con;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "RecomendacoesIA{" +
                "id=" + id +
                ", unidadeFederativa='" + unidadeFederativa + '\'' +
                ", recomendacao='" + recomendacao + '\'' +
                ", fk_dashboard=" + fk_dashboard +
                '}';
    }

    public String criarTabelaRecomendacoesIA(){
        String sql = "CREATE TABLE recomendacoesIA (\n" +
                "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                "unidadeFederativa VARCHAR(50) NOT NULL,\n" +
                "recomendacao VARCHAR(100) NOT NULL,\n" +
                "fk_dashboard INT,\n" +
                "CONSTRAINT fk_dashboard FOREIGN KEY(fk_dashboard) REFERENCES dashboard(id)\n" +
                ")AUTO_INCREMENT=1000;";
        return sql;
    }

}
