package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class PromptIA {

    private Integer idPrompt;
    private String descricao;
    private LocalDateTime dataHora;

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando construtor vazio
    public PromptIA(){}

    // Criando construtor com parametros para inicializar atrbutos


    public PromptIA(Integer idPrompt, String descricao, LocalDateTime dataHora, Conexao conexao, JdbcTemplate con) {
        this.idPrompt = idPrompt;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.conexao = conexao;
        this.con = con;
    }

    public Integer getIdPrompt() {
        return idPrompt;
    }

    public void setIdPrompt(Integer idPrompt) {
        this.idPrompt = idPrompt;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
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
        return "promptIA{" +
                "idPrompt=" + idPrompt +
                ", descricao='" + descricao + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }

    public String criarTabelaPromptIA(){

        String sql = "CREATE TABLE IF NOT EXISTS promptIA (\n" +
                "idPrompt INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "descricao VARCHAR(1000),\n" +
                "dataHora DATETIME\n" +
                ");";
        return sql;
    }
}
