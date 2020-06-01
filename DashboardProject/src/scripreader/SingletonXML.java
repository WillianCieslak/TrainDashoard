/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripreader;

import dashboard.events.DashBoardEvent;
import dashboard.events.DashBoardEventListener;
import dashboardproject.DashboardMediatorImplementation;
import static dashboardproject.DashboardProject.speedGauge;

/**
 *
 * @author florinoprea, williancieslak
 */
public class SingletonXML {

    public static final String XML_SCRIPT = "dashboard_script.xml";

    //null instance
    private static SingletonXML instance = null;
    private DashboardMediatorImplementation dashMediator = new DashboardMediatorImplementation();

    //private constructor
    private SingletonXML() {

    }

    public static SingletonXML instance() {
        if (instance == null) {
            instance = new SingletonXML();
        }
        return instance;
    }

    public void runXMLScript() {
        try {
            dashboard.scripreader.DashboardEventGeneratorFromXML dbegXML = new dashboard.scripreader.DashboardEventGeneratorFromXML();

            // Register for speed events from the XML script file
            DashBoardEventListener dbelSpeed = new DashBoardEventListener() {
                @Override
                public void processDashBoardEvent(Object originator, DashBoardEvent dbe) {
                    speedGauge.increaseSpeed(Double.parseDouble(dbe.getValue()));
                }
            };
            dbegXML.registerDashBoardEventListener("speed", dbelSpeed);

            // Process the script file - it willgenerate events as it runs
            dbegXML.processScriptFile(XML_SCRIPT);

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
