package lk.ijse.apexeducationcenter.dto;

public class BatchDTO {
    private String batchId;
    private String batchName;
    private String crsId;
    private int batchYear;
    private int batchSeats;

    public BatchDTO() {
    }

    public BatchDTO(String batchId, String batchName, String crsId, int batchYear, int batchSeats) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.crsId = crsId;
        this.batchYear = batchYear;
        this.batchSeats = batchSeats;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    public int getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(int batchYear) {
        this.batchYear = batchYear;
    }

    public int getBatchSeats() {
        return batchSeats;
    }

    public void setBatchSeats(int batchSeats) {
        this.batchSeats = batchSeats;
    }
}
