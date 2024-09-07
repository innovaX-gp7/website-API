package sptech.school;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String nome = "Carolina Pasquali";

        System.out.println("\nOlá " + nome + ", o que você deseja fazer?");
        Scanner leitor = new Scanner(System.in);

        System.out.println("""
                \n**SISTEMA GREENPEACE**
                1 - Adicionar novo usuário
                2 - Editar permissões do usuário
                3 - Remover usuário
                4 - Listar usuários
                5 - Sair
                """);
        Integer opcao = leitor.nextInt();

        List<String> Colaborador = new ArrayList<>();
        List<String> horarioCadastro = new ArrayList<>();

        while (!opcao.equals(5)) {

            var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            var horaDataAtual = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            var horaDataAtualFormatada = formatador.format(horaDataAtual);


            if (opcao.equals(1)) {

                System.out.println("Digite o nome do colaborador: ");
                leitor = new Scanner(System.in);
                String nomeColaborador = leitor.nextLine();

                Colaborador.add(nomeColaborador);

                System.out.println("Parabéns, você adicionou " + nomeColaborador + " com sucesso!");
                System.out.println("Alteração feita em: " + horaDataAtualFormatada);

                horarioCadastro.add(horaDataAtualFormatada);

            } else if (opcao.equals(2)) {
                if (Colaborador.equals(List.of())) {
                    System.err.println("Impossível solicitar o comando, você não tem nenhum colaborador.");
                } else {
                    System.out.println("Qual colaborador você quer alterar a permissão? Digite a posição da lista");
                    System.out.println(Colaborador);
                    leitor = new Scanner(System.in);
                    Integer posicaoColaboradorLista = leitor.nextInt();

                    String nomeColaboradorLista = Colaborador.get(posicaoColaboradorLista - 1);

                    System.out.println("\nVocê deseja alterar o colaborador " + nomeColaboradorLista + ", que está com permissão TOTAL do sistema Greenpeace" +
                            ". Qual opção você deseja selecionar?\n1-Apenas Leitura\n2-Leitura e Escrita\n3-Leitura, Escrita e Execução (TOTAL)");
                    leitor = new Scanner(System.in);
                    Integer permissaoColaborador = leitor.nextInt();

                    if (permissaoColaborador.equals(1) || permissaoColaborador.equals(2) || permissaoColaborador.equals(3)) {
                        System.out.println("Alteração feita em: " + horaDataAtualFormatada);
                    } else {
                        System.err.println("Permissão não identificada. Pressione o número certo.");
                    }
                }
            } else if (opcao.equals(3)) {
                if (Colaborador.equals(List.of())) {
                    System.err.println("Impossível solicitar o comando, você não tem nenhum colaborador.");
                } else {
                    System.out.println("Qual colaborador você quer remover? Digite o nome dele(a).");
                    System.out.println(Colaborador);
                    leitor = new Scanner(System.in);
                    String nomeColaboradorParaRemover = leitor.nextLine();

                    for (int i = 0; i < Colaborador.size(); i++) {
                        if (nomeColaboradorParaRemover.equals(Colaborador.get(i))) {
                            Colaborador.remove(nomeColaboradorParaRemover);
                            horarioCadastro.remove(i);
                        }
                    }

                    System.out.println("Alteração feita em: " + horaDataAtualFormatada);
                }
            } else if (opcao.equals(4)) {
                System.out.println(Colaborador);
                System.out.println(horarioCadastro);
            }

            Thread.sleep(2000);
            System.out.println("""
                    \n**SISTEMA GREENPEACE**
                    1 - Adicionar novo usuário
                    2 - Editar permissões do usuário
                    3 - Remover usuário
                    4 - Listar usuários
                    5 - Sair
                    """);
            opcao = leitor.nextInt();
        }


//        /*
//         * Também é possível trabalhar com timezone utilizando a classe
//         * ZonedDateTime. Esta classe representa uma data e hora, com timezone.
//         * O método estático now() retorna a data e hora atual. O timezone
//         * utilizado é o timezone padrão do sistema operacional.
//         */
//        ZonedDateTime dataHoraAtual = ZonedDateTime.now();
//        System.out.println(dataHoraAtual.toString().replaceAll("T", " "));
//
//        /*
//         * Para criar uma data e hora específica, devemos utilizar o método
//         * estático of() da classe ZonedDateTime. Este método recebe sete
//         * parâmetros: ano, mês, dia, hora, minuto, segundo e timezone.
//         * O timezone deve ser informado utilizando a classe ZoneId.
//         */
//        var timezone = ZoneId.of("America/Manaus");
//        var dataHoraEspecifica = ZonedDateTime.of(2019, 10, 10, 10, 10, 10, 0, timezone);
//        System.out.println(dataHoraEspecifica);
//
//        /*
//         * Podemos converter uma data e hora de um timezone para outro utilizando
//         * o método withZoneSameInstant().
//         */
//        var dataHoraAlterada = dataHoraEspecifica.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
//        System.out.println(dataHoraAlterada);
//
//        /*
//         * Podemos obter o timezone do sistema utilizando o método estático
//         * systemDefault() da classe ZoneId.
//         */
//        var timezoneSistema = ZoneId.systemDefault();
//        System.out.println(timezoneSistema);

    }
}
