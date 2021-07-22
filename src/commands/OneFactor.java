package commands;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.PreviouslyDeclaredPLException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import implementations.Id;
import implementations.PLDeclaration;
import implementations.ProductDeclaration;
import memory.CompilationEnvironment;

public class OneFactor {

    private PLDeclaration plDeclaration;
    private ProductDeclaration productDeclaration;

    public void OneFactor(){
        this.TypeCheckPL();
        this.TypeCheckProduct();


        int arr[] = {1, 2, 3, 4};
        System.out.println("Before update" + arr[2]);
        arr[2] = 9;//updating the value
        System.out.println("After update" + arr[2]);

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
}
