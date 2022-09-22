public class Main {
    public static void main(String[] args) {
        //testes
        //criando uma lista
        ListaSimples<Aluno> lista = new ListaSimples<Aluno>();
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
        //imprimi tamanho da lista
        System.out.println("Tamanho da lista: " + lista.tamanho());
        //impriindo a lista
        lista.imprime();
        //verificando se a lista contem um aluno especifico
        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a2));
        System.out.println(lista.contem(a3));
        System.out.println(lista.contem(a4));
        //recuperando um aluno da lista
        System.out.println(lista.recuperaOBJ(0).getNome());
        System.out.println(lista.recuperaOBJ(1).getNome());
        System.out.println(lista.recuperaOBJ(2).getNome());
        System.out.println(lista.recuperaOBJ(3).getNome());
        //removendo um aluno da lista
        lista.remove(0);
        lista.remove(2);
        //imprime tamanho da lista
        System.out.println(lista.tamanho());
        //imprimindo a lista
        lista.imprime();
        //recuperando um aluno da lista
        System.out.println(lista.recuperaOBJ(0).getNome());
        System.out.println(lista.recuperaOBJ(1).getNome());




    }
}