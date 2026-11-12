package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.DuplicateEmailException;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("Email already registered: " + student.getEmail());
        }
        student.setId(null);
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);
        if (repository.existsByEmailAndIdNot(updated.getEmail(), id)) {
            throw new DuplicateEmailException("Email already registered: " + updated.getEmail());
        }
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        existing.setAge(updated.getAge());
        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        Student existing = getStudentById(id);
        repository.delete(existing);
    }

    public List<Student> getStudentsByCourse(String course) {
        return repository.findByCourseIgnoreCase(course);
    }
}
