package kodlamaio.rentacar.webApi.controllers;

import jakarta.validation.Valid;
import kodlamaio.rentacar.business.abstracts.BrandService;
import kodlamaio.rentacar.business.requests.CreateBrandRequest;
import kodlamaio.rentacar.business.requests.UpdateBrandRequest;
import kodlamaio.rentacar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentacar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
