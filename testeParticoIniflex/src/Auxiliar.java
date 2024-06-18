import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Auxiliar {
    public List<Funcionario> inserirDados() {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 15), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Luana", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Operador"));

        return funcionarios;
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(new Locale("pt", "BR"));
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);

        funcionarios.forEach(f -> {
            System.out.println("Nome: "+f.getNome());
            System.out.println("Data de nascimento: "+f.getDataNascimento().format(formatter));
            System.out.println("Função: "+f.getFuncao());
            System.out.println("Salário: R$"+nf.format(f.getSalario()));
        });
    }

    public void aumentarSalario10Porcento(List<Funcionario> funcionarios) {
        funcionarios.forEach(funcionario -> {
            BigDecimal salarioNovo = funcionario.getSalario().multiply(new BigDecimal("1.1"));
            funcionario.setSalario(salarioNovo);
        });
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirFuncionariosAgrupados(Map<String, List<Funcionario>> funcionariosAgrupados) {
        System.out.println("\n\nFuncionários agrupados por função:");
        funcionariosAgrupados.forEach((funcao, lista) -> {
            System.out.println(funcao + ": ");
            imprimirFuncionarios(lista);
        });
    }

    public void imprimirMes10E12(List<Funcionario> funcionarios) {
        int[] meses = {10, 12};
        List<Funcionario> funcionariosFiltrados = funcionarios.stream()
                .filter(funcionario -> Arrays.stream(meses).anyMatch(mes -> funcionario.getDataNascimento().getMonthValue() == mes)).toList();

        System.out.println("\n\nFuncionários que fazem aniversário nos meses 10 e 12:");
        imprimirFuncionarios(funcionariosFiltrados);
    }

    public void funcionarioMaiorIdade(List<Funcionario> funcionarios) {
        System.out.println("\n\nFuncionário mais velho:");
        Funcionario funcionario = funcionarios.stream().min(Comparator.comparing(Funcionario::getDataNascimento)).orElse(null);
        if (funcionario != null) {
            int idade = LocalDate.now().getYear() - funcionario.getDataNascimento().getYear();
            System.out.println("Nome: "+ funcionario.getNome());
            System.out.println("Idade: "+ idade);
        }
    }

    public void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("\nFuncionários em ordem alfabética:");

        List<Funcionario> funcionariosOrdem = funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).toList();
        imprimirFuncionarios(funcionariosOrdem);
    }

}