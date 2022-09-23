public class Main {
    public static void main(String[] args) {
        //testes
        //criando uma lista
        ListaDuplamenteEncadeada<Aluno> lista = new ListaDuplamenteEncadeada<>();
        //criando alunos
        Aluno a1 = new Aluno("Joao", 20);
        Aluno a2 = new Aluno("Maria", 21);
        Aluno a3 = new Aluno("Pedro", 22);
        Aluno a4 = new Aluno("Ana", 23);
        //adicionando alunos na lista
        lista.adicionaInicio(a1);
        lista.adicionaInicio(a2);
        lista.adicionaFim(a3);
        lista.adicionaFim(a4);

        //imprimindo a lista
        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.println("===================================");

        lista.testaCelula();


        //removendo um elemento da lista
        lista.remove(2);
        lista.removeInicio();
        lista.removeFim();

        //imprimindo a lista
        System.out.println("Tamanho da lista apos remover: " + lista.tamanho());
        System.out.println("===================================");

        lista.testaCelula();



    }
}