package com.testsystem.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.testsystem.models.Group;
import com.testsystem.models.Student;
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
	 * Rating of student = (count*100/(count question*5))/10.
	 * 
	 * @param student 	the student
	 * @param testBase 	the database of test
	 * @return int 		the rating of student
	 */
	public static int getRatingStudent(User student, TestBase testBase) {
		int count = 0;
		for (int i = 0; i < testBase.getTests().size(); i++) {
			count += testBase.getTests().get(i).getStudentResult(student);
		}
		int rating = count * 2 / testBase.getTests().size();
		return rating;
	}
	
	/**
	 * Gets rating for group. 
	 * Rating of student = (count*100/(count question*5))/10.
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
                return (o1.getValue()).compareTo(o2.getValue()); 
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
