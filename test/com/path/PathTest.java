package com.path;

import com.path.PathLib;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PathTest {
	@Test
	public void Test_isPathAvailable_returns_true_for_bangalore_to_singapore_route(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.isPathAvailable("Banglore" , "Singapore"));
	}

	@Test
	public void Test_isPathAvailable_returns_true_for_bangalore_to_seoul(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.isPathAvailable("Banglore" , "Seoul"));

	}
	@Test 
	public void Test_isPathAvailable_returns_true_for_singapore_to_tokyo(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.isPathAvailable("Singapore" , "Tokyo"));
	}
	@Test 
	public void Test_isPathAvailable_returns_true_for_beijing_to_singapore(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.isPathAvailable("Beijing" , "Singapore"));
	}
	@Test
	public void Test_isCityPresentInDatabase_returns_true_for_singapore(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.isCityPresentInDatabase("Singapore"));
	}
	@Test
	public void Test_giveRoutes_returns_routes_for_bangalore_to_singapore(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.giveRoutes("Banglore", "Singapore").equals("Banglore->Singapore"));
	}
	@Test
	public void Test_giveRoutes_returns_routes_for_bangalore_to_tokyo(){
		PathLib newPath = new PathLib();
		assertTrue(newPath.giveRoutes("Banglore", "Tokyo").equals("Banglore->Singapore->Seoul->Beijing->Tokyo"));
	}
	@Test
	public void Test_isCityPresentInDatabase_returns_false_for_chennai(){
		PathLib newPath = new PathLib();
		assertFalse(newPath.isCityPresentInDatabase("chennai"));
	}
}
