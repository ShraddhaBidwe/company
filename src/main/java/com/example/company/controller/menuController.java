package com.example.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.menu;
import com.example.company.service.menuService;

@RestController
@RequestMapping("/menus")
public class menuController {
	
	@Autowired
    private menuService menus;
    
    @GetMapping("/getall")
    public List<menu> getAllMenus() {
        return menus.getAllMenus();
    }

    @GetMapping("/menuById/{menuId}")
    public menu getMenuById(@PathVariable Long menuId) {
        return menus.getMenuById(menuId);
    }

    @PostMapping("/add")
    public menu saveMenu(@RequestBody menu menu) {
        return menus.saveMenu(menu);
    }
    
    @PutMapping("/update/{menuId}")
    public String updateMenu(@PathVariable Long menuId,@RequestBody menu menu) {
        menus.updateMenu(menuId,menu);
        return "menu updated successfully";
    }

    @DeleteMapping("/delete/{menuId}")
    public String deleteMenu(@PathVariable Long menuId) {
    	menus.deleteMenu(menuId);
    	return "menu deleted successfully";
    }

}
