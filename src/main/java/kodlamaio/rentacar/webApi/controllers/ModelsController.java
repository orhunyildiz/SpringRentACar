package kodlamaio.rentacar.webApi.controllers;

import jakarta.validation.Valid;
import kodlamaio.rentacar.business.abstracts.ModelService;
import kodlamaio.rentacar.business.requests.CreateModelRequest;
import kodlamaio.rentacar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }
}
