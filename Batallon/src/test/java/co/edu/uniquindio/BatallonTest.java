/* Clase Test para probar las funcionalidades de Batallon

    @author JhanCarloMC
    @since 04/08/2025
    LinkGitHub.com
*/

package co.edu.uniquindio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class BatallonTest {
private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());

    @Test
    @DisplayName("Prueba Funcionalidades Test")
    public void testUno(){
        LOG.info("Incio del metodo testUno");

        //Compara que dos elementos sean iguales(Esperado - Resultado)
        assertEquals(4,4);

        //Compara que dos elementos NO sean iguales
        assertNotEquals(1,"1");

        //Comprueba que una condicion sea TRUE
        assertTrue(1>0);

        //Comprueba que una condicion sea FALSE
        assertFalse(1<0);

        //Comprueba que un elemento sea null
        assertNull(null);

        //Comprueba que un elemento NO sea null
        assertNotNull(new Batallon("Cacique Calarca", "08"));

        LOG.info("Fin del metodo testUno");
    }

    @Test
    @DisplayName("Registro de Misiones Batallon")
    public void registrarMisionTest(){
        Batallon batallonTest = new Batallon("Cacique Calarca", "08");

        LinkedList<String> listPersonal = new LinkedList<>();
        listPersonal.add("Carlos");
        listPersonal.add("Tomas");
        listPersonal.add("Juan");

        VehiculoBlindado newVehiculoBlindado = new VehiculoBlindado("1","2000",
                1999, 1000.0, EstadoOperativo.DISPONIBLE, 10);
        LinkedList listTempo = batallonTest.getListMisiones();
        listTempo.add(newVehiculoBlindado);
        batallonTest.setListVehiculos(listTempo);

        boolean result = batallonTest.registrarMision(LocalDate.of(2025,8,4),
                "Genova",listPersonal,"1");

        assertTrue(result);
        //public boolean registrarMision(LocalDate fechaMision, String ubicacionMision,
    }

}