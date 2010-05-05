package org.jretrofit.reflect;

import junit.framework.TestCase;

import org.jretrofit.Reflect;
import org.jretrofit.fixture.Fixture;
import org.jretrofit.fixture.Person;

public class ReflectTest extends TestCase {
    private Fixture fixture;
    private Person ville;

    @Override
    protected void setUp() throws Exception {
        fixture = new Fixture();
        ville = fixture.ville();
    }

    public void testGetterCanBeInvoked() {
        Object result = Reflect.on(ville).method("getAge").invoke();
        assertEquals(new Integer(32), result);
    }

    // FIXME VP Failing test
    public void _testSetterCanBeInvoked() {
        Reflect.on(ville).method("setAge").invoke(new Integer(31));
        assertEquals(33, ville.getAge());
    }
}