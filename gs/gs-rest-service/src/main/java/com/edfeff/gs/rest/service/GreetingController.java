package com.edfeff.gs.rest.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wpp
 */
//@RestController
@Controller
@ResponseBody
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //    @GetMapping("/greeting")
    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting PostMapping(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("PostMapping, %s!", name));
    }

    @PutMapping("/greeting")
    public Greeting PutMapping(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("PutMapping, %s!", name));
    }

    @DeleteMapping("/greeting")
    public Greeting DeleteMapping(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("DeleteMapping, %s!", name));
    }

    @PatchMapping("/greeting")
    public Greeting PatchMapping(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("PatchMapping, %s!", name));
    }
}
