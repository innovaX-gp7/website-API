package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class Funcionario {

    // Cria uma conexão com o banco de dados e obtém um objeto `JdbcTemplate` para interagir com ele.
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    private Integer idFuncionario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    // Criando construtor vazio
    public Funcionario() {
    }

    // Criando construtor com parâmetros


    public Funcionario(Conexao conexao, JdbcTemplate con, Integer idFuncionario, String nome, String cpf, String email, String senha) {
        this.conexao = conexao;
        this.con = con;
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String criarTabelaFuncionario() {
        String sql = """
                CREATE TABLE IF NOT EXISTS funcionario(
                    idFuncionario INT NOT NULL AUTO_INCREMENT,
                    nome VARCHAR(50) NOT NULL,
                    cpf VARCHAR(11) DEFAULT NULL,
                    email VARCHAR(45) NOT NULL,
                    senha VARCHAR(45) NOT NULL,
                    PRIMARY KEY (idFuncionario),
                    UNIQUE KEY email (email),
                    UNIQUE KEY cpf (cpf),
                    fkEmpresaFuncio INT,
                    CONSTRAINT fk_empresa_funcio FOREIGN KEY (fkEmpresaFuncio) REFERENCES empresa(idEmpresa)
                ) AUTO_INCREMENT = 10;""";
        return sql;
    }


}
