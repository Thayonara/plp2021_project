package command;

import implementations.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Lista;
import util.PLDefinition;
import util.ProductDefinition;

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
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        //recuperar produtos da suite
        List<ProductDeclaration> productDefinitions = executionEnvironment.getPoolTesting(command.getIdPl());

        System.out.println("Deve testar " + idProduct + ": " + isPresent(productDefinitions, idProduct));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        List<PLDefinition> list = new ArrayList<PLDefinition>(compilationEnvironment.getPLDefinitions().values());

        for (int i = 0; i < list.size();i++){
            PLDefinition plDefinition = list.get(i);
            Lista<ProductDeclaration> productDeclarationList = plDefinition.getProductDeclarations();
                if(plContains(productDeclarationList, idProduct)){
                    return this.command.typeCheck(compilationEnvironment);
                }
        }

        return false;

    }

    public boolean plContains(Lista<ProductDeclaration> productDeclarationList, Id productDefinition){
        boolean rt = false;

        while (productDeclarationList.getHead() != null){
            if(productDeclarationList.getHead().getProductName().getIdName().equalsIgnoreCase(productDefinition.getIdName())){
                return true;
            } else{
                if(productDeclarationList.getTail() != null){
                    plContains(productDeclarationList.getTail(), productDefinition);
                } else{
                    return false;
                }
            }
        }
        return rt;
    }

    public boolean isPresent(List<ProductDeclaration> productDefinitions,
                             Id idProduct) {
        boolean rt = false;
        for (int i = 0; i < productDefinitions.size(); i++) {
            if (productDefinitions.get(i).getProductName().equals(idProduct.getIdName())) {
                return true;
            }
        }

        return rt;
    }

}
