    package com.kce.studentmanage.controller;

    import com.kce.studentmanage.exceptions.StudentNotFoundException;
    import com.kce.studentmanage.model.Student;
    import com.kce.studentmanage.repository.StudentRepository;
    import com.kce.studentmanage.service.StudentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/students")
    public class studentcontroller {

        @Autowired
        private StudentService studentService;


        @PostMapping
        public Student createStudent(@RequestBody Student student) {
            return studentService.addStudents(student);
        }


        @GetMapping
        public List<Student> getAllStudents() {
            return studentService.getAllStudents();
        }

        // Get a student by ID
        @GetMapping("/findbyemail/{email}")
        public Student getStudentById(@PathVariable String email) {
            try{

            Optional<Student> std =  studentService.getStudentByEmail(email);
            return std.get();
            }
            catch(Exception e ){
                System.out.println(e);
            }
        }

        @PutMapping("/{id}")
        public Student updateStudent(@PathVariable String id , @RequestBody Student student){
           try{

            Optional<Student>  std = studentService.findById(id);
            if(std.isPresent()) {
                Student std1 = std.get();
                std1.setName(student.getName());
                std1.setEmail(student.getEmail());
                studentService.addStudents(std1);
                return std1;
            }
            else{
                throw new RuntimeException("Student Not found....");
            }
           }catch(Exception e){
                throw new RuntimeException("Student Not found....");
               }

        }
        @GetMapping("findbyid/{id}")
        public Student finById(@PathVariable String id){
            try{

            Optional<Student> std=  studentService.findById(id);
            return std.get();
            }
            catch(StudentNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        @DeleteMapping("/{id}")
        public String deteStudent(@PathVariable String id){
            studentService.deleteById(id);
            return "Student deleted";

        }

    }
