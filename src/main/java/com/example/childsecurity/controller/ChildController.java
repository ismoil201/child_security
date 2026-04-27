package com.example.childsecurity.controller;

import com.example.childsecurity.model.Child;
import com.example.childsecurity.model.User;
import com.example.childsecurity.service.ChildService;
import com.example.childsecurity.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;
    private final UserService userService;

    @PostMapping("/child")
    public Child addChild(@RequestBody AddChildRequest request) {
        User parent = userService.findByEmail(request.getParentEmail());
        return childService.addChild(
                request.getName(),
                request.getDeviceId(),
                parent
        );
    }

    @GetMapping("/children")
    public List<Child> getChildren(@RequestParam String parentEmail) {
        User parent = userService.findByEmail(parentEmail);
        return childService.getChildren(parent.getId());
    }

    @Data
    static class AddChildRequest {
        private String name;
        private String deviceId;
        private String parentEmail;
    }
}
