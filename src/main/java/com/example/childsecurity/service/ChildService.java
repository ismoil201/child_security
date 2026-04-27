package com.example.childsecurity.service;

import com.example.childsecurity.model.Child;
import com.example.childsecurity.model.User;
import com.example.childsecurity.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    public Child addChild(String name, String deviceId, User parent) {
        Child child = new Child();
        child.setName(name);
        child.setDeviceId(deviceId);
        child.setParent(parent);
        return childRepository.save(child);
    }

    public List<Child> getChildren(Long parentId) {
        return childRepository.findByParentId(parentId);
    }
}
