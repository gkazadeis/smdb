package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.service.DirectorService;
import openbet.codehub.smdb.transfer.ApiResponse;
import openbet.codehub.smdb.transfer.PersonDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PersonDetails>>> findAllDirectors(){
        return ResponseEntity.ok(ApiResponse.<List<PersonDetails>>builder().data(directorService.findAllLazy()).build());
    }
}
