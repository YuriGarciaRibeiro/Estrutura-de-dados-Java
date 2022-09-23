public class ListaDuplamenteEncadeada<T> {
    // Atributos
    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;


    //construtor
    public ListaDuplamenteEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    //metodos
    //metodo para adicionar um elemento em uma posição especifica
    public void adiciona(T elemento, int posicao){
        if(posicao < 0 || posicao > tamanho){
            throw new IllegalArgumentException("Posição inválida");
        }
        Celula nova = new Celula(elemento);
        if(tamanho == 0){
            this.primeiro = nova;
            this.ultimo = nova;
        } else if(posicao == 0){
            nova.setProximo(primeiro);
            this.primeiro.setAnterior(nova);
            this.primeiro = nova;

        } else if(posicao == tamanho){
            ultimo.setProximo(nova);
            nova.setAnterior(ultimo);
            this.ultimo = nova;
        } else {
            Celula anterior = recuperaCelula(posicao - 1);
            Celula proxima = anterior.getProximo();
            nova.setProximo(proxima);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
        }
        tamanho++;
    }

    //metodo para adicionar um elemento no inicio da lista
    public void adicionaInicio(T elemento){
        adiciona(elemento, 0);
    }

    //metodo para adicionar um elemento no final da lista
    public void adicionaFim(T elemento){
        adiciona(elemento, tamanho);
    }

    //metodo que verifica se exite um dado especifico na lista usando iterador
    public boolean contem(T elemento){
        Iterador<T> iterador = new Iterador<T>(primeiro);
        while(iterador.hasNext()){
            if(iterador.next().equals(elemento)){
                return true;
            }
        }
        return false;
    }

    //metodo que recupera um obejeto da lista usando iterador
    public T recuperaOBJ(int posicao){
        return (T) recuperaCelula(posicao).getElemento();
    }

    //metodo que recupera uma celula da lista
    public Celula recuperaCelula(int posicao) {
        Iterador<T> it = new Iterador<T>(primeiro);
        Celula atual = primeiro;
        int i = 0;
        while (it.hasNext()) {
            if (i == posicao) {
                return atual;
            }
            atual = atual.getProximo();
            i++;
        }
        return null;
    }

    //metodo que remove um elemento da lista
    public void remove(int posicao){
        if(posicao < 0 || posicao >= tamanho){
            throw new IllegalArgumentException("Posição inválida");
        }
        if(posicao == 0){
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
        } else {
            Celula anterior = recuperaCelula(posicao - 1);
            anterior.setProximo(anterior.getProximo().getProximo());
            if(posicao == tamanho - 1){
                ultimo = anterior;
                ultimo.setProximo(null);
            } else {
                Celula proxima = anterior.getProximo();
                proxima.setAnterior(anterior);
            }
        }
        tamanho--;
    }


    //metodo que remove um elemento do inicio da lista
    public void removeInicio(){
        remove(0);
    }

    //metodo que remove um elemento do final da lista
    public void removeFim(){
        remove(tamanho - 1);
    }

    //metodo que retorna o tamanho da lista
    public int tamanho(){
        return tamanho;
    }

    //metodo que limpa a lista
    public void limpa(){
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    //metodo que imprime a lista
    public void imprime(){
        Iterador<T> it = new Iterador<T>(primeiro);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }



    //testar proximo e anterior de celula
    public void testaCelula(){
        for(int i = 0; i < tamanho; i++){

            if(this.tamanho ==1){
                System.out.println("===================================================================");
                System.out.println("Celula: " + recuperaCelula(i).getElemento());
                System.out.println("===================================================================");
            }
            else if(i == 0){
                System.out.println("===================================================================");
                System.out.println("Celula: " + recuperaCelula(i).getElemento());
                System.out.println("Proximo: " + recuperaCelula(i).getProximo().getElemento());
                System.out.println("===================================================================");
            }
            else if(i == tamanho-1){
                System.out.println("===================================================================");
                System.out.println("Anterior: " + recuperaCelula(i).getAnterior().getElemento());
                System.out.println("Celula: " + recuperaCelula(i).getElemento());
                System.out.println("===================================================================");

            }
            else {
                System.out.println("===================================================================");
                System.out.println("Anterior: " + recuperaCelula(i).getAnterior().getElemento());
                System.out.println("Celula: " + recuperaCelula(i).getElemento());
                System.out.println("Proximo: " + recuperaCelula(i).getProximo().getElemento());
                System.out.println("===================================================================");
            }


        }
    }

}
