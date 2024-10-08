package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class Empresa {

    private Integer idEmpresa;
    private String nome;
    private String email;
    private String cnpj;
    private String senha;


    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    // Criando construtor vazio
    public Empresa(){}

    // Criando construtor para inicializar os atributos acima

    public Empresa(Integer idEmpresa, String nome, String email, String cnpj, String senha, Conexao conexao, JdbcTemplate con) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.senha = senha;
        this.conexao = conexao;
        this.con = con;
    }


    // Método toString
    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    // Criando metódo para criar a tabela no Banco
    public String criarTabelaEmpresa(){
        String sql = "CREATE TABLE IF NOT EXISTS empresa (\n" +
                "idEmpresa INT NOT NULL AUTO_INCREMENT,\n" +
                "nome VARCHAR(50) NOT NULL,\n" +
                "email VARCHAR(45) NOT NULL,\n" +
                "cnpj VARCHAR(14) DEFAULT NULL,\n" +
                "senha VARCHAR(45) NOT NULL,\n" +
                "PRIMARY KEY (idEmpresa),\n" +
                "UNIQUE KEY email (email),\n" +
                "UNIQUE KEY cnpj (cnpj)\n" +
                ");";
        return sql;
    }
}
