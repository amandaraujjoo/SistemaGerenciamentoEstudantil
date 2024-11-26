package gerenciamentoEstudantil; // Declara o pacote ao qual a classe GerenciadorDeArquivos pertence

import java.io.*; // Importa classes para manipulação de arquivos e entrada/saída.
import java.util.*; // Importa classes utilitárias, como List e ArrayList.

public class GerenciadorDeArquivos { // Define a classe responsável pelo gerenciamento de arquivos.

    // Constantes para os nomes dos arquivos onde os dados serão armazenados.
    private static final String ARQUIVO_ALUNOS = "alunos.txt"; // Nome do arquivo para armazenar dados dos alunos.
    private static final String ARQUIVO_PROFESSORES = "professores.txt"; // Nome do arquivo para armazenar dados dos professores.
    private static final String ARQUIVO_CURSOS = "cursos.txt"; // Nome do arquivo para armazenar dados dos cursos.

    // Método para salvar um estudante no arquivo.
    public void salvarAluno(Estudante estudante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ALUNOS, true))) {
            // Escreve as informações do estudante no arquivo, separando os campos por vírgulas.
            writer.write(estudante.getNome() + "," + estudante.getIdade() + "," + estudante.getMatricula());
            writer.newLine(); // Adiciona uma nova linha após os dados.
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para atualizar os dados de um estudante no arquivo.
    public void atualizarAluno(Estudante estudante) {
        // Carrega todos os estudantes para a memória.
        List<Estudante> alunos = carregarAlunos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ALUNOS))) {
            for (Estudante a : alunos) {
                if (a.getMatricula().equals(estudante.getMatricula())) {
                    // Se a matrícula corresponder, escreve os dados atualizados.
                    writer.write(estudante.getNome() + "," + estudante.getIdade() + "," + estudante.getMatricula());
                } else {
                    // Caso contrário, escreve os dados existentes.
                    writer.write(a.getNome() + "," + a.getIdade() + "," + a.getMatricula());
                }
                writer.newLine(); // Adiciona uma nova linha após os dados.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para salvar um professor no arquivo.
    public void salvarProfessor(Professor professor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PROFESSORES, true))) {
            // Escreve as informações do professor no arquivo.
            writer.write(professor.getNome() + "," + professor.getEspecialidade());
            writer.newLine(); // Adiciona uma nova linha após os dados.
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para atualizar os dados de um professor no arquivo.
    public void atualizarProfessor(Professor professor) {
        // Carrega todos os professores para a memória.
        List<Professor> professores = carregarProfessores();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PROFESSORES))) {
            for (Professor p : professores) {
                if (p.getNome().equals(professor.getNome())) {
                    // Se o nome corresponder, escreve os dados atualizados.
                    writer.write(professor.getNome() + "," + professor.getEspecialidade());
                } else {
                    // Caso contrário, escreve os dados existentes.
                    writer.write(p.getNome() + "," + p.getEspecialidade());
                }
                writer.newLine(); // Adiciona uma nova linha após os dados.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para salvar um curso no arquivo.
    public void salvarCurso(Curso curso) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CURSOS, true))) {
            // Escreve as informações do curso no arquivo.
            writer.write(curso.getNomeCurso() + "," + curso.getCargaHoraria() + "," + curso.getDescricao());
            writer.newLine(); // Adiciona uma nova linha após os dados.
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para atualizar os dados de um curso no arquivo.
    public void atualizarCurso(Curso curso) {
        // Carrega todos os cursos para a memória.
        List<Curso> cursos = carregarCursos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CURSOS))) {
            for (Curso c : cursos) {
                if (c.getNomeCurso().equals(curso.getNomeCurso())) {
                    // Se o nome do curso corresponder, escreve os dados atualizados.
                    writer.write(curso.getNomeCurso() + "," + curso.getCargaHoraria() + "," + curso.getDescricao());
                } else {
                    // Caso contrário, escreve os dados existentes.
                    writer.write(c.getNomeCurso() + "," + c.getCargaHoraria() + "," + c.getDescricao());
                }
                writer.newLine(); // Adiciona uma nova linha após os dados.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na escrita do arquivo.
        }
    }

    // Método para carregar estudantes do arquivo para uma lista.
    public List<Estudante> carregarAlunos() {
        List<Estudante> alunos = new ArrayList<>(); // Cria uma lista para armazenar os estudantes.
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ALUNOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em partes e cria um objeto Estudante.
                String[] dados = linha.split(",");
                Estudante estudante = new Estudante(dados[0], Integer.parseInt(dados[1]), dados[2]);
                alunos.add(estudante); // Adiciona o estudante à lista.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na leitura do arquivo.
        }
        return alunos; // Retorna a lista de estudantes.
    }

    // Método para carregar professores do arquivo para uma lista.
    public List<Professor> carregarProfessores() {
        List<Professor> professores = new ArrayList<>(); // Cria uma lista para armazenar os professores.
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PROFESSORES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em partes e cria um objeto Professor.
                String[] dados = linha.split(",");
                Professor professor = new Professor(dados[0], dados[1]);
                professores.add(professor); // Adiciona o professor à lista.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na leitura do arquivo.
        }
        return professores; // Retorna a lista de professores.
    }

    // Método para carregar cursos do arquivo para uma lista.
    public List<Curso> carregarCursos() {
        List<Curso> cursos = new ArrayList<>(); // Cria uma lista para armazenar os cursos.
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CURSOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em partes e cria um objeto Curso.
                String[] dados = linha.split(",");
                Curso curso = new Curso(dados[0], Integer.parseInt(dados[1]), dados[2]);
                cursos.add(curso); // Adiciona o curso à lista.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe o erro caso ocorra uma falha na leitura do arquivo.
        }
        return cursos; // Retorna a lista de cursos.
    }
}
