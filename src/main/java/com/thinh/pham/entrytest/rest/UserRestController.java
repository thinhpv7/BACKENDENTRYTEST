package com.thinh.pham.entrytest.rest;

import com.thinh.pham.entrytest.entity.Authority;
import com.thinh.pham.entrytest.entity.Candidate;
import com.thinh.pham.entrytest.entity.Employee;
import com.thinh.pham.entrytest.entity.User;
import com.thinh.pham.entrytest.service.CandidateService;
import com.thinh.pham.entrytest.service.EmployeeService;
import com.thinh.pham.entrytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRestController {

    private UserService userService;

    private CandidateService candidateService;

    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRestController(UserService userService, CandidateService candidateService, EmployeeService employeeService) {
        this.userService = userService;
        this.candidateService = candidateService;
        this.employeeService = employeeService;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/users/{userName}")
    public User getUserById(@PathVariable String userName) {
        return userService.findById(userName);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return userService.findById(user.getUserName());
    }

    @PostMapping("/users/login")
    public User login(@RequestBody User user) {
        if (userService.existsById(user.getUserName())) {
            User theUser = userService.findById(user.getUserName());
            System.out.println(passwordEncoder.matches(user.getPassword(), theUser.getPassword()));
            if (passwordEncoder.matches(user.getPassword(), theUser.getPassword().replace("{bcrypt}",""))) {
                user.setEnabled(true);
                userService.save(user);
                return theUser;
            } else {
                throw new RuntimeException("Đăng nhập thất bại");
            }
        } else {
            throw new RuntimeException("Đăng nhập thất bại");
        }
    }

    @PostMapping("/users/logout")
    public String logout(@RequestBody User user) {
        user.setEnabled(false);
        return "Logout thành công";
    }

    @PostMapping("/{personId}/{personType}/users")
    public String addUserIntoCandidate(@RequestBody User user, @PathVariable int personId,
                                       @PathVariable(required = false) String personType,
                                       @RequestParam("role") List<String> roles) {
        switch (personType.toLowerCase()) {
            case "c":
                if (candidateService.existsById(personId)) {
                    Candidate tempCandidate = candidateService.findById(personId);
                    getAllAuthorityFromPath(roles, user);
                    user.setCandidate(tempCandidate);
                    userService.save(user);
                    return "SUCCESS!";
                } else {
                    return "FAILED";
                }
            case "e":
                if (employeeService.existsById(personId)) {
                    Employee tempEmployee = employeeService.findById(personId);
                    getAllAuthorityFromPath(roles, user);
                    user.setEmployee(tempEmployee);
                    userService.save(user);
                    return "SUCCESS!";
                } else {
                    return "FAILED!";
                }
            default:
                return "Error!";
        }
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.save(user);
        return userService.findById(user.getUserName());
    }

    @DeleteMapping("/users/{userName}")
    public String deleteUser(@PathVariable String userName) {
        User tempUser = userService.findById(userName);

        if (tempUser == null) {
            throw new RuntimeException("User is not found - " + userName);
        }

        userService.deleteById(userName);
        return "Deleted user id - " + userName;
    }

    private void getAllAuthorityFromPath(List<String> roles, User user) {
        List<Authority> authorities = new ArrayList<>();
        for (String role : roles) {
            role = "ROLE_"+role;
            Authority authority = new Authority(role);
            authorities.add(authority);
        }
        user.setAuthorityList(authorities);
    }
}

