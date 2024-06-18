import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Auxiliar auxiliar = new Auxiliar();

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela.
        List<Funcionario> funcionarios = auxiliar.inserirDados();

        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários com todas suas informações.
        auxiliar.imprimirFuncionarios(funcionarios);

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        auxiliar.aumentarSalario10Porcento(funcionarios);

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosAgrupados = auxiliar.agruparFuncionariosPorFuncao(funcionarios);

        // 3.6 – Imprimir os funcionários, agrupados por função.
        auxiliar.imprimirFuncionariosAgrupados(funcionariosAgrupados);

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        auxiliar.imprimirMes10E12(funcionarios);

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        auxiliar.funcionarioMaiorIdade(funcionarios);

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        auxiliar.imprimirOrdemAlfabetica(funcionarios);

        // 3.11 – Imprimir o total dos salários dos funcionários.
        // Não consegui implementar

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        // Não consegui implementar

    }
}