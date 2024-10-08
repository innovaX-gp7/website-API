package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalTime;

public class LogsJAR {


    private Integer idLog;
    private String descricao;
    private LocalTime dataHora;
    private Integer fkLogEmpresa;

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    public LogsJAR() {
    }

    public LogsJAR(Integer idLog, String descricao, LocalTime dataHora, Integer fkLogEmpresa, Conexao conexao, JdbcTemplate con) {
        this.idLog = idLog;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.fkLogEmpresa = fkLogEmpresa;
        this.conexao = conexao;
        this.con = con;
    }

    @Override
    public String toString() {
        return "LogsJAR{" +
                "fkLogEmpresa=" + fkLogEmpresa +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                ", idLog=" + idLog +
                '}';
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getFkLogEmpresa() {
        return fkLogEmpresa;
    }

    public void setFkLogEmpresa(Integer fkLogEmpresa) {
        this.fkLogEmpresa = fkLogEmpresa;
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

    public String criarTabelaLogsJAR() {
        String sql = "CREATE TABLE IF NOT EXISTS logsJAR (\n" +
                "idLog INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "descricao VARCHAR(1000),\n" +
                "dataHora DATETIME,\n" +
                "fkLogEmpresa INT,\n" +
                "CONSTRAINT fk_empresa_log FOREIGN KEY (fkLogEmpresa) REFERENCES empresa(idEmpresa)\n" +
                ");";
        return sql;
    }

}
