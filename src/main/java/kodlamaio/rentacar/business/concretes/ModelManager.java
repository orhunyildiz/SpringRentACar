package kodlamaio.rentacar.business.concretes;

import kodlamaio.rentacar.business.abstracts.ModelService;
import kodlamaio.rentacar.business.requests.CreateModelRequest;
import kodlamaio.rentacar.business.responses.GetAllModelsResponse;
import kodlamaio.rentacar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentacar.dataAccess.abstracts.ModelRepository;
import kodlamaio.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).toList();
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }
}
