package com.example.dao;

import com.example.dao.impl.StudentDao;
import com.example.entity.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoTest {
    private static StudentDao dao;

    @BeforeAll
    static void setup() {
        dao = new StudentDao();
    }

    @BeforeEach
    void clean() {
        dao.deleteAll();
    }

    @Test
    void saveAndFindById() {
        Student student = new Student();
        student.setFirstName("Artem");
        student.setLastName("Chere");
        student.setEmail("artem@mail.com");

        dao.save(student);

        Student found = dao.findByEmail("artem@mail.com");

        assertNotNull(found);
        assertEquals("Artem", found.getFirstName());
    }

    @Test
    void updateStudent() {
        Student newStudent = new Student();
        newStudent.setFirstName("Artem");
        dao.save(newStudent);

        Student student = dao.findAll().get(0);
        student.setFirstName("Updated");

        Student updated = dao.update(student);

        assertEquals("Updated", updated.getFirstName());
    }

    @Test
    void deleteStudent() {
        Student student = new Student();
        student.setFirstName("ToDelete");
        student.setLastName("Test");
        student.setEmail("delete@mail.com");

        dao.save(student);

        boolean deleted = dao.deleteById(student.getId());

        assertTrue(deleted);
    }
}