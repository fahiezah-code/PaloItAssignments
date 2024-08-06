package data;

public class AppointmentData {
    private String facility;
    private boolean shouldApplyHospitalAdm;
    private HealthcareProgram healthCareProgram;
    private String date;
    private String comment;

    public AppointmentData(String facility, boolean shouldApplyHospitalAdm, HealthcareProgram healthCareProgram, String date, String comment) {
        this.facility = facility;
        this.shouldApplyHospitalAdm = shouldApplyHospitalAdm;
        this.healthCareProgram = healthCareProgram;
        this.date = date;
        this.comment = comment;
    }

    public String getFacility() {
        return facility;
    }

    public boolean isShouldApplyHospitalAdm() {
        return shouldApplyHospitalAdm;
    }

    public HealthcareProgram getHealthCareProgram() {
        return healthCareProgram;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }
}
