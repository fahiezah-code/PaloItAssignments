package testcases;

import base.BaseTest;
import data.AppointmentData;
import data.HealthcareProgram;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MakeAppointmentTest extends BaseTest {

    @Test
    public void checkCreatedAppointmentDetails() {

        LoginPage loginPage = new CURAHomePage(driver)
                .load()
                .clickOnMakeAppointmentBtn();

        //at Login Page
        MakeAppointmentPage makeAppointment = loginPage.enterUsernameAndPassword()
                .clickOnLoginBtn();

        AppointmentData data = new AppointmentData("Seoul CURA Healthcare Center",
                true,
                HealthcareProgram.None,
                "12/10/2024",
                "This is optional comment."
                );

        //AppointmentPage
        AppointmentConfirmationPage appointmentConfirmationPage = makeAppointment
                .selectFacility(data.getFacility())
                .selectForApplyHospitalReadmission(data.isShouldApplyHospitalAdm())
                .selectMedicareProgram(data.getHealthCareProgram().ordinal())
                .selectAppointmentDate(data.getDate())
                .enterComment(data.getComment())
                .clickOnBookAppointmentBtn();

        HistoryPage hs = appointmentConfirmationPage.clickOnMenu()
                .clickOnHistory();


        String expected_applyHospitalAdm = data.isShouldApplyHospitalAdm()? "Yes" : "No";

        Assert.assertEquals(hs.getConfirmDate(), data.getDate());
        Assert.assertEquals(hs.getFacilityValue(), data.getFacility());
        Assert.assertEquals(hs.getApplyReadmission(), expected_applyHospitalAdm);
        Assert.assertEquals(hs.getProgram(), data.getHealthCareProgram().toString());
        Assert.assertEquals(hs.getComment(), data.getComment());

    }
}
