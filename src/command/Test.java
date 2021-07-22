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

    protected Command command;
    protected Id idProduct;

    public Test (Command command, Id idProduct){
        this.command = command;
        this.idProduct = idProduct;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        return null;
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
}
