public class Fila {

    private static class Nodo {
        int valor;
        Nodo proximo;

        Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Nodo inicio;
    private Nodo fim;

    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enqueue(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (fim != null) {
            fim.proximo = novoNodo;
        }
        fim = novoNodo;
        if (inicio == null) {
            inicio = novoNodo;
        }
        tamanho++;
    }

    public int dequeue() {
        if (inicio == null) {
            throw new RuntimeException("A fila está vazia.");
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return valor;
    }

    public int rear() {
        if (fim == null) {
            throw new RuntimeException("A fila está vazia.");
        }
        return fim.valor;
    }

    public int front() {
        if (inicio == null) {
            throw new RuntimeException("A fila está vazia.");
        }
        return inicio.valor;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Frente da fila: " + fila.front()); // Deve imprimir 10
        System.out.println("Fim da fila: " + fila.rear()); // Deve imprimir 30
        System.out.println("Tamanho da fila: " + fila.size()); // Deve imprimir 3
        System.out.println("A fila está vazia? " + fila.isEmpty()); // Deve imprimir false

        System.out.println(fila.dequeue()); // Deve imprimir 10
        System.out.println(fila.dequeue()); // Deve imprimir 20
        System.out.println(fila.dequeue()); // Deve imprimir 30

        System.out.println("A fila está vazia? " + fila.isEmpty()); // Deve imprimir true

        // Descomente a linha abaixo para testar o comportamento com a fila vazia
        // System.out.println(fila.front()); // Deve lançar uma exceção
    }
}
