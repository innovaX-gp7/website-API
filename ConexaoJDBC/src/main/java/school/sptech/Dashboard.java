package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class Dashboard {

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando atributos da Dashboard
    private Integer idDashboard;
    private String unidadeFederativa;
    private Byte mes;
    private Integer ano;
    private BigDecimal areaDesmatada;
    private BigDecimal temperaturaMensal;
    private Integer fk_empresa;

    // Criando construtor vazio
    public Dashboard() {
    }


    // Criando construtor com parâmetros
    public Dashboard(Conexao conexao, JdbcTemplate con, Integer id, String unidadeFederativa, Byte mes, Integer ano, BigDecimal areaDesmatada, BigDecimal temperaturaMensal, Integer fk_empresa) {
        this.conexao = conexao;
        this.con = con;
        this.idDashboard = id;
        this.unidadeFederativa = unidadeFederativa;
        this.mes = mes;
        this.ano = ano;
        this.areaDesmatada = areaDesmatada;
        this.temperaturaMensal = temperaturaMensal;
        this.fk_empresa = fk_empresa;
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

    public Integer getId() {
        return idDashboard;
    }

    public void setId(Integer id) {
        this.idDashboard = id;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getAreaDesmatada() {
        return areaDesmatada;
    }

    public void setAreaDesmatada(BigDecimal areaDesmatada) {
        this.areaDesmatada = areaDesmatada;
    }

    public BigDecimal getTemperaturaMensal() {
        return temperaturaMensal;
    }

    public void setTemperaturaMensal(BigDecimal temperaturaMensal) {
        this.temperaturaMensal = temperaturaMensal;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
    }


    // Criando metódo para criar a tabela no Banco
    public String criarTabelaDashboard() {
        String sql = "CREATE TABLE IF NOT EXISTS dashboard (\n" +
                "    idDashboard INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                "    unidadeFederativa VARCHAR(50) NOT NULL,\n" +
                "    mes TINYINT,\n" +
                "    ano YEAR,\n" +
                "    areaDesmatada DECIMAL(4,2) NOT NULL,\n" +
                "    temperaturaMensal DECIMAL(4,2) NOT NULL,\n" +
                "    precipitacaoMensal DECIMAL(4,2) NOT NULL,\n" +
                "    fkEmpresa INT,\n" +
                "    CONSTRAINT fk_empresa FOREIGN KEY (fkEmpresa) REFERENCES empresa(idEmpresa)\n" +
                ") AUTO_INCREMENT = 100;";
        return sql;
    }
}
