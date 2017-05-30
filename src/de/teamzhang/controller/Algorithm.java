package de.teamzhang.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import de.teamzhang.model.CoursesPersistence;
import de.teamzhang.model.PrioPersistence;
import de.teamzhang.model.Program;
import de.teamzhang.model.ProgramPersistence;
import de.teamzhang.model.RoomPersistence;
import de.teamzhang.model.Slot;
import de.teamzhang.model.SlotsPersistence;
import de.teamzhang.model.Teacher;
import de.teamzhang.model.TeachersPersistence;

public class Algorithm {

	// temporary holding the model
	// TODO: replace with real models
	private static CoursesPersistence courses = new CoursesPersistence();;
	private static PrioPersistence prios = new PrioPersistence();
	private static ProgramPersistence programs = new ProgramPersistence();
	private static RoomPersistence rooms = new RoomPersistence();
	private static SlotsPersistence slots = new SlotsPersistence();
	private static TeachersPersistence teachers = new TeachersPersistence();

	private static int optimalThreshold = 0;

	public static void main(String[] args) {
		generateMockData();
	}

	// 1. generate some testdata
	private static void generateMockData() {
		programs.generateMockData();
		teachers.generateMockData();
		rooms.generateMockData();
		slots.generate(35, rooms.list());
		prios.generateMockData(teachers.list());
		courses.generateMockData(programs.list(), teachers.list());

		printMap(programs.getPrograms());
		printMap(teachers.getTeachers());
		printMap(rooms.getRooms());
		printMap(slots.getSlots());
		printMap(prios.getPrios());
		printMap(courses.getCourses());

		weightPrios();

		calculateRandomSchedule();

		// Calculate based on the above slots
		// alle slots vergeben pro Tag x Tagen
		optimalThreshold = 700;
	}

	private static void weightPrios() {
		for (Teacher t : teachers.getTeachers().values()) {
			weightSingleSchedule(t);
		}
	}

	private static void weightSingleSchedule(Teacher t) {
		int[][] weightedDayTimeWishes = t.getWeightedDayTimeWishes();
		//0 = auf keinen fall
		//3 = top
		Random r = new Random();
		for (int days = 0; days < weightedDayTimeWishes.length; days++) {
			for (int time = 0; time < weightedDayTimeWishes[days].length; time++) {
				weightedDayTimeWishes[days][time] = r.nextInt(4);
				System.out.print(weightedDayTimeWishes[days][time] + "\t");
			}
		}

		//TODO: add prios to prioritize schedule

	}

	public static void printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}

	private static void calculateRandomSchedule() {
		Random r = new Random();
		for (Program p : programs.getPrograms().values()) {
			for (Slot s : slots.getSlots().values()) {
				System.out.println(s.getDay());
				System.out.println(s.getTime());
				System.out.println(s.getRoom());
				//teachers.getTeachers().get
				Teacher t = teachers.getTeachers().get(r.nextInt(teachers.getTeachers().size()));
				System.out.println();

			}
		}
	}

	// 2. function to generate a simple Ur-Plan
	private static void generateUrPlan() {
		// iterate slots
		// 		iterate teachers
		//			iterate courses
		// 				iterate rooms
		//					find a matching combination
		// should come up with VALID stupid plan
	}

	// helper to get current for comparing and
	// getting closer to the optimum
	private static int calculateCurrentThresholdValue() {
		// iterate slots and calc value
		// based on continuously used slots per day 
		// multiply with days
		return 7;
	}

	// 3. iterate plan and try to optimize per Teacher
	private static void climbHillWithTeachers() {
		// random pick and change slots
		// calc current threshold 
		// and compare to old
		// use if better
		// do XXX Times
		// break condition?
	}

	// 4. iterate plan and try to optimize per Programs
	private static void climbHillWithPrograms() {
		// same as in climbHillWithTeachers
	}

	public static void generatePlan() {
		// use and run above functions
	}

}
