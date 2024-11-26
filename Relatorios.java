package gerenciamentoEstudantil; // Define o pacote onde esta classe está localizada

import java.util.*; // Importa a biblioteca para uso de listas e outras coleções

public class Relatorios { // Declaração da classe Relatorios

    private List<Estudante> estudantes; // Lista privada para armazenar estudantes
    private List<Professor> professores; // Lista privada  para armazenar professores
    private List<Curso> cursos; // Lista privada para armazenar cursos

    // Construtor da classe Relatorios
    public Relatorios(List<Estudante> estudantes, List<Professor> professores, List<Curso> cursos) {
        this.estudantes = estudantes; // Inicializa a lista de estudantes
        this.professores = professores; // Inicializa a lista de professores
        this.cursos = cursos; // Inicializa a lista de cursos
    }

    // Método para gerar o relatório de estudantes
    public void gerarRelatorioEstudantes() {
        for (Estudante estudante : estudantes) { // Itera por cada estudante na lista
            System.out.println("Estudante: " + estudante.getNome()); // Exibe o nome do estudante
            System.out.println("Matrícula: " + estudante.getMatricula()); // Exibe a matrícula do estudante

            // Verifica se o estudante está matriculado em algum curso
            if (estudante.getCursosMatriculados().isEmpty()) {
                System.out.println("Cursos matriculados: Nenhum curso matriculado."); // Caso não tenha cursos, exibe mensagem
            } else {
                System.out.println("Cursos matriculados:"); // Caso tenha, exibe os cursos
                for (Curso curso : estudante.getCursosMatriculados()) { // Itera pelos cursos do estudante
                    System.out.println("  - " + curso.getNomeCurso()); // Exibe o nome do curso
                }
            }
            System.out.println(); // Adiciona uma linha em branco para separar os registros
        }
    }

    // Método para gerar o relatório de professores
    public void gerarRelatorioProfessores() {
        for (Professor professor : professores) { // Itera por cada professor na lista
            System.out.println("Professor: " + professor.getNome()); // Exibe o nome do professor
            System.out.println("Especialidade: " + professor.getEspecialidade()); // Exibe a especialidade do professor
            System.out.println("Cursos associados:"); // Exibe os cursos associados ao professor

            for (Curso curso : professor.getCursosAssociados()) { // Itera pelos cursos associados ao professor
                System.out.println("  - " + curso.getNomeCurso()); // Exibe o nome do curso
            }
            System.out.println(); // Adiciona uma linha em branco para separar os registros
        }
    }

    // Método para gerar o relatório de cursos
    public void gerarRelatorioCursos() {
        for (Curso curso : cursos) { // Itera por cada curso na lista
            System.out.println("Curso: " + curso.getNomeCurso()); // Exibe o nome do curso
            System.out.println("Descrição: " + curso.getDescricao()); // Exibe a descrição do curso
            System.out.println("Carga Horária: " + curso.getCargaHoraria()); // Exibe a carga horária do curso

            System.out.println("Professores associados:"); // Exibe os professores associados ao curso
            if (curso.getProfessoresAssociados().isEmpty()) { // Verifica se há professores associados
                System.out.println("  Nenhum professor associado."); // Caso não tenha, exibe mensagem
            } else {
                for (Professor professor : curso.getProfessoresAssociados()) { // Itera pelos professores associados ao curso
                    System.out.println("  - " + professor.getNome()); // Exibe o nome do professor
                }
            }
            System.out.println(); // Adiciona uma linha em branco para separar os registros
        }
    }
}
