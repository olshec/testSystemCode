package com.testsystem.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.testsystem.models.Group;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * Represents a RatingCalculator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class RatingCalculator {

	/**
	 * Creates a RatingCalculator.
	 */
	private RatingCalculator() {
	}

	/**
	 * Gets rating for student. 
	 * Max_range = 10.
	 * Max_point = count_question*5.
	 * Rating of student = (point*100/(count_question*Max_point))/Max_range = (point*2/(count_question)).
	 * 
	 * @param student 	the student
	 * @param testBase 	the database of test
	 * @return int 		the rating of student
	 */
	public static int getRatingStudent(User student, TestBase testBase) {
		StudentController stController = new StudentController(student);
		List<Test> listTest = stController.getTests(testBase);
		int point = 0;
		for (int i = 0; i < listTest.size(); i++) {
			point += listTest.get(i).getStudentResult(student);
		}
		int rating = point * 2 / listTest.size();
		return rating;
	}
	
	/**
	 * Gets rating for group. 
	 * 
	 * @param student						the student
	 * @param testBase 						the database of test
	 * @return HashMap<User, Integer> 		the rating of student
	 */
	public static HashMap<User, Integer> getRatingGroup(Group group, TestBase testBase, UserBase userBase) {
		List<User> listStudent = new GroupBaseController().getStudentByGroup(userBase, group);
		HashMap<User, Integer> groupRating=new HashMap<User, Integer>();
		for(int i=0;i<listStudent.size();i++) {
			groupRating.put(listStudent.get(i), 
					RatingCalculator.getRatingStudent(listStudent.get(i),testBase));
		}
		groupRating = sortByValue(groupRating);
		return groupRating;    	
	}
	
	// function to sort hashmap by values 
    private static HashMap<User, Integer> sortByValue(HashMap<User, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<User, Integer> > list = 
               new LinkedList<Map.Entry<User, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<User, Integer> >() { 
            public int compare(Map.Entry<User, Integer> o1,  
                               Map.Entry<User, Integer> o2) 
            { 
                return (o2.getValue().compareTo(o1.getValue())); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<User, Integer> temp = new LinkedHashMap<User, Integer>(); 
        for (Map.Entry<User, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
}
