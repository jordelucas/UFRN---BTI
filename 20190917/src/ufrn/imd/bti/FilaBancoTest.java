package ufrn.imd.bti;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaBancoTest {

    FilaBanco fila = null;

    @Before
    public void init () {
        fila = new FilaBanco();
    }

    @Test
    public void mustBeOrdered() {
        //Arrange
        Pessoa p1 = new Pessoa("Andre", 20);
        Pessoa p2 = new Pessoa("Moreira", 64);
        Pessoa p3 = new Pessoa("Filipe", 50);

        //Act
        fila.addPessoa(p1);
        fila.addPessoa(p2);
        fila.addPessoa(p3);

        //Assert
        assertSame(p2, fila.peek());
        fila.remove();
        assertSame(p3, fila.peek());
        fila.remove();
        assertSame(p1, fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void peekMustReturnElementHighesPriority () {
        //Arrange
        Pessoa node = new Pessoa("Fulano", 10);

        //Act
        fila.addPessoa(node);

        //Assert
        assertSame(node, fila.peek());
    }
}