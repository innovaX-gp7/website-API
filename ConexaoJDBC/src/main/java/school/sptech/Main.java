package school.sptech;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import school.sptech.s3.BucketController;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

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

//        View S3
        BucketController bucketController = new BucketController();
        List<Bucket> buckets = bucketController.listarBuckets();
        if (buckets == null || buckets.isEmpty()) {
            bucketController.createBucket("innovaxs3");
            return;
        }
        for (Bucket bucket : buckets) {
            List<S3Object> objects = bucketController.listarObjetos(bucket.name());
            if (objects != null) {
                bucketController.baixarObjetos(objects, bucket.name());
            }
        }

//        Tratamento de dados
        File diretorio = new File("data");
        for (File arquivo : diretorio.listFiles()) {
            System.out.println("Passou");
            Boolean arquivoTemperatura = false;
            try {
                InputStream streamArquivo = Files.newInputStream(arquivo.toPath());
                Workbook workbook = new XSSFWorkbook(streamArquivo);
                Sheet sheet = workbook.getSheetAt(0);
                if(sheet.getRow(0).getCell(0).getStringCellValue().equalsIgnoreCase("Nome")){
                    arquivoTemperatura = true;
                    System.out.println("Aquivo é de temperatura");
                }
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        if(arquivoTemperatura && row.getRowNum() == 0 && cell.getColumnIndex() == 1){
                            System.out.println(cell.getStringCellValue());
                        }
                        if(arquivoTemperatura && row.getRowNum() > 11){
                            System.out.print(cell.getStringCellValue() + ", ");
                        } else {

                        }
                    }
                    System.out.println();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}