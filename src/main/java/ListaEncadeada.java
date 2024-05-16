public class ListaEncadeada {
    private static class Nodo {
        int valor;
        Nodo proximo;

        Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Nodo inicio;

    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void push(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = novoNodo;
        } else {
            Nodo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNodo;
        }
        tamanho++;
    }

    public int pop() {
        if (inicio == null) {
            throw new RuntimeException("A lista está vazia.");
        }

        if (inicio.proximo == null) {
            int valor = inicio.valor;
            inicio = null;
            tamanho--;
            return valor;
        }

        Nodo atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        int valor = atual.proximo.valor;
        atual.proximo = null;
        tamanho--;
        return valor;
    }

    public void insert(int index, int valor) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }

        Nodo novoNodo = new Nodo(valor);
        if (index == 0) {
            novoNodo.proximo = inicio;
            inicio = novoNodo;
        } else {
            Nodo atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            novoNodo.proximo = atual.proximo;
            atual.proximo = novoNodo;
        }
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }

        if (index == 0) {
            inicio = inicio.proximo;
        } else {
            Nodo atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public int elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }

        Nodo atual = inicio;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        Nodo atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.push(10);
        lista.push(20);
        lista.push(30);

        lista.printList(); // Deve imprimir 10 -> 20 -> 30 -> null

        lista.insert(1, 15);
        lista.printList(); // Deve imprimir 10 -> 15 -> 20 -> 30 -> null

        System.out.println("Elemento no índice 2: " + lista.elementAt(2)); // Deve imprimir 20

        lista.remove(2);
        lista.printList(); // Deve imprimir 10 -> 15 -> 30 -> null

        System.out.println("Elemento removido: " + lista.pop()); // Deve imprimir 30
        lista.printList(); // Deve imprimir 10 -> 15 -> null

        System.out.println("Tamanho da lista: " + lista.size()); // Deve imprimir 2
    }
}
