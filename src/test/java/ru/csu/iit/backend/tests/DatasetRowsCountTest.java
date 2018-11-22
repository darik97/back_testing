package ru.csu.iit.backend.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.DatasetModel;
import ru.csu.iit.backend.services.DatasetsService;

import static java.lang.Integer.parseInt;

public class DatasetRowsCountTest extends BaseTest {
//    private int datasetId;
    private DatasetsService datasetsService = new DatasetsService(properties);

    // Тест 1.
    @Test(groups = "id")
    public void checkDatasetId() {
        Assert.assertEquals(getDataSetId(), 1930);
    }

    // Тест 2.
    @Test(groups = "models")
    public void getRowsCount() {
        RequestSpecification requestSpecification = datasetsService.request()
                .build();
        Response response = datasetsService.executeRowCount(requestSpecification, getDataSetId());

        Assert.assertEquals(response.body().print(), "11");
    }
}
