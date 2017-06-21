package de.teamzhang.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class TeachersPersistence {

	private final Map<BigInteger, Teacher> teachers = new LinkedHashMap<BigInteger, Teacher>();
	private BigInteger id = new BigInteger("0");
	private Schedule schedule;
	private Random r = new Random();

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Map<BigInteger, Teacher> getTeachers() {
		return teachers;
	}

	public void create(final Teacher teacher) {
		//((Prio) teachers).setId(id);
		teacher.setId(id);
		teachers.put(id, teacher);
		id = id.add(new BigInteger("1"));
	}

	public Collection<Teacher> list() {
		return teachers.values();
	}

	public Teacher read(final int id) {
		return teachers.get(id);
	}

	public boolean update(final Teacher teacher) {
		boolean success = false;
		if (teachers.containsKey(teacher.getId())) {
			teachers.put(teacher.getId(), teacher);
			success = true;
		}
		return success;
	}

	public boolean delete(final int roomId) {
		boolean success = false;
		if (teachers.containsKey(roomId)) {
			teachers.remove(roomId);
			success = true;
		}
		return success;
	}

	// create useful teacher for learning
	public void generateMockData() {
		Program ba = new Program();
		ba.setName("Bachelor IMI");
		Program ma = new Program();
		ma.setName("Master IMI");

		Teacher t = new Teacher();
		t.setName("Lenz");
		t.setProf(true);
		t.setFreeHours(4);
		ArrayList<Course> courses = new ArrayList<Course>();

		Course c = new Course();
		c.setName("GT 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		Room room = new Room();
		room.setName("GT 1 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("GT 1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("GT 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("GT 1 M");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("GT 1 M Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Escher");
		t.setProf(false);
		t.setFreeHours(3);

		c = new Course();
		c.setName("MW SU");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("MW SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("MW �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("MW � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Vigerske");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("MA SU");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("MA SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Barthel");
		t.setProf(true);
		t.setFreeHours(5);

		c = new Course();
		c.setName("GDM SU");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("GDM SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("VCAT 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("VCAT 1 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("VC 1");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("VC 1 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("M�ller");
		t.setProf(false);
		t.setFreeHours(3);

		c = new Course();
		c.setName("CS SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("CS SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("CS �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("CS � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Dombach");
		t.setProf(false);
		t.setFreeHours(3);

		c = new Course();
		c.setName("GW");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("GW Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("GW �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("GW � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Thiel");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("MA SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("MA SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("AO");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("AO Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Beecher");
		t.setProf(false);
		t.setFreeHours(3);

		c = new Course();
		c.setName("INFO 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 1 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 1 �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Busch");
		t.setProf(true);
		t.setFreeHours(3);

		c = new Course();
		c.setName("PR SU SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("PR SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("BSAC");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("BSAC Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Kleinen");
		t.setProf(true);
		t.setFreeHours(6);

		c = new Course();
		c.setName("INFO 2/2 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 2/2 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 2/1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 2/1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 2/2 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 2/2 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 2/2 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 2/2 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("WT 4  /WT 5 ");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("WT 4  /WT 5  Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Sabri");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("NW SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("NW SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("NW �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("NW � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Obermann");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("GDM �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("GDM � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Strippgen");
		t.setProf(true);
		t.setFreeHours(5);

		c = new Course();
		c.setName("CG SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("CG SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("CG �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("CG � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("GTAT 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("GTAT 1 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("GTAT 1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("GTAT 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("O�wald");
		t.setProf(false);
		t.setFreeHours(3);

		c = new Course();
		c.setName("DB �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("DB � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("DB SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("DB SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Zhang");
		t.setProf(true);
		t.setFreeHours(6);

		c = new Course();
		c.setName("INFO 3 SU 1");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 3 SU 1 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 3 SU 2");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 3 SU 2 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 3 � 1");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 3 � 1 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("INFO 3 � 2");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("INFO 3 � 2 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("B 24.2 PM �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("B 24.2 PM � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Th�nen");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("3 D �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("3 D � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Jung");
		t.setProf(true);
		t.setFreeHours(6);

		c = new Course();
		c.setName("BV SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("BV SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("BV �");
		c.setSlotsNeeded(2);
		c.setProgram(ba);
		room = new Room();
		room.setName("BV � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("VC 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("VC 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("VC 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("VC 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("VC 4  2SU / 2 � 14t�");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("BVC 4  2SU / 2 � 14t Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Hezel");
		t.setProf(false);
		t.setFreeHours(1);

		c = new Course();
		c.setName("VCAT 1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("NW SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Kirschner");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("WTAT 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("WTAT 1 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("WTAT 1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("WTAT 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Baumeister");
		t.setProf(false);
		t.setFreeHours(5);

		c = new Course();
		c.setName("WT 1 SU");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("WT 1 SU Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("WT 1 �");
		c.setSlotsNeeded(1);
		c.setProgram(ba);
		room = new Room();
		room.setName("WT 1 � Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("M1 EP");
		c.setSlotsNeeded(1);
		c.setProgram(ma);
		room = new Room();
		room.setName("M1 EP Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		c = new Course();
		c.setName("M 1");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("M 1");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Steinicke");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("GT 2");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("GT 2 Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		courses = new ArrayList<Course>();
		t = new Teacher();
		t.setName("Schneider");
		t.setProf(false);
		t.setFreeHours(2);

		c = new Course();
		c.setName("Mathe");
		c.setSlotsNeeded(2);
		c.setProgram(ma);
		room = new Room();
		room.setName("Mathe Room");
		c.setRoom(room);
		c.setTeacher(t);
		courses.add(c);

		t.setCourses(courses);
		create(t);

		/*for (int i = 0; i < 8; i++) {
			Teacher t1 = new Teacher();
			t1.setName("Prof " + i);
			t1.setProf(true);
			create(t1);
		}
		for (int i = 0; i < 5; i++) {
			Teacher t1 = new Teacher();
			t1.setName("Teacher " + i);
			t1.setProf(false);
			create(t1);
		}*/
	}

}
