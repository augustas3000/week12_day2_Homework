import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;

    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    @Before
    public void before() {

        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Jungle", 5);
        playground = new Playground("KoooKooo", 4);
        rollerCoaster = new RollerCoaster("Cowabungaa", 3);

        candyflossStall = new CandyflossStall("Candy Candy", "Suga",ParkingSpot.A1, 1);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 2);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);

        ArrayList<IReviewed> attractions = new ArrayList<IReviewed>();
        attractions.add(dodgems);
        attractions.add(park);
        attractions.add(playground);
        attractions.add(rollerCoaster);


        ArrayList<IReviewed> stalls = new ArrayList<IReviewed>();
        stalls.add(candyflossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);

        themePark = new ThemePark(attractions,stalls);
    }


//    @Test
//    public void someTest() {
////        ISecurity castedPark = (ISecurity) park;
////        ISecurity castedTobacoStall = (ISecurity) tobaccoStall;
//        System.out.println(park instanceof ISecurity);
//        System.out.println(tobaccoStall instanceof ISecurity);
//
//    }

    @Test
    public void canReturnReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddVisitorsToAttractions() {
        Visitor visitor;
        visitor = new Visitor(14, 1.2, 40.0);
        themePark.visit(visitor, park);

        assertEquals(1,visitor.getVisitedAttractions().size());
        assertEquals(1, themePark.findAttraction(park).getVisitCount());
    }

    @Test
    public void canSummariseReviews() {
        HashMap<String,Integer> expected;
        expected = new HashMap<String, Integer>();
        expected.put("Bumper Cars", 5);
        expected.put("Jungle", 5);
        expected.put("Jacks Drum", 3);
        expected.put("Candy Candy", 1);
        expected.put("KoooKooo", 4);
        expected.put("Cowabungaa", 3);
        expected.put("Dream Cones", 2);

        assertTrue(expected.equals(themePark.review()));
    }

    @Test
    public void canGetAListOfAllowedStuff() {
        Visitor visitor;
        visitor = new Visitor(14, 1.2, 40.0);
        assertEquals(5, themePark.getAllAllowedFor(visitor).size() );
    }



}
