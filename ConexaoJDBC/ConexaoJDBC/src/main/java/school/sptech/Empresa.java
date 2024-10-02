package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class Empresa {

    private Integer id;
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
    public Empresa(Integer id, String nome, String email, String cnpj, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }


    // Criando metódo para criar a tabela no Banco
    public String criarTabelaEmpresa(){
        String sql = "CREATE TABLE IF NOT EXISTS empresa (\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "nome VARCHAR(50) NOT NULL,\n" +
                "email VARCHAR(45) NOT NULL,\n" +
                "cnpj VARCHAR(14) DEFAULT NULL,\n" +
                "senha VARCHAR(45) NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "UNIQUE KEY email (email),\n" +
                "UNIQUE KEY cnpj (cnpj)\n" +
                ");";
        return sql;
    }
}
