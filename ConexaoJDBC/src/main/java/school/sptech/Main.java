package school.sptech;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        // Inicializando a conexão com o banco
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        // Criando objetos para serem usados posteriormente
        Empresa empresa = new Empresa();
        Funcionario funcionario = new Funcionario();
        Dashboard dashboard = new Dashboard();
        ParametrosRecomendacoes parametrosRecomendacoes = new ParametrosRecomendacoes();
        RecomendacoesIA recomendacoesIA = new RecomendacoesIA();
        LogsJAR logsJAR = new LogsJAR();
        PromptIA promptIA = new PromptIA();

        try {
            // Aqui estamos tentando executar os métodos para criação de tabelas
            con.execute(empresa.criarTabelaEmpresa());
            con.execute(funcionario.criarTabelaFuncionario());
            con.execute(dashboard.criarTabelaDashboard());
            con.execute(recomendacoesIA.criarTabelaRecomendacoesIA());
            con.execute(parametrosRecomendacoes.criarTabelaParametrosRecomendacoes());
            con.execute(logsJAR.criarTabelaLogsJAR());
            con.execute(promptIA.criarTabelaPromptIA());

            System.out.println("Tabelas criadas com sucesso!");
        } catch (DataAccessException e) {
            // Esse bloco de código só será executado caso a tentativa tenha alguma exceção
            System.err.println("Erro ao criar as tabelas: " + e.getMessage());
        }

    }
}