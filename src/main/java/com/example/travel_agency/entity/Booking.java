package com.example.travel_agency.entity;

import com.example.travel_agency.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "booking") // Explicit table name
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
        private User user;

        @ManyToOne
        @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
        private Hotel hotel;

        @Column(nullable = false)
        private LocalDate checkInDate;

        @Column(nullable = false)
        private LocalDate checkOutDate;

        @Column(nullable = false)
        private double totalPrice;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false) // Ensure column is not null
        private BookingStatus status;

        public Booking() {
        }

        public Booking(Long id, User user, Hotel hotel, LocalDate checkInDate, LocalDate checkOutDate, double totalPrice, BookingStatus status) {
                this.id = id;
                this.user = user;
                this.hotel = hotel;
                this.checkInDate = checkInDate;
                this.checkOutDate = checkOutDate;
                this.totalPrice = totalPrice;
                this.status = status;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Hotel getHotel() {
                return hotel;
        }

        public void setHotel(Hotel hotel) {
                this.hotel = hotel;
        }

        public LocalDate getCheckInDate() {
                return checkInDate;
        }

        public void setCheckInDate(LocalDate checkInDate) {
                this.checkInDate = checkInDate;
        }

        public LocalDate getCheckOutDate() {
                return checkOutDate;
        }

        public void setCheckOutDate(LocalDate checkOutDate) {
                this.checkOutDate = checkOutDate;
        }

        public double getTotalPrice() {
                return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
                this.totalPrice = totalPrice;
        }

        public BookingStatus getStatus() {
                return status;
        }

        public void setStatus(BookingStatus status) {
                this.status = status;
        }

        @Override
        public String toString() {
                return "Booking{" +
                        "id=" + id +
                        ", user=" + user +
                        ", hotel=" + hotel +
                        ", checkInDate=" + checkInDate +
                        ", checkOutDate=" + checkOutDate +
                        ", totalPrice=" + totalPrice +
                        ", status=" + status +
                        '}';
        }
}
