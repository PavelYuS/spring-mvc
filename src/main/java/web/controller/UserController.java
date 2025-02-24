package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "users";
    }
    @GetMapping("/id")
    public String show(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String add(@ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userDao.save(user);
        return "redirect:/users";
    }
    @GetMapping("/id/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userDao.remove(id);
        return "redirect:/users";
    }
    @GetMapping("/id/edit")
    public String edit(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }
    @PostMapping("/id")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userDao.update(user);
        return "redirect:/users";
    }
}


