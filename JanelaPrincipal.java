package gerenciamentoEstudantil; // Declaração do pacote onde esta classe está inserida

// Importação das bibliotecas necessárias
import java.util.*; // Biblioteca para criar interfaces gráficas (GUI)
import javax.swing.*; // Biblioteca para trabalhar com coleções como List, ArrayList.

public class JanelaPrincipal { // Declaração da classe principal JanelaPrincipal

    // Declaração dos atributos da classe
    private JFrame frame; // Componente principal da janela
    private List<Estudante> estudantes; // Lista para armazenar objetos do tipo Estudante
    private List<Professor> professores; // Lista para armazenar objetos do tipo Professor
    private List<Curso> cursos; // Lista para armazenar objetos do tipo Curso
    private GerenciadorDeArquivos gerenciadorDeArquivos; // Objeto para manipular arquivos
    private Relatorios relatorios; // Objeto para gerar relatórios

    // Construtor da classe JanelaPrincipal
    public JanelaPrincipal() {
        // Inicialização das listas como ArrayLists
        this.estudantes = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.gerenciadorDeArquivos = new GerenciadorDeArquivos(); // Instanciação do GerenciadorDeArquivos
        this.relatorios = new Relatorios(estudantes, professores, cursos); // Instanciação do objeto Relatorios, passando as listas para ele
        inicializar(); // Chamada do método inicializar para configurar a interface gráfica
    }

    // Método para configurar e exibir a janela principal
    private void inicializar() {
        // Criação e configuração do JFrame (janela)
        frame = new JFrame("Sistema de Gerenciamento Estudantil"); // Título da janela
        frame.setSize(400, 300); // Definição do tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamento ao fechar a janela

        // Criação da barra de menus
        JMenuBar menuBar = new JMenuBar();

        // Criação do menu "Aluno" e seus itens
        JMenu menuAluno = new JMenu("Aluno"); // Menu principal "Aluno"
        JMenuItem cadastrarAlunoItem = new JMenuItem("Cadastrar Aluno"); // Item para cadastrar alunos
        JMenuItem consultarAlunoItem = new JMenuItem("Consultar Aluno"); // Item para consultar alunos
        JMenuItem sairAlunoItem = new JMenuItem("Sair"); // Item para sair do sistema

         // Adição de ações aos itens do menu "Aluno"
        cadastrarAlunoItem.addActionListener(e -> menuAluno()); // Ação para abrir o menu de cadastro de aluno
        consultarAlunoItem.addActionListener(e -> consultarAluno()); // Ação para consultar alunos
        sairAlunoItem.addActionListener(e -> frame.dispose()); // Ação para fechar a janela principal

        // Adiciona os itens ao menu "Aluno"
        menuAluno.add(cadastrarAlunoItem);
        menuAluno.add(consultarAlunoItem);
        menuAluno.add(sairAlunoItem);

         // Menu "Professor" com seus itens e ações
        JMenu menuProfessor = new JMenu("Professor"); // Menu principal "Professor"
        JMenuItem cadastrarProfessorItem = new JMenuItem("Cadastrar Professor"); // Item para cadastrar professor
        JMenuItem consultarProfessorItem = new JMenuItem("Consultar Professor"); // Item para consultar professor
        JMenuItem sairProfessorItem = new JMenuItem("Sair"); // Item para sair do sistema

        cadastrarProfessorItem.addActionListener(e -> menuProfessor()); // Ação para abrir o menu de cadastro de professor
        consultarProfessorItem.addActionListener(e -> consultarProfessor()); // Ação para consultar professor
        sairProfessorItem.addActionListener(e -> frame.dispose()); // Ação para fechar a janela principal

        // Adiciona os itens ao menu "Professor"
        menuProfessor.add(cadastrarProfessorItem);
        menuProfessor.add(consultarProfessorItem);
        menuProfessor.add(sairProfessorItem);

         // Menu "Curso" com seus itens e ações
        JMenu menuCurso = new JMenu("Curso"); // Menu principal "Curso"
        JMenuItem cadastrarCursoItem = new JMenuItem("Cadastrar Curso"); // Item para cadastrar curso
        JMenuItem consultarCursoItem = new JMenuItem("Consultar Curso"); // Item para consultar curso
        JMenuItem vincularCursoItem = new JMenuItem("Vincular Cursos"); // Item para vincular curso
        JMenuItem gerarRelatoriosItem = new JMenuItem("Gerar Relatórios"); // Item para gerar relatorio 
        JMenuItem sairCursoItem = new JMenuItem("Sair"); // Item para sair do sistema

        cadastrarCursoItem.addActionListener(e -> menuCurso()); // Ação para abrir o menu de cadastro de curso
        consultarCursoItem.addActionListener(e -> consultarCurso()); // Ação para consultar curso
        vincularCursoItem.addActionListener(e -> vincularCurso()); // Ação para consultar curso vinculado
        gerarRelatoriosItem.addActionListener(e -> gerarRelatorios()); // Ação para consultar relatorio
        sairCursoItem.addActionListener(e -> frame.dispose()); // Ação para fechar a janela principal

         // Adiciona os itens ao menu "Curso"
        menuCurso.add(cadastrarCursoItem);
        menuCurso.add(consultarCursoItem);
        menuCurso.add(vincularCursoItem);
        menuCurso.add(gerarRelatoriosItem);
        menuCurso.add(sairCursoItem);

         // Adiciona os menus à barra de menus
        menuBar.add(menuAluno);
        menuBar.add(menuProfessor);
        menuBar.add(menuCurso);

        frame.setJMenuBar(menuBar); // Configura a barra de menus no JFrame
        frame.setVisible(true); // Torna a janela visível
    }

    // Método para o menu de Aluno
    private void menuAluno() {
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome do aluno:");  // Solicita o nome do aluno
        int idade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite a idade do aluno:"));  // Solicita a idade e converte para inteiro
        String matricula = JOptionPane.showInputDialog(frame, "Digite a matrícula do aluno:"); // Solicita a matrícula do aluno

        // Cria um objeto Estudante com os dados inseridos
        Estudante aluno = new Estudante(nome, idade, matricula);
        estudantes.add(aluno); // Adiciona o aluno à lista de estudantes
        gerenciadorDeArquivos.salvarAluno(aluno); // Salva o aluno no arquivo

        JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!"); // Exibe mensagem de sucesso
    }

    // Método para consultar um aluno
    private void consultarAluno() {
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome ou matrícula do aluno:"); // Solicita o nome ou matrícula do aluno a ser consultado

        // Percorre a lista de estudantes para encontrar o aluno correspondente
        for (Estudante aluno : estudantes) {
            if (aluno.getNome().equalsIgnoreCase(nome) || aluno.getMatricula().equalsIgnoreCase(nome)) {
                String novaIdade = JOptionPane.showInputDialog(frame, "Aluno encontrado. Atualizar idade: "); // Solicita nova idade para atualizar
                aluno.setIdade(Integer.parseInt(novaIdade)); // Atualiza a idade do aluno
                JOptionPane.showMessageDialog(frame, "Aluno atualizado com sucesso!");
                gerenciadorDeArquivos.atualizarAluno(aluno); // Atualiza o arquivo
                return;
            }
        }
         // Exibe mensagem caso o aluno não seja encontrado
        JOptionPane.showMessageDialog(frame, "Aluno não encontrado.");
    }

    // Método para o menu de Professor
    private void menuProfessor() {
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome do professor:"); // Solicita o nome do professor
        String especialidade = JOptionPane.showInputDialog(frame, "Digite a especialidade do professor:"); // Solicita a especialidade do professor

        Professor professor = new Professor(nome, especialidade); // Cria um objeto Professor com os dados inseridos
        professores.add(professor);  // Adiciona o professor à lista de professores
        gerenciadorDeArquivos.salvarProfessor(professor); // Salva o professor no arquivo

        JOptionPane.showMessageDialog(frame, "Professor cadastrado com sucesso!"); // Exibe mensagem de sucesso
    }

    // Método para consultar um professor
    private void consultarProfessor() {
        // Solicita o nome ou a especialidade do professor a ser consultado
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome ou especialidade do professor:"); 

        // Percorre a lista de professores para encontrar o professor correspondente
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome) || professor.getEspecialidade().equalsIgnoreCase(nome)) {
                // Solicita nova especialidade para atualizar
                String novaEspecialidade = JOptionPane.showInputDialog(frame, "Professor encontrado. Atualizar especialidade: ");
                professor.setEspecialidade(novaEspecialidade); // Atualiza a especialidade do professor
                JOptionPane.showMessageDialog(frame, "Professor atualizado com sucesso!");
                gerenciadorDeArquivos.atualizarProfessor(professor); // Atualiza o arquivo
                return;
            }
        }
        // Exibe mensagem caso o professor não seja encontrado
        JOptionPane.showMessageDialog(frame, "Professor não encontrado.");
    }

 // Método para o menu de Curso
    private void menuCurso() {
        String nomeCurso = JOptionPane.showInputDialog(frame, "Digite o nome do curso:"); // Solicita o nome do curso
        int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite a carga horária do curso:"));  // Solicita a carga horária do curso e converte para inteiro
        String descricao = JOptionPane.showInputDialog(frame, "Digite a descrição do curso:"); // Solicita a descrição do curso

        // Cria um objeto Curso com os dados inseridos
        Curso curso = new Curso(nomeCurso, cargaHoraria, descricao);
        cursos.add(curso); // Adiciona o curso à lista de cursos
        gerenciadorDeArquivos.salvarCurso(curso); // Salva o curso no arquivo

        // Solicita o nome do professor para associar ao curso
        String nomeProfessor = JOptionPane.showInputDialog(frame, "Digite o nome do professor para associar ao curso:");
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                // Associa o professor ao curso
                curso.adicionarProfessor(professor); // Associa o professor ao curso
                JOptionPane.showMessageDialog(frame, "Professor associado ao curso com sucesso!");
                return;
            }
        }
         // Caso o professor não seja encontrado, exibe mensagem
        JOptionPane.showMessageDialog(frame, "Professor não encontrado.");
        JOptionPane.showMessageDialog(frame, "Curso cadastrado com sucesso!");
    }


    // Método para consultar um curso
    private void consultarCurso() {
        String nomeCurso = JOptionPane.showInputDialog(frame, "Digite o nome do curso:"); // Solicita o nome do curso a ser consultado

        // Percorre a lista de cursos para encontrar o curso correspondente
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(nomeCurso)) {
                // Solicita nova descrição para atualizar
                String novaDescricao = JOptionPane.showInputDialog(frame, "Curso encontrado. Atualizar descrição: ");
                curso.setDescricao(novaDescricao);  // Atualiza a descrição do curso
                JOptionPane.showMessageDialog(frame, "Curso atualizado com sucesso!");
                gerenciadorDeArquivos.atualizarCurso(curso); // Atualiza o arquivo
                return;
            }
        }
        // Exibe mensagem caso o curso não seja encontrado
        JOptionPane.showMessageDialog(frame, "Curso não encontrado.");
    }
    
 // Método para vincular curso aos alunos e professores
    private void vincularCurso() {
        // Implementação do vinculo entre alunos, professores e cursos
        String nomeCurso = JOptionPane.showInputDialog(frame, "Digite o nome do curso para vincular:"); // Solicita o nome do curso a ser vinculado

        // Percorre a lista de cursos para encontrar o curso correspondente
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(nomeCurso)) {
                // Solicita a matrícula do aluno para vincular ao curso
                String matriculaAluno = JOptionPane.showInputDialog(frame, "Digite a matrícula do aluno para vincular:");
                for (Estudante estudante : estudantes) {
                    if (estudante.getMatricula().equalsIgnoreCase(matriculaAluno)) {
                        curso.adicionarEstudante(estudante); // Solicita a matrícula do aluno para vincular ao curso
                        estudante.matricularCurso(curso); // Vincula o curso ao estudante
                        JOptionPane.showMessageDialog(frame, "Aluno matriculado no curso com sucesso!");
                        break;
                    }
                }

                 // Solicita o nome do professor para vincular ao curso
                String nomeProfessor = JOptionPane.showInputDialog(frame, "Digite o nome do professor para vincular:");
                for (Professor professor : professores) {
                    if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                        curso.adicionarProfessor(professor);  // Adiciona o professor ao curso
                        JOptionPane.showMessageDialog(frame, "Professor associado ao curso com sucesso!");
                        break;
                    }
                }
                return;
            }
        }
        // Exibe mensagem caso o curso não seja encontrado
        JOptionPane.showMessageDialog(frame, "Curso não encontrado.");
    }


    // Método para gerar relatórios
    private void gerarRelatorios() {
        // Solicita o tipo de relatório a ser gerado
        String relatorioTipo = JOptionPane.showInputDialog(frame, "Escolha o tipo de relatório:\n1 - Estudantes\n2 - Professores\n3 - Cursos");

         // Seleciona o tipo de relatório com base na entrada do usuário
        switch (relatorioTipo) {
            case "1":
                // Gera relatório de estudantes
                relatorios.gerarRelatorioEstudantes();
                break;
            case "2":
                // Gera relatório de professores
                relatorios.gerarRelatorioProfessores();
                break;
            case "3":
                // Gera relatório de cursos
                relatorios.gerarRelatorioCursos();
                break;
            default:
                // Exibe mensagem de opção inválida
                JOptionPane.showMessageDialog(frame, "Opção inválida.");
                break;
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        new JanelaPrincipal(); // Cria uma nova instância de JanelaPrincipal, iniciando a aplicação
    }
}

