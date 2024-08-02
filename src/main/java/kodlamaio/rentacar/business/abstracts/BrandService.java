package kodlamaio.rentacar.business.abstracts;

import kodlamaio.rentacar.business.requests.CreateBrandRequest;
import kodlamaio.rentacar.business.requests.UpdateBrandRequest;
import kodlamaio.rentacar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
