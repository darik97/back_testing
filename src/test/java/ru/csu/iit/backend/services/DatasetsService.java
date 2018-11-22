package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.DatasetRequestBuilder;
import ru.csu.iit.backend.models.CaptionModel;
import ru.csu.iit.backend.models.DatasetModel;

import java.util.Properties;

public class DatasetsService extends BaseService {
    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder request() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetModel[] execute(RequestSpecification requestSpecification) {
        return execute(requestSpecification, "datasets");
    }

    public Response executeRow(RequestSpecification requestSpecification) {
        return requestSpecification.post("datasets");
    }

    public DatasetModel[] execute(RequestSpecification requestSpecification, String query) {
        return requestSpecification.post(query).then()
                .extract()
                .body().as(DatasetModel[].class);
    }

    public Response executeRowCount(RequestSpecification requestSpecification, int id) {
        return requestSpecification.get("datasets/" + id + "/count");
    }

    public CaptionModel executeWithId(RequestSpecification requestSpecification, int datasetId) {
        String request = "datasets/" + datasetId + "/";
        return requestSpecification.post(request).then()
                .extract()
                .body().as(CaptionModel.class);
    }
}
