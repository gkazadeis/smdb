package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.service.ActorService;
import openbet.codehub.smdb.transfer.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Actor>>> findAllActors(){
        return ResponseEntity.ok(ApiResponse.<List<Actor>>builder().data(actorService.findAll()).build());
    }

    @GetMapping(params = {"surname"})
    public ResponseEntity<ApiResponse<Actor>> findBySurname(@RequestParam String surname) {
        return ResponseEntity.ok(ApiResponse.<Actor>builder().data(actorService.findBySurname(surname)).build());
    }
}
