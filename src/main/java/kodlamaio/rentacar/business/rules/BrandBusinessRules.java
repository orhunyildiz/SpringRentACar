package kodlamaio.rentacar.business.rules;

import kodlamaio.rentacar.core.utilities.exceptions.BusinessException;
import kodlamaio.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists!");
        }
    }
}
