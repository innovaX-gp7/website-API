package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class Funcionario {

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    // Criando construtor vazio
    public Funcionario(){}

    // Criando construtor com parâmetros
    public Funcionario(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
    public String criarTabelaFuncionario(){
            String sql = "CREATE TABLE funcionario (\n" +
                "    id INT NOT NULL AUTO_INCREMENT,\n" +
                "    nome VARCHAR(50) NOT NULL,\n" +
                "    cpf VARCHAR(11) DEFAULT NULL,\n" +
                "    email VARCHAR(45) NOT NULL,\n" +
                "    senha VARCHAR(45) NOT NULL,\n" +
                "    PRIMARY KEY (id),\n" +
                "    UNIQUE KEY email (email),\n" +
                "    UNIQUE KEY cpf (cpf),\n" +
                "    fk_empresa_funcio INT,\n" +
                "    CONSTRAINT fk_empresa_funcio FOREIGN KEY (fk_empresa_funcio) REFERENCES empresa(id)\n" +
                ") AUTO_INCREMENT = 10;";
        return sql;
    }



}
