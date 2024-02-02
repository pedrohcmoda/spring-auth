package com.bytep.springauth.controller;
import com.bytep.springauth.entity.User;
import com.bytep.springauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private User register(@RequestBody @Validated User user){
        return userService.registerUser(user);
    }


//    @PutMapping("/{id}")
//    public UserDTO atualizaInfos(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
//        User user = userService.updateUser(usuarioDTO.toUsuario());
//        return new UsuarioDTO(usuario);
//    }
//
//    @PutMapping("/{id}")
//    public UserDTO atualizarSenha(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
//        User user = userService.updateUser(usuarioDTO.toUsuario());
//        return new UsuarioDTO(usuario);
//    }


    @DeleteMapping("/{id}")
    private void delete(@PathVariable UUID id){
        User user = new User();
        user.setId(id);
        userService.deleteUserByID(user);
    }

    @GetMapping("/{id}")
    private User getUserByID(@PathVariable UUID id){
        return userService.findUserByID(id);
    }


}
