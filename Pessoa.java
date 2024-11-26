package gerenciamentoEstudantil; // Define o pacote onde essa classe se encontra

public abstract class Pessoa { // Declara uma classe abstrata chamada Pessoa, que servirá como base para outras classes (como Aluno e Professor).

    private String nome; // Declara um atributo privado para armazenar o nome da pessoa.
    private int idade; // Declara um atributo privado para armazenar a idade da pessoa.

    // Construtor da classe Pessoa
    public Pessoa(String nome, int idade) {
        // Inicializa os atributos da classe com os valores passados como parâmetros.
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos getters e setters para acessar e modificar os atributos
    public String getNome() {
        return nome; // Retorna o valor do atributo nome.
    }

    public void setNome(String nome) {
        this.nome = nome; // Atribui um novo valor ao atributo nome.
    }

    public int getIdade() {
        return idade; // Retorna o valor do atributo idade.
    }

    public void setIdade(int idade) {
        this.idade = idade; // Atribui um novo valor ao atributo idade.
    }

    // Método abstrato para exibir os dados da pessoa
    public abstract void exibirDados();
    // Esse método não tem implementação aqui, pois cada classe que herdar de Pessoa
    // deverá implementar sua própria versão de como exibir os dados.
}
