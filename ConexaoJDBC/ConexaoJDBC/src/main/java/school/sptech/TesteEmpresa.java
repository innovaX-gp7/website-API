package school.sptech;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteEmpresa {

    public static void main(String[] args) {
        // Inicializando a conexão com o banco
        Conexao conexao = new Conexao();

        // Criando Objeto para ser usado posteriormente
        JdbcTemplate con = conexao.getConexaoDoBanco();

        // Dropando tabela toda vez que executar o código
        con.execute("DROP TABLE IF EXISTS teste");

        // Executando uma consulta de exemplo
        String sql = "CREATE TABLE IF NOT EXISTS teste ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(100), "
                + "endereco VARCHAR(255))";

        // Usando o método execute com a consulta SQL
        con.execute(sql);

        System.out.println("Tabela criada com sucesso!");

        con.execute("INSERT INTO empresa (nome, email, cnpj, senha)\n" +
                "VALUES ('Nome da Empresa', 'email@empresa.com', '12345678000195', 'senhaSegura123');\n");
        System.out.println("Insert realizado com sucesso");
    }
}
