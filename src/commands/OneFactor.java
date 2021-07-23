package commands;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.PreviouslyDeclaredPLException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import implementations.Id;
import implementations.PLDeclaration;
import implementations.ProductDeclaration;
import memory.CompilationEnvironment;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class OneFactor {

    private PLDeclaration plDeclaration;
    private ProductDeclaration productDeclaration;

    public void OneFactor(){
        boolean checkpl = this.TypeCheckPL();
        boolean product = this.TypeCheckProduct();

        if (checkpl == true && product == true){
            IteratorForPermKArrays r = new IteratorForPermKArrays();
            return;
        }
    }

    public boolean TypeCheckPL(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException {
        boolean pl;
        pl = plDeclaration.TypeCheck(compilationEnvironment) ;
        return pl;
    }

    public boolean TypeCheckProduct(CompilationEnvironment compilationEnvironment) {
        boolean product;
        product = plDeclaration.TypeCheck(compilationEnvironment) ;
        return product;
    }

//    Permutation and interator
    class PermIterator {

        private Iterator<Set<String>> it;

        PermIterator (Set<Set<String>> n) {
            it = n.iterator();
        }

        public Set<String> next() {
            return it.next();
        }

        public boolean hasNext() {
            return it.hasNext();
        }
    }

    class IteratorForPermKArrays {

        public static Set<Set<String>> multiply(String[] x, String[] y, String[] z) {
            List<List<String>> input = new ArrayList<>();
            input.add(Arrays.asList(x));
            input.add(Arrays.asList(y));
            input.add(Arrays.asList(z));
            Set<Set<String>> result = permK(input);
            return result;
        }

        
        public static Set<Set<String>> permK(List<List<String>> in) {
            final Set<Set<String>> out = new HashSet<Set<String>>();
            permUtil(new ArrayList<List<String>>(in), new HashSet<String>(), out);
            return out;
        }

        private static void permUtil(List<List<String>> in, Set<String> part, Set<Set<String>> out) {
            if (in.isEmpty()) {
                out.add(part);
                return;
            }
            if (out.contains(part))
                return;
            List<List<String>> nextIn = new ArrayList<List<String>>(in);
            for (String s : nextIn.remove(0)) {
                Set<String> nextPart = new LinkedHashSet<String>(part);
                nextPart.add(s);
                permUtil(nextIn, nextPart, out);
            }
        }

        public static void main(String[] args) {
            String[] x = {"a","b","c"};
            String[] y = {"p","q"};
            String[] z = {"r","s"};

            Set<Set<String>> result = multiply(x,y,z);
            System.out.println("Permutation of arrys:");
            PermIterator k = new PermIterator(result);
            while(k.hasNext()){
                System.out.println(k.next());
            }
        }
    }
}
