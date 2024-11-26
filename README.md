
## Sistema Gerenciamento Estudantil
Este é um sistema de Gerenciamento Estudantil desenvolvido em Java com intuito de criar uma inteface simples e dinâmica. O objetivo é gerenciar dados acadêmicos, incluindo dados de professores, alunos e cursos. O sistema aplica os conceitos de Programação Orientada a Objetos (POO) e utiliza arquivos de texto (.txt) como mecanismo de garantia a manutenção dos dados entre as execuções do programa.



## Estrutura do Sistema 
1) Tela principal - Menu
   mostrando campos Aluno, Professor e Curso.

2) Campo Aluno:
   I) Cadastrar Aluno.
   II) Consultar Aluno.
   III) Sair do Sistema.

4) Campo Professor:
   I) Cadastrar Professor.
   II) Consultar Professor.
   III) Sair do Sistema.
   
5) Campo Curso:
   I) Cadastrar Curso.
   II) Consultar Curso.
   III) Vincular Cursos
   IV) Gerar Relatórios.
   V) Sair do Sistema


## Funcionalidades Do Sistema
1) Cadastrar Aluno
- Inserir nome. 
- Inserir idade.
- Inserir matricula.

 2) Cadastrar Professor
- Inserir nome. 
- Inserir especialidade.
  
 3) Cadastrar Curso
- Inserir nome do curso.
- Inserir Carga horária.
- Inserir descrição.
- Inserir professor associado ao curso.

4) Gerar relatório: Opções para gerar relatórios referentes a:
- Alunos e seus dados
- Professores e seus dados
- Cursos e seus dados

  ## Classes do Sistema
  
Pessoa (Classe Abstrata)
- Atributos: nome, idade;
- Métodos: getters, setters e o método abstrato exibirDados().


Estudante (Subclasse de Pessoa)
- Atributo adicional: matricula;
- -Métodos: getters, setters, exibirDados(), métodos para manipulação de
dados (cadastro, edição, exclusão).


 Professor (Subclasse de Pessoa):
- Atributo adicional: especialidade.
- Métodos: getters, setters, exibirDados(), métodos para manipulação de
dados (cadastro, edição, exclusão).


 Curso:
 - Atributos: nomeCurso, cargaHoraria, professor.
- Métodos: getters, setters, métodos para manipulação de cursos e
associações.


 GerenciadorDeArquivos:
-  Métodos para leitura e escrita em arquivos texto (alunos.txt,
professores.txt, cursos.txt, vinculacoes.txt).


 Relatorios:
- Atributos: List<Estudante> estudantes; List<Professor> professores;
List<Curso> cursos; Map<Estudante, List<Curso>> matriculas;
Map<Professor, List<Curso>> associacoes.
- Métodos: gerarRelatorioEstudantes(); gerarRelatorioProfessores();

  
 JanelaPrincipal (Interface Gráfica):
o Implementa a interface gráfica com Swing, permitindo a navegação entre
os menus.


## Autor
Este projeto foi desenvolvido como parte de um trabalho acadêmico para aplicação prática dos conceitos de Programação Orientada a Objetos e Interface Gráfica em Java. Colaboradoras: Amanda Mendes, Beatriz Medina, Camila Graner e Carol Zaiatz.
