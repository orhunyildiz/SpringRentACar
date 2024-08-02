package kodlamaio.rentacar.business.abstracts;

import kodlamaio.rentacar.business.requests.CreateModelRequest;
import kodlamaio.rentacar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
