package gerenciamentoEstudantil; // Declara o pacote ao qual a classe Estudante pertence

import java.util.*; // Importa classes da biblioteca java.util, incluindo List e ArrayList.

public class Estudante { // Define uma classe pública chamada Estudante.

    // Declaração dos atributos privados da classe (encapsulamento).

    private String nome; // Variável para armazenar o nome do estudante.
    private int idade; // Variável para armazenar a idade do estudante.
    private String matricula; // Variável para armazenar o número de matrícula do estudante.
    private List<Curso> cursosMatriculados; // Lista para armazenar objetos da classe Curso em que o estudante está matriculado.

    // Construtor da classe Estudante, usado para inicializar os atributos ao criar um objeto.
    public Estudante(String nome, int idade, String matricula) {
        this.nome = nome; // Inicializa o nome do estudante com o valor passado como parâmetro.
        this.idade = idade; // Inicializa a idade do estudante com o valor passado como parâmetro.
        this.matricula = matricula; // Inicializa a matrícula do estudante com o valor passado como parâmetro.
        this.cursosMatriculados = new ArrayList<>(); // Inicializa a lista de cursos matriculados como uma nova lista vazia.
    }

    // Métodos getters e setters para acessar e modificar os atributos privados.
    public String getNome() {
        return nome; // Retorna o nome do estudante.
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do estudante com o valor fornecido.
    }

    public int getIdade() {
        return idade; // Retorna a idade do estudante.
    }

    public void setIdade(int idade) {
        this.idade = idade; // Define a idade do estudante com o valor fornecido.
    }

    public String getMatricula() {
        return matricula; // Retorna a matrícula do estudante.
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados; // Retorna a lista de cursos em que o estudante está matriculado.
    }

    // Método para matricular o estudante em um curso.
    public void matricularCurso(Curso curso) {
        this.cursosMatriculados.add(curso); // Adiciona o objeto Curso fornecido à lista de cursos matriculados.
    }
}
