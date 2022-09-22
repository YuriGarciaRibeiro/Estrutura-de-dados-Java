public class Main {
    public static void main(String[] args) {
        //vetor de alunos
        Vetor<Integer> vetor = new Vetor<Integer>(5);
        //alunos
        Aluno a1 = new Aluno("Joao", 20);
        Aluno a2 = new Aluno("Maria", 19);
        Aluno a3 = new Aluno("Pedro", 18);
        Aluno a4 = new Aluno("Ana", 17);
        Aluno a5 = new Aluno("Jose", 16);
        //adicionando alunos no vetor
        vetor.adicionarInicio(1);
        vetor.adicionarInicio(2);
        vetor.adicionarFinal(3);
        vetor.adicionarFinal(4);
        vetor.inserir(5, 78);




        //imprimindo vetor
        System.out.println("=============================");
        vetor.imprimir();

        //imprimindo os dados do aluno



    }
}