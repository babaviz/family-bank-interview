package simple.rest.server.models;

import javax.persistence.*;

@Entity
@Table(name = "Payments",uniqueConstraints={@UniqueConstraint(columnNames = "reference")})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String reference;

    @Column
    private String channel;

    @Column
    private String paymentMethod;

    @Column
    private double amount;

    @Column
    private String registrationNumber;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String payment_method) {
        this.paymentMethod = payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String student_reg_no) {
        this.registrationNumber = student_reg_no;
    }
}
