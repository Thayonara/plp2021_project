package memory;

import implementations.Id;

import java.util.Map;
import java.util.Stack;

public class StackHandler {
    private StackHandler() {
    }

    public static Object getFromId (Stack stack, Id id) {
        Object result = null;
        Stack auxStack = new Stack();
        while (result == null && !stack.empty()) {
            Map aux = (Map) stack.pop();
            auxStack.push(aux);
            result = aux.get(id);
        }
        while (!auxStack.empty()) {
            stack.push(auxStack.pop());
        }
        if (result == null) {
        }

        return result;
    }


    public static void mapIdObject (Stack stack, Id id, Object object){
        Map aux = (Map) stack.peek();
        if (aux.put(id, object) != null) {
        }

    }

}
