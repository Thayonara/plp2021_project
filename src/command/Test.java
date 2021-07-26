package command;

import declarations.*;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import exceptions.UndeclaredProductException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Lista;
import util.PLDefinition;

import java.util.ArrayList;
import java.util.List;

public class Test implements Command{

    protected PoolGenerateCommand command;
    protected Id idProduct;

    public Test (PoolGenerateCommand command, Id idProduct){
        this.command = command;
        this.idProduct = idProduct;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException {

        command.execute(executionEnvironment);
        //recuperar produtos da suite
        List<ProductDeclaration> productDefinitions = executionEnvironment.getAllPools().get(command.getIdPl().getIdName());

        //recuperar produto
        Lista<ProductDeclaration> productDeclaration = executionEnvironment.getPlDefinition(command.getIdPl()).getProductDeclarations();
        ProductDeclaration productDeclaration1 = getProduct(productDeclaration, idProduct);
        if(productDeclaration1 != null){
            System.out.println("Deve testar " + idProduct + ": " + isPresent(productDefinitions, productDeclaration1));

        }


        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredProductException {
        List<PLDefinition> list = new ArrayList<PLDefinition>(compilationEnvironment.getPLDefinitions().values());

        for (int i = 0; i < list.size();i++){
            PLDefinition plDefinition = list.get(i);
            Lista<ProductDeclaration> productDeclarationList = plDefinition.getProductDeclarations();
            Lista<ProductDeclaration> productDeclaration = compilationEnvironment.getPlDefinition(command.getIdPl()).getProductDeclarations();
            ProductDeclaration productDeclaration1 = getProduct(productDeclaration, idProduct);
            if(productDeclaration1 != null){
                    return this.command.typeCheck(compilationEnvironment);
                }
            else{
                throw new UndeclaredProductException(idProduct);
            }
        }

        return false;

    }


    public ProductDeclaration getProduct(Lista<ProductDeclaration> productDeclarationList, Id productDefinition){

        while (productDeclarationList.getHead() != null){
            if(productDeclarationList.getHead().getProductName().getIdName().equalsIgnoreCase(productDefinition.getIdName())){
                return productDeclarationList.getHead();
            } else{
                if(productDeclarationList.getTail() != null){
                    productDeclarationList = productDeclarationList.getTail();
                } else{
                    return null;
                }
            }
        }
        return null;
    }


    public boolean isPresent(List<ProductDeclaration> productDefinitions,
                             ProductDeclaration product) {
        boolean rt = false;

        for (int i = 0; i < productDefinitions.size(); i++) {
            if (productDefinitions.get(i).getFeaturesSelected().equals(product.getFeaturesSelected())) {
                return true;
            }
        }

        return rt;
    }

}
