package model;

import java.io.InputStream;
import java.sql.Timestamp;

public class Reimbursement {
    Integer reimbursementId;
    Double reimbursementAmount;
    Timestamp reimbursementSubmitted;
    Timestamp reimbursementResolved;
    String reimbursementDescription;
    InputStream reimbursementReceipt;
    Integer reimbursementAuthor;
    Integer reimbursementResolver;
    Integer reimbursementStatusId;
    Integer reimbursementTypeId;
    String reimbursementStatus;
    String reimbursementType;

    public Reimbursement() {
    }

    //For creating a reimbursement ticket
    public Reimbursement(Double reimbursementAmount, String reimbursementDescription,
                         InputStream reimbursementReceipt, Integer reimbursementAuthor, Integer reimbursementTypeId) {
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementReceipt = reimbursementReceipt;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementTypeId = reimbursementTypeId;
    }

    //For getting user(s) tickets
    public Reimbursement(Integer reimbursementId, Double reimbursementAmount,
                         Timestamp reimbursementSubmitted, Timestamp reimbursementResolved,
                         String reimbursementDescription, InputStream reimbursementReceipt,
                         Integer reimbursementAuthor, Integer reimbursementResolver,
                         Integer reimbursementStatusId, Integer reimbursementTypeId,
                         String reimbursementStatus, String reimbursementType) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementReceipt = reimbursementReceipt;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementType = reimbursementType;
    }

    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(Double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public Timestamp getReimbursementSubmitted() {
        return reimbursementSubmitted;
    }

    public void setReimbursementSubmitted(Timestamp reimbursementSubmitted) {
        this.reimbursementSubmitted = reimbursementSubmitted;
    }

    public Timestamp getReimbursementResolved() {
        return reimbursementResolved;
    }

    public void setReimbursementResolved(Timestamp reimbursementResolved) {
        this.reimbursementResolved = reimbursementResolved;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
    }

    public InputStream getReimbursementReceipt() {
        return reimbursementReceipt;
    }

    public void setReimbursementReceipt(InputStream reimbursementReceipt) {
        this.reimbursementReceipt = reimbursementReceipt;
    }

    public Integer getReimbursementAuthor() {
        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(Integer reimbursementAuthor) {
        this.reimbursementAuthor = reimbursementAuthor;
    }

    public Integer getReimbursementResolver() {
        return reimbursementResolver;
    }

    public void setReimbursementResolver(Integer reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    public Integer getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public void setReimbursementStatusId(Integer reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public Integer getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public void setReimbursementTypeId(Integer reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", reimbursementSubmitted=" + reimbursementSubmitted +
                ", reimbursementResolved=" + reimbursementResolved +
                ", reimbursementDescription='" + reimbursementDescription + '\'' +
                ", reimbursementReceipt=" + reimbursementReceipt +
                ", reimbursementAuthor=" + reimbursementAuthor +
                ", reimbursementResolver=" + reimbursementResolver +
                ", reimbursementStatusId=" + reimbursementStatusId +
                ", reimbursementTypeId=" + reimbursementTypeId +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                ", reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
