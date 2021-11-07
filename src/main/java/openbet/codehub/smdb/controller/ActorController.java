package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    /*
    @Override
	public BaseService<Actor, Long> getBaseService() {
		return actorService;
	}
     */

    @GetMapping("/all")
    public List<Actor> findAllActors(){
        return actorService.findAll();
    }

    @GetMapping(params = {"surname"})
    public Actor findById(@RequestParam String surname) {
        return actorService.findBySurname(surname);
    }
}
