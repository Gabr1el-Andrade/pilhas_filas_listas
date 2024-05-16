public class Pilha {
    private static class Nodo {
        int valor;
        Nodo proximo;

        Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Nodo topo;
    // Tamanho da pilha
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(int valor) {
        Nodo novoNodo = new Nodo(valor);
        novoNodo.proximo = topo;
        topo = novoNodo;
        tamanho++;
    }

    public int pop() {
        if (topo == null) {
            throw new RuntimeException("A pilha está vazia.");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public int top() {
        if (topo == null) {
            throw new RuntimeException("A pilha está vazia.");
        }
        return topo.valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        return tamanho;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo da pilha: " + pilha.top()); // Deve imprimir 30
        System.out.println("Tamanho da pilha: " + pilha.size()); // Deve imprimir 3
        System.out.println("A pilha está vazia? " + pilha.isEmpty()); // Deve imprimir false

        System.out.println(pilha.pop()); // Deve imprimir 30
        System.out.println(pilha.pop()); // Deve imprimir 20
        System.out.println(pilha.pop()); // Deve imprimir 10

        System.out.println("A pilha está vazia? " + pilha.isEmpty());// Deve imprimir true

        // Descomente a linha abaixo para testar o comportamento com a pilha vazia
        // System.out.println(pilha.top()); // Deve lançar uma exceção
    }
}
