/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dashboardproject.DashboardMediator;
import dashboardproject.DashboardMediatorImplementation;
import eu.hansolo.steelseries.gauges.DigitalRadial;
import gauges.FuelGauge;
import gauges.Gauge;
import gauges.LinearGauge;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author florinoprea
 */
public class GaugeFactoryTest {
    
    public GaugeFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createGauges method, of class GaugeFactory.
     */
    @Test
    public void testCreateGauges() {
        System.out.println("createGauges");
        String type = "FUEL_GAUGE";
        DashboardMediator med = new DashboardMediatorImplementation();
        Gauge expResult = new FuelGauge();
        Gauge result = GaugeFactory.createGauges(type, med);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of createLinearGauges method, of class GaugeFactory.
     */
    @Test
    public void testCreateLinearGauges() {
        System.out.println("createLinearGauges");
        String type = "";
        LinearGauge expResult = new LinearGauge();
        LinearGauge result = GaugeFactory.createLinearGauges(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of createDigitalGauges method, of class GaugeFactory.
     */
    @Test
    public void testCreateDigitalGauges() {
        System.out.println("createDigitalGauges");
        String type = "";
        DigitalRadial expResult = new DigitalRadial();
        DigitalRadial result = GaugeFactory.createDigitalGauges(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
