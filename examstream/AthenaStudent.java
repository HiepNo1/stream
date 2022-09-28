package oop.examstream;

import java.time.LocalDate;
import java.util.List;

public class AthenaStudent {
    private int id;
    private String name;
    private String phone;
    private String idClass;
    private LocalDate dateOfBirth;
    private List<Double> score;
    private boolean paymentStatus;

    public AthenaStudent() {

    }

    public AthenaStudent(int id, String name, String phone, String idClass, LocalDate dateOfBirth, List<Double> score, boolean paymentStatus) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.idClass = idClass;
        this.dateOfBirth = dateOfBirth;
        this.score = score;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Double> getScore() {
        return score;
    }

    public void setScore(List<Double> score) {
        this.score = score;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "AthenaStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idClass='" + idClass + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", score=" + score +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
