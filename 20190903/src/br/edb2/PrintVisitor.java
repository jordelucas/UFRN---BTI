package br.edb2;

public class PrintVisitor implements NodeVisitor {

    @Override
    public void visit(Node node) {
        System.out.println(node.getValue());
    }
}
