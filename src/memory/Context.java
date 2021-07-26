package memory;

import declarations.Id;

import java.util.HashMap;
import java.util.Stack;

public class Context <T>{
    /**
     * A pilhaValor de blocos de contexto.
     */
    protected Stack<HashMap<Id, T>> pilha;

    /**
     * Construtor da classe.
     */
    public Context() {
        pilha = new Stack<HashMap<Id, T>>();
    }

    public void incrementa() {
        pilha.push(new HashMap<Id, T>());
    }

    public void restaura() {
        pilha.pop();
    }


    public void map(Id idArg, T valorId)  {
            HashMap<Id, T> aux = pilha.peek();

    }

    public T get(Id idArg) {
            T result = null;
            Stack<HashMap<Id, T>> auxStack = new Stack<HashMap<Id, T>>();
            while (result == null && !pilha.empty()) {
                HashMap<Id, T> aux = pilha.pop();
                auxStack.push(aux);
                result = aux.get(idArg);
            }
            while (!auxStack.empty()) {
                pilha.push(auxStack.pop());
            }
            if (result == null) {

            }
                return result;
    }

    protected Stack<HashMap<Id, T>> getPilha() {
        return pilha;
    }

    protected void setPilha(Stack<HashMap<Id, T>> pilha) {
        this.pilha = pilha;
    }
}
