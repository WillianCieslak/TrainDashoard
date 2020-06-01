/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardproject;

import gauges.Gauge;
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
public class DashboardMediatorImplementationTest {
    
    public DashboardMediatorImplementationTest() {
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
     * Test of addGauge method, of class DashboardMediatorImplementation.
     */
    @Test
    public void testAddGauge() {
        System.out.println("addGauge");
        Gauge g = new Gauge();
        DashboardMediatorImplementation instance = new DashboardMediatorImplementation();
        instance.addGauge(g);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of increaseSpeed method, of class DashboardMediatorImplementation.
     */
    @Test
    public void testIncreaseSpeed() {
        System.out.println("increaseSpeed");
        Gauge g = new Gauge();
        double values = 3.0;
        DashboardMediatorImplementation instance = new DashboardMediatorImplementation();
        instance.increaseSpeed(g, values);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of brake method, of class DashboardMediatorImplementation.
     */
    @Test
    public void testBrake() {
        System.out.println("brake");
        Gauge g = new Gauge();
        DashboardMediatorImplementation instance = new DashboardMediatorImplementation();
        instance.brake(g);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
}
