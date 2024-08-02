package kodlamaio.rentacar.business.concretes;

import kodlamaio.rentacar.business.abstracts.BrandService;
import kodlamaio.rentacar.business.requests.CreateBrandRequest;
import kodlamaio.rentacar.business.requests.UpdateBrandRequest;
import kodlamaio.rentacar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentacar.business.responses.GetByIdBrandResponse;
import kodlamaio.rentacar.business.rules.BrandBusinessRules;
import kodlamaio.rentacar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentacar.dataAccess.abstracts.BrandRepository;
import kodlamaio.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
