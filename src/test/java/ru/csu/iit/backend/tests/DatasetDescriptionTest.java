package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.CaptionModel;
import ru.csu.iit.backend.services.DatasetsService;

public class DatasetDescriptionTest extends BaseTest{
    private DatasetsService datasetsService = new DatasetsService(properties);

    //Тест 3
    @Test(groups = "test")
    public void getDatasetDataQuery() {
        RequestSpecification requestSpecification = datasetsService.request()
                .getFields("Caption", "Description")
                .build();

        CaptionModel dataset = datasetsService.executeWithId(requestSpecification, getDataSetId());

        Assert.assertNotNull(dataset.getDescription());
        Assert.assertNotNull(dataset.getCaption());

    }
}
