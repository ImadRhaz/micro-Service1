package net.rhaz.customerservice.web;

import net.rhaz.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class configTestController {

@Autowired
    private GlobalConfig globalConfig;

@GetMapping("/globalConfig")
public GlobalConfig globalConfig(){
    return globalConfig;
}
}
