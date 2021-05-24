package com.upgrad.hirewheels.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column( length = 50)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String password;
    @Column( length = 50, nullable = false,unique = true)
    private String email;
    @Column(length = 10,unique = true)
    private long mobileNo;
    @Column(length = 10)
    private int walletMoney;

    public User() {
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                ", walletMoney=" + walletMoney +
                //", bookings=" + bookings +
                ", role=" + role +
                '}';
    }
}