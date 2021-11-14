package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.service.ProducerService;
import openbet.codehub.smdb.transfer.ApiResponse;
import openbet.codehub.smdb.transfer.PersonDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producers")
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PersonDetails>>> findAllProducers(){
        return ResponseEntity.ok(ApiResponse.<List<PersonDetails>>builder().data(producerService.findAllLazy()).build());
    }
}
