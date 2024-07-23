package clase;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    /* Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y
    una colección vacía de objetos tipo Persona, cuando se intentan agregar estas a la colección,
    el tamaño de la colección debería ser 2.
     */
    @BeforeAll
    static void antesTests(){
        System.out.println("Esto se ejecuta antes de todos los test");
    }

    @BeforeEach
    void antesDeCadaTest(){
        System.out.println("Esto se ejecuta antes de cada test");
    }

    @Test
    @DisplayName("Chequea que los nombres tengan mas de 4 letras")
    void caso1(){
        // DADO las instanciaciones de objetos que necesitamos para el test
        Persona persona1 = new Persona("Juan", 19);
        Persona persona2 = new Persona("Pedro", 19);
        Persona persona3 = new Persona("Ana", 19);
        Persona persona4 = new Persona("Luz", 19);
        Persona persona5 = new Persona("Julian", 19);
        Grupo grupoPersonas = new Grupo();
        // CUANDO se ejecuten los procesos que necesito para el test
        grupoPersonas.agregarPersona(persona1);
        grupoPersonas.agregarPersona(persona2);
        grupoPersonas.agregarPersona(persona3);
        grupoPersonas.agregarPersona(persona4);
        grupoPersonas.agregarPersona(persona5);

        // ENTONCES
        // assertEquals(2, grupoPersonas.getPersonas().size());
        assertTrue(grupoPersonas.getPersonas().size() == 2);
    }
    //Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años), el tamaño de la colección debería ser 3.

    @Test
    @DisplayName("Chequea que las edades sean mayores a 18")
    // @Disabled permite deshabilitar un test
    void caso2(){
        // DADO las instanciaciones de objetos que necesitamos para el test
        Persona persona1 = new Persona("Pedro", 18);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Pedro", 22);
        Persona persona4 = new Persona("Pedro", 14);
        Persona persona5 = new Persona("Julian", 32);
        Grupo grupoPersonas = new Grupo();
        // CUANDO se ejecuten los procesos que necesito para el test
        grupoPersonas.agregarPersona(persona1);
        grupoPersonas.agregarPersona(persona2);
        grupoPersonas.agregarPersona(persona3);
        grupoPersonas.agregarPersona(persona4);
        grupoPersonas.agregarPersona(persona5);

        // ENTONCES
        assertEquals(3, grupoPersonas.getPersonas().size());
    }

    @AfterAll
    static void despuesDeLosTest(){
        System.out.println("Esto se ejecuta despues de todos los test");
    }
    @AfterEach
    void despuesDeCadaTest(){
        System.out.println("Esto se ejecuta despues de cada test");
    }

}