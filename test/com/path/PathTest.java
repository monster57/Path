package com.path;

import com.path.PathLib;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PathTest {
	@Test
	public void Test_isPathAvailable_returns_true_for_bangalore_to_singapore_route(){
		List<List<String>> path = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add("Banglore[India]");
        list1.add("Singapore[Singapore]");
        path.add(list1);
        PathLib newPath = new PathLib("paths.txt" , "cities.txt");
		assertTrue(newPath.getAllPath("Bangalore", "Singapore").equals(path));
	}

	@Test
	public void Test_isPathAvailable_returns_true_for_bangalore_to_seoul(){
        List<List<String>> path = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("Banglore[India]");
        list1.add("Singapore[Singapore]");
        list1.add("Seoul[South Korea]");
        path.add(list2);
        list2.add("Banglore[India]");
        list2.add("Singapore[Singapore]");
        list2.add("Dubai[UAE]");
        list2.add("Seoul[South Korea]");
        path.add(list2);
        PathLib newPath = new PathLib("paths.txt" , "cities.txt");
		assertTrue(newPath.getAllPath("Bangalore", "Seoul").equals(path));

	}
//	@Test
//	public void Test_isPathAvailable_returns_true_for_singapore_to_tokyo(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertTrue(newPath.isPathAvailable("Singapore" , "Tokyo"));
//	}
//	@Test
//	public void Test_isPathAvailable_returns_true_for_beijing_to_singapore(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertTrue(newPath.isPathAvailable("Beijing" , "Singapore"));
//	}
//
//    @Test
//	public void Test_isCityPresentInDatabase_returns_true_for_singapore(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertTrue(newPath.isCityPresentInDatabase("Singapore"));
//	}
//	@Test
//	public void Test_giveRoutes_returns_routes_for_bangalore_to_singapore(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertTrue(newPath.giveRoutes("Bangalore", "Singapore").equals("Bangalore[India]->Singapore[Singapore]"));
//	}
//	@Test
//	public void Test_giveRoutes_returns_routes_for_bangalore_to_tokyo(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertTrue(newPath.giveRoutes("Bangalore", "Tokyo").equals("Bangalore[India]->Singapore[Singapore]->Seoul[South Korea]->Beijing[China]->Tokyo[Japan]"));
//	}
//	@Test
//	public void Test_isCityPresentInDatabase_returns_false_for_chennai(){
//		PathLib newPath = new PathLib("paths.txt" , "cities.txt");
//		assertFalse(newPath.isCityPresentInDatabase("chennai"));
//	}
}
