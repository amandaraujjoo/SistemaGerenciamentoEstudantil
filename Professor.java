package gerenciamentoEstudantil; // Define o pacote do projeto

import java.util.*; // Importa a biblioteca de utilitários do Java 

public class Professor { // Declaração da classe Professor

    private String nome; // Atributo privado para armazenar o nome do professor
    private String especialidade; // Atributo privado para armazenar a especialidade do professor
    private List<Curso> cursosAssociados; // Lista privada de cursos associados ao professor

    // Construtor da classe que inicializa os atributos
    public Professor(String nome, String especialidade) {
        this.nome = nome; // Define o nome do professor
        this.especialidade = especialidade; // Define a especialidade do professor
        this.cursosAssociados = new ArrayList<>(); // Inicializa a lista de cursos associados
    }

    // Getter para o atributo nome
    public String getNome() {
        return nome; // Retorna o nome do professor
    }

    // Setter para o atributo nome
    public void setNome(String nome) {
        this.nome = nome; // Atualiza o nome do professor
    }

    // Getter para o atributo especialidade
    public String getEspecialidade() {
        return especialidade; // Retorna a especialidade do professor
    }

    // Setter para o atributo especialidade
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade; // Atualiza a especialidade do professor
    }

    // Getter para a lista de cursos associados
    public List<Curso> getCursosAssociados() {
        return cursosAssociados; // Retorna a lista de cursos associados
    }

    // Método para associar um curso ao professor
    public void associarCurso(Curso curso) {
        this.cursosAssociados.add(curso); // Adiciona um curso à lista de cursos associados
    }
}
