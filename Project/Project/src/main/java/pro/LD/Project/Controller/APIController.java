package pro.LD.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.LD.Project.Enum.Nationality;
import pro.LD.Project.Modell.User;
import pro.LD.Project.Repo.UserRepo;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getpage(){
        return "Kiscica";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "User saved";
    }

    @PutMapping(value = "/update/{i}")
    public String updateUser(@PathVariable long i, @RequestBody User user){
        User updatedUser = userRepo.findById(i).get();
        updatedUser.setFname(user.getFname());
        updatedUser.setLname(user.getLname());
        updatedUser.setAge(user.getAge());
        updatedUser.setNationality(Nationality.valueOf(user.getNationality().toString()));
        userRepo.save(updatedUser);
        return "User updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteuser = userRepo.findById(id).get();
        userRepo.delete(deleteuser);
        return "User deleted with the following id: " + id;
    }
}
