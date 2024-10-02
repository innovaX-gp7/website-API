package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalTime;

public class ParametrosRecomendacoes {

    // Criando atributos dos Parametros(aqui deve ser o mesmo nome que as colunas do Banco)
    private Integer id;
    private BigDecimal limiteArea;
    private LocalTime horarioNotificoes;
    private Integer fk_empresa_recom;

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando construtor vazio
    public ParametrosRecomendacoes(){}

    // Criando construtor com os parâmetros


    public ParametrosRecomendacoes(Integer id, BigDecimal limiteArea, LocalTime horarioNotificoes, Integer fk_empresa_recom, Conexao conexao, JdbcTemplate con) {
        this.id = id;
        this.limiteArea = limiteArea;
        this.horarioNotificoes = horarioNotificoes;
        this.fk_empresa_recom = fk_empresa_recom;
        this.conexao = conexao;
        this.con = con;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLimiteArea() {
        return limiteArea;
    }

    public void setLimiteArea(BigDecimal limiteArea) {
        this.limiteArea = limiteArea;
    }

    public LocalTime getHorarioNotificoes() {
        return horarioNotificoes;
    }

    public void setHorarioNotificoes(LocalTime horarioNotificoes) {
        this.horarioNotificoes = horarioNotificoes;
    }

    public Integer getFk_empresa_recom() {
        return fk_empresa_recom;
    }

    public void setFk_empresa_recom(Integer fk_empresa_recom) {
        this.fk_empresa_recom = fk_empresa_recom;
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
        return "ParametrosRecomendacoes{" +
                "id=" + id +
                ", limiteArea=" + limiteArea +
                ", horarioNotificoes=" + horarioNotificoes +
                ", fk_empresa_recom=" + fk_empresa_recom +
                ", conexao=" + conexao +
                ", con=" + con +
                '}';
    }



    public String criarTabelaParametrosRecomendacoes(){
        String sql = "Create TABLE parametrosRecomendacoes (\n" +
                "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                "limiteArea DECIMAL (4,2),\n" +
                "horarioNotificacoes TIME,\n" +
                "fk_empresa_recom INT,\n" +
                "CONSTRAINT fk_empresa_recom FOREIGN KEY (fk_empresa_recom) REFERENCES empresa(id)\n" +
                ")auto_increment=10000;";
        return sql;
    }
}
