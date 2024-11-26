package gerenciamentoEstudantil; // Declara o pacote ao qual a classe Curso pertence.

import java.util.*; // Importa classes da biblioteca java.util, incluindo List e ArrayList.

public class Curso { // Define uma classe pública chamada Curso.

    // Declaração dos atributos privados da classe (encapsulamento).

    private String nomeCurso; // Variável para armazenar o nome do curso.
    private int cargaHoraria; // Variável para armazenar a carga horária do curso.
    private String descricao; // Variável para armazenar uma breve descrição do curso.
    private List<Professor> professoresAssociados; // Lista para armazenar objetos da classe Professor associados ao curso.
    private List<Estudante> estudantesMatriculados; // Lista para armazenar objetos da classe Estudante matriculados no curso.

    // Construtor da classe Curso, usado para inicializar os atributos ao criar um objeto.
    public Curso(String nomeCurso, int cargaHoraria, String descricao) {
        this.nomeCurso = nomeCurso; // Inicializa o nome do curso com o valor passado como parâmetro.
        this.cargaHoraria = cargaHoraria; // Inicializa a carga horária com o valor passado como parâmetro.
        this.descricao = descricao; // Inicializa a descrição com o valor passado como parâmetro.
        this.professoresAssociados = new ArrayList<>(); // Inicializa a lista de professores associados como uma nova lista vazia.
        this.estudantesMatriculados = new ArrayList<>(); // Inicializa a lista de estudantes matriculados como uma nova lista vazia.
    }

    // Métodos getters e setters para acessar e modificar os atributos privados.
    public String getNomeCurso() { 
        return nomeCurso; // Retorna o nome do curso.
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso; // Define o nome do curso com o valor fornecido.
    }

    public int getCargaHoraria() {
        return cargaHoraria; // Retorna a carga horária do curso.
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria; // Define a carga horária do curso com o valor fornecido.
    }

    public String getDescricao() {
        return descricao; // Retorna a descrição do curso.
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao; // Define a descrição do curso com o valor fornecido.
    }

    public List<Professor> getProfessoresAssociados() {
        return professoresAssociados; // Retorna a lista de professores associados ao curso.
    }

    // Método para adicionar um professor à lista de professores associados ao curso.
    public void adicionarProfessor(Professor professor) {
        this.professoresAssociados.add(professor); // Adiciona o objeto Professor fornecido à lista.
    }

    // Método para adicionar um estudante à lista de estudantes matriculados no curso.
    public void adicionarEstudante(Estudante estudante) {
        this.estudantesMatriculados.add(estudante); // Adiciona o objeto Estudante fornecido à lista.
    }

    // Método para obter a lista de estudantes matriculados no curso.
    public List<Estudante> getEstudantesMatriculados() {
        return estudantesMatriculados; // Retorna a lista de estudantes matriculados.
    }
}
