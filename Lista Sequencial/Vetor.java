public class Vetor<T> {
    private T[] vetor;
    private int tamanho;

    private int quantidade = 0;

    // Construtor



    public Vetor(int tamanho){
        vetor = (T[]) new Object[tamanho];
        this.tamanho = tamanho;
    }





    //insere um elemento no vetor em determinada posicao usando o iterador
    public void inserir(T elemento, int posicao){

        if(posicao < 0){
            throw new IllegalArgumentException("Posição inválida");
        }
        else if ( posicao > tamanho){
            while (posicao > tamanho){
                redimensionar();
            }
        }
        else if(vetor[posicao] != null){
            throw new IllegalArgumentException("Posição já ocupada");
        }



        Iterador<T> it = new Iterador<T>(vetor);

        while (it.hasNext()) {
            System.out.println("it.posicao: " + (it.posicao + 1));
            System.out.println("posicao: " + posicao);
            if ((it.posicao  + 1) == posicao) {
                System.out.println('a');
                vetor[it.posicao] = elemento;
                quantidade++;
                break;
            }
            it.next();

        }

    };

    //adiciona um elemento no no inicio do vetor usando iterador
    public void adicionarInicio(T elemento){
        if(vetorCheio()){
            redimensionar();
        }
        //percorrera o vetor do fim para o inicio
        T valorFuturo;
        T valorAnterior = elemento;
        Iterador<T> it = new Iterador<T>(vetor);
        while(it.hasNext()){
            if(it.posicao > 0){
                if(it.posicao == tamanho){
                    System.out.println("fim");
                    vetor[it.posicao] = elemento;
                    quantidade++;
                    break;
                }
                //valor generico

                valorFuturo = vetor[it.posicao];
                vetor[it.posicao] = valorAnterior;
                valorAnterior = valorFuturo;
            }
            else{
                valorAnterior = vetor[it.posicao];

                vetor[it.posicao] = elemento;

            }

            it.next();
        }

    }

    //adiciona um elemento no final do vetor usando o iterador
    public void adicionarFinal(T elemento){
        Iterador<T> it = new Iterador<T>(vetor);
        if(vetorCheio()){
            redimensionar();
        }
        int i = 0;
        while(it.hasNext()){
            if (vetor[i] == null){
                vetor[i] = elemento;
                quantidade++;
                break;
            }
            i++;
        }

    }

    //verifica se tem algo naquela posição
    public boolean existeDado(int posicao){
        return vetor[posicao] != null;
    }

    //retorna o elemento naquela posição
    public T recupera(int posicao){
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return vetor[posicao];
    }

    //verifica se o vetor esta vazio
    public boolean vetorVazio(){
        return tamanho == 0;
    }

    //remove o item naquela posição usando iterador
    public void remove(int pos){
        if(pos < 0 || pos >= tamanho){
            throw new IllegalArgumentException("Posição inválida");
        }
        else{
            Iterador<T> it = new Iterador<T>(vetor);
            int i = 0;
            while(it.hasNext()){
                if(i == pos){
                    vetor[i] = null;
                    quantidade--;
                    break;
                }
                i++;
            }
        }
    }

    //remove o item do inicio do vetor usando o iterador
    public void removeInicio(){
        Iterador<T> it = new Iterador<T>(vetor);
        int i = 0;
        while(it.hasNext()){
            if(vetor[i] != null){
                vetor[i] = null;
                for(int j = i; j < tamanho; j++){
                    vetor[j] = vetor[j + 1];
                }
                quantidade--;
                break;
            }
            i++;
        }
    }
    //remove o item do final do vetor usando iterador
    public void removeFinal(){
        Iterador<T> it = new Iterador<T>(vetor);
        int i = 0;
        while(it.hasNext()){
            if(vetor[i] == null){
                vetor[i-1] = null;
                quantidade--;
                break;
            }
            i++;
        }
    }


    //retorna o tamanho do vetor
    public int tamanho(){
        return this.tamanho;
    };

    //retorna se a ultima posicao do vetor esta cheia
    public boolean vetorCheio(){
      return vetor[tamanho-1] != null;
    };

    //Método que retorna o valor de uma posição do vetor
    public T Recuperar(int pos) {
        if ((pos < 0 && pos > tamanho()) || (!existeDado(pos))) {
            throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        }
        return vetor[pos];
    }



    //limpa o vetor usando iterador
    public void limpar(){
        Iterador<T> it = new Iterador<T>(vetor);
        int i = 0;
        while(it.hasNext()){
            vetor[i] = null;
            i++;
        }
        quantidade = 0;
    }


    //dobra o tamanho do vetor usando iterador
    public void redimensionar(){
        T[] novoVetor = (T[]) new Object[tamanho*2];
        Iterador<T> it = new Iterador<T>(novoVetor);

        int i = 0;
        while(it.hasNext()){
            if (i < tamanho){
                novoVetor[i] = vetor[i];
            }
            else{
                novoVetor[i-1] = null;
            }
            i++;
            if (i == tamanho*2){
                break;
            }
        }
        vetor = novoVetor;
        tamanho = tamanho*2;



    };

    //adiciona no vetor usando o iterador
    public void AdicionarIt(T elemento) {

        if (tamanho() == quantidade) {
            redimensionar();
        }

        //Passamos o vetor como parâmetro para o iterador
        Iterador it = new Iterador(vetor);

        int i=0;
        while (it.hasNext()){ //percorrendo o vetor usando iterador
            if (it.next() == null) {
                vetor[i] =  elemento;
                quantidade++;
                break;
            }
            i++;
        }
    }
    //imprime elemento em uma posição
    public void posicao(int posicao){
        System.out.println(vetor[posicao]);
    }

    //imprime o vetor
    public void imprimir(){
        for(int i = 0; i < tamanho; i++){
            System.out.println(vetor[i]);
        }
    }

    //percorre o vetor usando o iterador
    public void percorrer(){
        Iterador<T> it = new Iterador<T>(vetor);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }








}
